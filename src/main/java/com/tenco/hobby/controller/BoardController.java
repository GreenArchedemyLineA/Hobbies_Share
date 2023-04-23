package com.tenco.hobby.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenco.hobby.dto.WriteFormDTO;
import com.tenco.hobby.repository.model.Board;
import com.tenco.hobby.repository.model.User;
import com.tenco.hobby.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private HttpSession session;
	@Autowired
	private BoardService boardService;

	// 글 전체조회
	@GetMapping("/list")
	public String list(Model model) {

		List<Board> boardList = boardService.ReadBoardList();
		model.addAttribute("boardList", boardList);
		return "/board/list";
	}

	// 글 상세보기
	@GetMapping("/detail")
	public String detail() {

		return "/board/detail";
	}

	// 글 쓰기
	@GetMapping("/write")
	public String write() {

		return "/board/writeForm";
	}
	@PostMapping("/write-proc")
	public String writeProc(WriteFormDTO writeFormDTO) {
		
		// TODO
		// 세션 
		User principal = (User) session.getAttribute("principal");
		
		if(writeFormDTO.getTitle() == null || writeFormDTO.getTitle().isEmpty()) {
			// 
		}
		if(writeFormDTO.getContent() == null || writeFormDTO.getContent().isEmpty()) {
			//
		}
		
		// boardService.createPost(writeFormDTO, principal.getId());
		boardService.createPost(writeFormDTO, 1);
		return "/board/list";
		
	}

	// 글 수정하자
	@GetMapping("/update")
	public String update() {

		return "/board/updateForm";
	}

	@GetMapping("/delete")
	public String delete() {

		return "/board/list";

	}

}
