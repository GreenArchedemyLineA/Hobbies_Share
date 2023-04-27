package com.tenco.hobby.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenco.hobby.repository.model.QandA;
import com.tenco.hobby.repository.model.User;
import com.tenco.hobby.service.UserService;
import com.tenco.hobby.util.Define;

/**
 * 로그인 하지 않고도 사이트 둘러 볼 수 있게 컨트롤러 분리
 * 
 * @author GGG
 *
 */
@Controller
@RequestMapping("/main")
public class MainController {

	@Autowired
	private UserService userService;

	@Autowired
	private HttpSession session;

	@GetMapping("/")
	public String main(Model model) {

		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		model.addAttribute(Define.PRINCIPAL, principal);
		if (principal != null) {
			User infoList = userService.readInfo(principal.getId());
			model.addAttribute("infoList", infoList);
		}
		return "/layout/index";
	}

	@GetMapping("/Q_A")
	public String q_n(Model model) {

		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		User infoList = userService.readInfo(principal.getId());

		model.addAttribute("infoList", infoList);

		List<QandA> questionList = userService.readQuestionList();
		model.addAttribute("questionList", questionList);

		return "/user/questionListForm";
	}

}
