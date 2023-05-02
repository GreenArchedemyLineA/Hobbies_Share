package com.tenco.hobby.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenco.hobby.handler.exception.CustomRestfullException;
import com.tenco.hobby.handler.exception.UnAuthorizedException;
import com.tenco.hobby.repository.model.Board;
import com.tenco.hobby.repository.model.PopularUserDTO;
import com.tenco.hobby.repository.model.QandA;
import com.tenco.hobby.repository.model.User;
import com.tenco.hobby.service.BoardService;
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
	private BoardService boardService;
	
	@Autowired
	private HttpSession session;

	@GetMapping("/")
	public String main(Model model) {

		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		List<Board> boardList = boardService.readBoardList();
		if(boardList.size() > 6) {
			boardList = boardList.subList(0, 6);
		}
		List<PopularUserDTO> popularUserList = userService.findPopularUserList();
		
		model.addAttribute(Define.PRINCIPAL, principal);
		model.addAttribute("popularList", popularUserList);
		model.addAttribute("boardList", boardList);
		if (principal != null) {
			User infoList = userService.readInfo(principal.getId());
			model.addAttribute("infoList", infoList);
		}
		
		return "/layout/index";
	}

	@GetMapping("/Q_A")
	public String q_n(Model model) {

		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		
		if (principal != null) {
			User infoList = userService.readInfo(principal.getId());
			model.addAttribute("infoList", infoList);
		}else {
			throw new UnAuthorizedException("로그인을 해주세요", HttpStatus.BAD_REQUEST);
		}

		List<QandA> questionList = userService.readQuestionList(principal.getId());
		model.addAttribute("questionList", questionList);

		return "/user/questionListForm";
	}

}
