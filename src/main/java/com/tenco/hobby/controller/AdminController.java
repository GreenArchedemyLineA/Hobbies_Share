package com.tenco.hobby.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenco.hobby.dto.AdminSignInDTO;
import com.tenco.hobby.handler.exception.UnAuthorizedException;
import com.tenco.hobby.repository.model.User;
import com.tenco.hobby.service.UserService;
import com.tenco.hobby.util.Define;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService userService;

	@Autowired
	private HttpSession session;
	
	@GetMapping("/")
	public String adminMain() {
		return "admin/adminPage";
	}
	
	@GetMapping("/login")
	public String adminSignIn() {	
		return "admin/adminLogin";
	}

	@PostMapping("/admin-proc")
	public String adminSignInProc(AdminSignInDTO adminSignInDTO) {
		User user = userService.adminLogin(adminSignInDTO);
		session.setAttribute(Define.PRINCIPAL, user);
		return "redirect:/admin/";
	}
}
