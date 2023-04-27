package com.tenco.hobby.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.tenco.hobby.dto.AvatarSelecFormDto;
import com.tenco.hobby.dto.DropFormDto;
import com.tenco.hobby.dto.JoinUpFormDto;
import com.tenco.hobby.dto.LogInFormDto;
import com.tenco.hobby.dto.WriteQuestionFormDto;
import com.tenco.hobby.dto.UpdateInfoFormDto;
import com.tenco.hobby.dto.UpdatePwdFormDto;
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

//	@ModelAttribute(Define.PRINCIPAL)
//	public User setUser() {
//		User user = (User) session.getAttribute(Define.PRINCIPAL); 
//		return user;
//	}

	@GetMapping("/auth/myPage")
	public String myPage(Model model) {

		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		User infoList = userService.readInfo(principal.getId());
		model.addAttribute(Define.PRINCIPAL, principal);
		model.addAttribute("infoList", infoList);
		return "/layout/myPage";
	}

	/**
	 * 
	 * @return 회원 가입 페이지
	 */
	@GetMapping("/join-up")
	public String joinUp() {

		return "/user/joinUpForm";
	}

	/**
	 * 회원 가입 처리
	 * 
	 * @param joinUpFormDto
	 * @return 리다이렉트 로그인 페이지
	 */
	@PostMapping("/join-up")
	public String joinUpProc(JoinUpFormDto joinUpFormDto) {

//		유효성 검사
		if (joinUpFormDto.getEmail() == null || joinUpFormDto.getEmail().isEmpty()) {
			throw new CustomRestfullException("이메일을 입력해주세요.", HttpStatus.BAD_REQUEST);
		}

		if (joinUpFormDto.getPassword() == null || joinUpFormDto.getPassword().isEmpty()) {
			throw new CustomRestfullException("비밀번호를 입력해주세요.", HttpStatus.BAD_REQUEST);
		}

		if (joinUpFormDto.getUsername() == null || joinUpFormDto.getUsername().isEmpty()) {
			throw new CustomRestfullException("이름을 입력해주세요.", HttpStatus.BAD_REQUEST);
		}

		if (joinUpFormDto.getNickname() == null || joinUpFormDto.getNickname().isEmpty()) {
			throw new CustomRestfullException("이름을 입력해주세요.", HttpStatus.BAD_REQUEST);
		}

		if (joinUpFormDto.getBirth() == null) {
			throw new CustomRestfullException("생일을 입력해주세요", HttpStatus.BAD_REQUEST);
		}

		userService.createUser(joinUpFormDto);

		return "redirect:/user/log-in";
	}

	/**
	 * 
	 * @return 로그인 페이지
	 */
	@GetMapping("/log-in")
	public String logIn() {

		return "/user/logInForm";
	}

	/**
	 * 로그인 처리
	 * 
	 * @param logInFormDto
	 * @return 리다이렉트 메인 페이지
	 */
	@PostMapping("/log-in")
	public String logInProc(LogInFormDto logInFormDto) {

		if (logInFormDto.getEmail() == null || logInFormDto.getEmail().isEmpty()) {
			throw new CustomRestfullException("이메일을 입력해주세요.", HttpStatus.BAD_REQUEST);
		}

		if (logInFormDto.getPassword() == null || logInFormDto.getPassword().isEmpty()) {
			throw new CustomRestfullException("비밀번호를 입력해주세요", HttpStatus.BAD_REQUEST);
		}

		User principal = userService.logIn(logInFormDto);
		principal.setPassword(null);
		session.setAttribute(Define.PRINCIPAL, principal);

		return "redirect:/main/";
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return 프로필 수정 페이지
	 */
	@GetMapping("/auth/avatarSelec/{id}")
	public String avatarSelec(@PathVariable Long id, Model model) {

		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		User infoList = userService.readInfo(principal.getId());

		model.addAttribute("infoList", infoList);

		return "/user/avatarSelecForm";
	}

	/**
	 * 
	 * @param id
	 * @param avatarSelecFormDto
	 * @return 리다이렉트 마이페이지
	 */
	@PostMapping("/auth/avatarSelec/{id}")
	public String avatarSelecProc(@PathVariable Long id, AvatarSelecFormDto avatarSelecFormDto) {

		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		if (avatarSelecFormDto.getNickname() == null || avatarSelecFormDto.getNickname().isEmpty()) {
			throw new CustomRestfullException("닉네임을 입력해주세요.", HttpStatus.BAD_REQUEST);
		}

		MultipartFile file = avatarSelecFormDto.getFile();
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

				String uuid = UUID.randomUUID().toString();
				String fileName = uuid + "_" + file.getOriginalFilename();

				String uploadPath = Define.UPLOAD_DIRECTORY + File.separator + fileName;

				file.transferTo(new File(uploadPath));

				avatarSelecFormDto.setOriginFileName(file.getOriginalFilename());
				avatarSelecFormDto.setUploadFileName(fileName);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		userService.updateAvatar(avatarSelecFormDto);

		return "redirect:/user/auth/myPage";
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
		return "/user/updateInfoForm";
	}

	/**
	 * 회원 정보 수정 처리
	 * 
	 * @param updateInfoDto
	 * @return 메인 페이지
	 */
	@PostMapping("/auth/update")
	public String updateInfoProc(UpdateInfoFormDto updateInfoFormDto) {

		User principal = (User) session.getAttribute(Define.PRINCIPAL);

//		유효성 검사
		if (updateInfoFormDto.getEmail() == null || updateInfoFormDto.getEmail().isEmpty()) {
			throw new CustomRestfullException("이메일을 입력해주세요.", HttpStatus.BAD_REQUEST);
		}

		if (updateInfoFormDto.getPassword() == null || updateInfoFormDto.getPassword().isEmpty()) {
			throw new CustomRestfullException("비밀번호를 입력해주세요.", HttpStatus.BAD_REQUEST);
		}

		if (updateInfoFormDto.getUsername() == null || updateInfoFormDto.getUsername().isEmpty()) {
			throw new CustomRestfullException("이름을 입력해주세요.", HttpStatus.BAD_REQUEST);
		}

		if (updateInfoFormDto.getPhone() == null || updateInfoFormDto.getPhone().isEmpty()) {
			throw new CustomRestfullException("전화번호를 입력해주세요", HttpStatus.BAD_REQUEST);
		}

//		업데이트 기능 호출
		userService.updateInfo(updateInfoFormDto, session);

		return "redirect:/user/auth/myPage";

	}

	/**
	 * 
	 * @return 비밀 번호 변경 페이지
	 */
	@GetMapping("/auth/updatePwd/{id}")
	public String updatePwd(@PathVariable Long id, Model model) {

		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		User infoList = userService.readInfo(principal.getId());

		model.addAttribute("infoList", infoList);

		return "/user/updatePwdForm";
	}

	/**
	 * 비밀 번호 변경 처리
	 * 
	 * @param updatePwdFormDto
	 * @return 로그인 페이지
	 */
	@PostMapping("/auth/updatePwd/{id}")
	public String updatePwdProc(UpdatePwdFormDto updatePwdFormDto) {

		if (updatePwdFormDto.getPassword() == null || updatePwdFormDto.getPassword().isEmpty()) {
			throw new CustomRestfullException("현재 사용중인 비밀번호를 입력해주세요.", HttpStatus.BAD_REQUEST);
		}
		if (updatePwdFormDto.getNewPwd() == null || updatePwdFormDto.getNewPwd().isEmpty()) {
			throw new CustomRestfullException("새 비밀번호를 입력해주세요.", HttpStatus.BAD_REQUEST);
		}
		if (updatePwdFormDto.getCheckPwd() == null || updatePwdFormDto.getCheckPwd().isEmpty()) {
			throw new CustomRestfullException("비밀번호 확인을 입력해주세요.", HttpStatus.BAD_REQUEST);
		}

		userService.updatePwd(updatePwdFormDto, session);
		session.invalidate();
		return "redirect:/user/log-in";
	}

	/**
	 * 로그아웃 처리
	 * 
	 * @return 리다이렉트 메인
	 */
	@GetMapping("/auth/log-out")
	public String logOut() {
		session.invalidate();
		return "redirect:/main/";
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return 회원 탈퇴 페이지
	 */
	@GetMapping("/auth/drop/{id}")
	public String drop(@PathVariable Long id, Model model) {

		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		User infoList = userService.readInfo(principal.getId());

		model.addAttribute("infoList", infoList);

		return "/user/dropForm";
	}

	/**
	 * 회원 탈퇴 처리
	 * 
	 * @param dropFormDto
	 * @return 리다이렉트 메인
	 */
	@PostMapping("/auth/drop")
	public String dropProc(DropFormDto dropFormDto) {

		if (dropFormDto.getEmail() == null || dropFormDto.getEmail().isEmpty()) {
			throw new CustomRestfullException("이메일을 입력해주세요.", HttpStatus.BAD_REQUEST);
		}

		if (dropFormDto.getPassword() == null || dropFormDto.getPassword().isEmpty()) {
			throw new CustomRestfullException("비밀번호를 입력해주세요.", HttpStatus.BAD_REQUEST);
		}

		userService.deleteUser(dropFormDto, session);

		session.invalidate();
		return "redirect:/main/";
	}

	/**
	 * 
	 * @param writeQuestionFormDto
	 * @return 문의사항 작성 페이지
	 */
	@GetMapping("/auth/write-question")
	public String writeQuest(Model model) {

		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		User infoList = userService.readInfo(principal.getId());

		model.addAttribute("infoList", infoList);

		return "/user/writeQuestionForm";

	}

	@PostMapping("/auth/write-question")
	public String writeQuestion(WriteQuestionFormDto writeQuestionFormDto) {

		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		if (writeQuestionFormDto.getContent() == null || writeQuestionFormDto.getContent().isEmpty()) {
			throw new CustomRestfullException("내용을 입력해주세요", HttpStatus.BAD_REQUEST);
		}

		userService.createQuestion(writeQuestionFormDto, session);

		return "redirect:/main/Q_A";
	}

}
