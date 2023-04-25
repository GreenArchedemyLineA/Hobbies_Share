package com.tenco.hobby.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenco.hobby.dto.CommentDto;
import com.tenco.hobby.dto.UpdateFormDto;
import com.tenco.hobby.dto.WriteFormDto;
import com.tenco.hobby.repository.model.Board;
import com.tenco.hobby.repository.model.Comment;
import com.tenco.hobby.repository.model.User;
import com.tenco.hobby.service.BoardService;
import com.tenco.hobby.util.Define;

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

	// 글 쓰기
	@GetMapping("/write")
	public String write() {

		return "/board/writeForm";
	}

	@PostMapping("/write-proc")
	// Todo 세션추가
	// public String writeProc(WriteFormDto writeFormDTO, Long principalId ) {
	public String writeProc(WriteFormDto writeFormDto) {

		// TODO
		// 세션
		User principal = (User) session.getAttribute("principal");

		if (writeFormDto.getTitle() == null || writeFormDto.getTitle().isEmpty()) {
			//
		}
		if (writeFormDto.getContent() == null || writeFormDto.getContent().isEmpty()) {
			//
		}

		// boardService.createPost(writeFormDTO, principal.getId());
		boardService.createPost(writeFormDto, 1);
		return "redirect:/board/list";
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return 글 상세조회
	 */
	@GetMapping("/detail/{id}")
	public String detail(@PathVariable Long id, Model model) {

		// User principal = (User) session.getAttribute(Define.PRINCIPAL);
		Board board = boardService.readBoard(id);
		List<Comment> commentList = boardService.readComment(id);
		model.addAttribute("board", board);
		model.addAttribute("commentList", commentList);

		return "/board/detail";
	}

	@PostMapping("/comment/{boardId}")
	public String comment(CommentDto commentDto, @PathVariable Long boardId) {
		
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		//Comment comment = boardService.createComment(commentDto, principal.getId(), boardId);
		boardService.createComment(commentDto, 1, boardId );

		return "redirect:/board/detail/" + boardId;
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return 글 수정
	 */
	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model) {

		Board board = boardService.readBoard(id);
		model.addAttribute("board", board);
		return "/board/updateForm";
	}

	@PostMapping("/update-proc/{id}")
	public String updateProc(@PathVariable Long id, UpdateFormDto updateFormDTO) {

		User principal = (User) session.getAttribute("principal");
		if (updateFormDTO.getTitle() == null || updateFormDTO.getTitle().isEmpty()) {
			//
		}
		if (updateFormDTO.getContent() == null || updateFormDTO.getContent().isEmpty()) {
			//
		}

		// boardService.updatePost(updateFormDTO, principal.getId(), id);
		boardService.updatePost(updateFormDTO, 1, id);
		return "redirect:/board/list";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {

		boardService.deletePost(id);
		return "redirect:/board/list";

	}

}
