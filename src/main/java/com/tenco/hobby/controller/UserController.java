package com.tenco.hobby.controller;

import com.tenco.hobby.repository.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	public String signUp() {
		return "";
	}
	@GetMapping("/admin")
	public String adminSignUp(){
		return "user/adminLogin";
	}

	@PostMapping("/admin-proc")
	public String adminSignUpProc(User user){
		return null;
	}
}
