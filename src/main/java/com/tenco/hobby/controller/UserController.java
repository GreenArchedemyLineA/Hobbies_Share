package com.tenco.hobby.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.tenco.hobby.dto.AvatarDto;
import com.tenco.hobby.dto.JoinUpDto;
import com.tenco.hobby.dto.LogInDto;
import com.tenco.hobby.dto.UpdateInfoDto;
import com.tenco.hobby.handler.exception.CustomRestfullException;
import com.tenco.hobby.repository.model.User;
import com.tenco.hobby.service.UserService;
import com.tenco.hobby.util.Define;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private HttpSession session;

	/**
	 * 
	 * @return 회원 가입 페이지
	 */
	@GetMapping("/join-up")
	public String joinUp() {

		return "/user/joinUp";
	}

	/**
	 * 회원 가입 처리
	 * 
	 * @param joinUpDto
	 * @return 리다이렉트 로그인 페이지
	 */
	@PostMapping("/join-up")
	public String joinUpProc(JoinUpDto joinUpDto) {

//		유효성 검사
		if (joinUpDto.getEmail() == null || joinUpDto.getEmail().isEmpty()) {
			throw new CustomRestfullException("이메일을 입력해주세요.", HttpStatus.BAD_REQUEST);
		}

		if (joinUpDto.getPassword() == null || joinUpDto.getPassword().isEmpty()) {
			throw new CustomRestfullException("비밀번호를 입력해주세요.", HttpStatus.BAD_REQUEST);
		}

		if (joinUpDto.getUsername() == null || joinUpDto.getUsername().isEmpty()) {
			throw new CustomRestfullException("이름을 입력해주세요.", HttpStatus.BAD_REQUEST);
		}

		if (joinUpDto.getBirth() == null) {
			throw new CustomRestfullException("생일을 입력해주세요", HttpStatus.BAD_REQUEST);
		}

		if (joinUpDto.getPhone() == null || joinUpDto.getPhone().isEmpty()) {
			throw new CustomRestfullException("전화번호를 입력해주세요", HttpStatus.BAD_REQUEST);
		}

		userService.createUser(joinUpDto);

		return "redirect:/user/log-in";
	}

	/**
	 * 
	 * @return 로그인 페이지
	 */
	@GetMapping("/log-in")
	public String logIn() {

		return "/user/logIn";
	}

	/**
	 * 로그인 처리
	 * 
	 * @return
	 */
	@PostMapping("/log-in")
	public String logInProc(LogInDto logInDto) {

		if (logInDto.getEmail() == null || logInDto.getEmail().isEmpty()) {
			throw new CustomRestfullException("이메일을 입력해주세요.", HttpStatus.BAD_REQUEST);
		}

		if (logInDto.getPassword() == null || logInDto.getPassword().isEmpty()) {
			throw new CustomRestfullException("비밀번호를 입력해주세요", HttpStatus.BAD_REQUEST);
		}

		User principal = userService.logIn(logInDto);
		principal.setPassword(null);
		session.setAttribute(Define.PRINCIPAL, principal);

		return "redirect:/main/";
	}

	@GetMapping("/auth/avatar")
	public String avatar() {

		return "/user/avatar";
	}

	/**
	 * 일단 이미지 올리는 것만
	 * 
	 * @param avatarDto
	 * @return
	 */
	@PostMapping("/auth/avatar")
	public String avatarSelect(AvatarDto avatarDto) {

		MultipartFile file = avatarDto.getFile();
		if (file.isEmpty() == false) {

			if (file.getSize() > Define.MAX_FILE_SIZE) {
				throw new CustomRestfullException("해당 이미지는 용량 초과입니다.", HttpStatus.BAD_REQUEST);
			}

			try {

				String saveDirectory = Define.UPLOAD_DIRECTORY;

				File dir = new File(saveDirectory);
				if (dir.exists() == false) {
					dir.mkdirs();
				}

				UUID uuid = UUID.randomUUID();
				String fileName = uuid + "_" + file.getOriginalFilename();

				String uploadPath = Define.UPLOAD_DIRECTORY + File.separator + fileName;

				File destination = new File(uploadPath);
				file.transferTo(destination);

				avatarDto.setOriginFileName(file.getOriginalFilename());
				avatarDto.setUploadFileName(fileName);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return "redirect:/";
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return 회원 정보 수정 페이지
	 */
	@GetMapping("/auth/update/{id}")
	public String updateInfo(@PathVariable Long id, Model model) {

		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		User infoList = userService.readInfo(principal.getId());
		if (infoList == null) {
			model.addAttribute("infoList", null);

		} else {
			model.addAttribute("infoList", infoList);
		}
		return "user/updateInfo";
	}

	/**
	 * 회원 정보 수정 처리
	 * 
	 * @param updateInfoDto
	 * @return 메인 페이지
	 */
	@PostMapping("/auth/update")
	public String updateInfoProc(UpdateInfoDto updateInfoDto) {

//		유효성 검사
		if (updateInfoDto.getEmail() == null || updateInfoDto.getEmail().isEmpty()) {
			throw new CustomRestfullException("이메일을 입력해주세요.", HttpStatus.BAD_REQUEST);
		}

		if (updateInfoDto.getPassword() == null || updateInfoDto.getPassword().isEmpty()) {
			throw new CustomRestfullException("비밀번호를 입력해주세요.", HttpStatus.BAD_REQUEST);
		}

		if (updateInfoDto.getUsername() == null || updateInfoDto.getUsername().isEmpty()) {
			throw new CustomRestfullException("이름을 입력해주세요.", HttpStatus.BAD_REQUEST);
		}

		if (updateInfoDto.getPhone() == null || updateInfoDto.getPhone().isEmpty()) {
			throw new CustomRestfullException("전화번호를 입력해주세요", HttpStatus.BAD_REQUEST);
		}

		return "redirect:/main/";

	}

	/**
	 * 로그아웃
	 * 
	 * @return
	 */
	@GetMapping("/auth/log-out")
	public String logOut() {
		session.invalidate();
		return "redirect:/main/";
	}

	@PostMapping("/auth/delete")
	public String deleteProc() {

		return "";
	}
}
