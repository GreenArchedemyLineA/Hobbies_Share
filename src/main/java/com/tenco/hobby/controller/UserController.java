package com.tenco.hobby.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenco.hobby.dto.JoinUpDto;
import com.tenco.hobby.dto.LogInDto;
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

	@GetMapping("/admin")
	public String adminSignUp() {

		return "user/adminLogin";
	}

	@PostMapping("/admin-proc")
	public String adminSignUpProc(User user) {
		return null;
	}

	/**
	 * 
	 * @return 회원 가입 페이지
	 */
	@GetMapping("/join-up")
	public String joinUp() {

		return "/user/joinUp";
	}

	/**
	 * 회원 가인 처리
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

		return "/layout/main";
	}

	/**
	 * 로그아웃
	 * 
	 * @return
	 */
	@GetMapping("/log-out")
	public String logOut() {
		session.invalidate();
		return "redirect:/layout/main";
	}

	public String deleteProc() {

		return "";
	}
}
