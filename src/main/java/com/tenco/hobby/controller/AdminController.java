package com.tenco.hobby.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenco.hobby.dto.AdminSignInDTO;
import com.tenco.hobby.handler.exception.UnAuthorizedException;
import com.tenco.hobby.repository.model.QandA;
import com.tenco.hobby.repository.model.User;
import com.tenco.hobby.service.AdminService;
import com.tenco.hobby.service.UserService;
import com.tenco.hobby.util.Define;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService userService;

	@Autowired
	private AdminService adminService;
	@Autowired
	private HttpSession session;
	
	@GetMapping("/main")
	public String adminMain(Integer checkId, Model model) {
		if(checkId != null) {
			switch(checkId) {
			case 1:
				break;
			case 2:
				List<QandA> qandAList = adminService.checkQandA();
				model.addAttribute(Define.QANDA, qandAList);
				System.out.println(qandAList);
				break;
			}
		}
		
		return "admin/adminPage";
	}
	@GetMapping("/question/{id}")
	public String questionForm(@PathVariable Integer id, Model model) {
		System.out.println(id);
		QandA question = adminService.questionfindById(id);
		model.addAttribute("question", question);
		return "admin/questionForm";
	}
	@GetMapping("/login")
	public String adminSignIn() {	
		return "admin/adminLogin";
	}

	@PostMapping("/admin-proc")
	public String adminSignInProc(AdminSignInDTO adminSignInDTO) {
		User user = userService.adminLogin(adminSignInDTO);
		session.setAttribute(Define.PRINCIPAL, user);
		return "redirect:/admin/main";
	}
}
