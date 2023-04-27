package com.tenco.hobby.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {
	@GetMapping("/user")
	public String userErrorPage() {
		return "error/error";
	}
	
	@GetMapping("/admin")
	public String adminErrorPage() {
		return "error/adminError";
	}
}
