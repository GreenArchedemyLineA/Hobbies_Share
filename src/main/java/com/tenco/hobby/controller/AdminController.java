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
import org.springframework.web.bind.annotation.RequestParam;

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
	private UserService userService;
	private AdminService adminService;

	private int totalPosts;
	private final int POSTPERPAGE = 10;
	private final int DISPLAYPAGENUM = 10;
	private final int TOTALPAGE;
	@Autowired
	private HttpSession session;

	@Autowired
	public AdminController(
			UserService userService,
			AdminService adminService
			) {
		this.userService = userService;
		this.adminService = adminService;
		this.totalPosts = adminService.checkQandA().size();
		this.TOTALPAGE = ((this.totalPosts - 1) / this.POSTPERPAGE) + 1;
	}
	@GetMapping("/main")
	public String adminMain(Integer checkId, @RequestParam(name="boardId", required=false) Integer boardId, Model model) {
		if(checkId != null) {
			switch(checkId) {
			case 1:
				break;
			case 2:
				int currentPage = boardId == null ? 1 : boardId;
				int startPage = ((currentPage -1)/this.DISPLAYPAGENUM) * this.DISPLAYPAGENUM + 1;
				int endPage = (((currentPage -1)/this.DISPLAYPAGENUM)+1) * this.DISPLAYPAGENUM;
				if(this.TOTALPAGE < endPage) {
					endPage = this.TOTALPAGE;
				}
				System.out.println("start:"+startPage);
				model.addAttribute("size", ((this.totalPosts - 1)/10) +1);
				model.addAttribute("startPage", startPage);
				model.addAttribute("endPage", endPage);
				model.addAttribute("boardId", currentPage);
				List<QandA> qandAList = adminService.pagefindById(currentPage);
				model.addAttribute(Define.QANDA, qandAList);
				System.out.println(qandAList);
				break;
			}
		}
		
		return "admin/adminPage";
	}
	@GetMapping("/main/question/{id}")
	public String questionForm(@PathVariable Integer id, Model model) {
		System.out.println(id);
		QandA question = adminService.questionfindById(id);
		model.addAttribute("question", question);
		return "admin/answerForm";	
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
