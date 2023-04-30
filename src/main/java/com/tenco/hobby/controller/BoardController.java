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

import com.tenco.hobby.dto.CommentDto;
import com.tenco.hobby.dto.UpdateFormDto;
import com.tenco.hobby.dto.WriteFormDto;
import com.tenco.hobby.handler.exception.CustomRestfullException;
import com.tenco.hobby.repository.model.Board;
import com.tenco.hobby.repository.model.BoardHobbies;
import com.tenco.hobby.repository.model.Comment;
import com.tenco.hobby.repository.model.User;
import com.tenco.hobby.service.BoardService;
import com.tenco.hobby.service.UserService;
import com.tenco.hobby.util.Define;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private HttpSession session;
	@Autowired
	private BoardService boardService;

	/**
	 * 
	 * @param model
	 * @return 게시글 전체 조회
	 */
	@GetMapping("/list")
	public String list(Model model) {
		
		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		User infoList = userService.readInfo(principal.getId());
		if (infoList == null) {
			model.addAttribute("infoList", null);

		} else {
			model.addAttribute("infoList", infoList);
		}

		List<Board> boardList = boardService.readBoardList();
		List<BoardHobbies> hobbyList = boardService.readHobbyCategory();
		model.addAttribute("boardList", boardList);
		model.addAttribute("hobbyList", hobbyList);
		return "/board/list";
	}
	
	@GetMapping("/hobbyList/{id}")
	public String hobbyList(@PathVariable Long id, Model model) {
		
		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		User infoList = userService.readInfo(principal.getId());
		if (infoList == null) {
			model.addAttribute("infoList", null);

		} else {
			model.addAttribute("infoList", infoList);
		}
		// {id} => model 
		List<Board> boardList = boardService.readHobbyList(id);
		List<BoardHobbies> hobbyList = boardService.readHobbyCategory();
		model.addAttribute("id", id);
		model.addAttribute("boardList", boardList);
		model.addAttribute("hobbyList", hobbyList);		
		
		return "/board/hobbyList";		
	}	

	/**
	 * @return 글작성 폼
	 */
	@GetMapping("/write")
	public String write(Model model) {
		
		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		User infoList = userService.readInfo(principal.getId());
		if (infoList == null) {
			model.addAttribute("infoList", null);

		} else {
			model.addAttribute("infoList", infoList);
		}

		List<BoardHobbies> hobbyList = boardService.readHobbyCategory();
		model.addAttribute("hobbyList", hobbyList);
		return "/board/writeForm";
	}

	/**
	 * 글작성
	 * 
	 * @param writeFormDto
	 * @return 게시글 전체 조회
	 */
	@PostMapping("/write-proc")
	public String writeProc(WriteFormDto writeFormDto, Long principalId) {

		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		if (writeFormDto.getTitle() == null || writeFormDto.getTitle().isEmpty()) {
			throw new CustomRestfullException("제목을 입력하세요", HttpStatus.BAD_REQUEST);
		}
		if (writeFormDto.getContent() == null || writeFormDto.getContent().isEmpty()) {
			throw new CustomRestfullException("내용을 입력하세요", HttpStatus.BAD_REQUEST);
		}
		// 확인*******************************************************************
		if (writeFormDto.getHobbyId() == null) {
			throw new CustomRestfullException("취미를 선택해주세요", HttpStatus.BAD_REQUEST);
		}

		boardService.createPost(writeFormDto, principal.getId());
		return "redirect:/board/list";
	}

	/**
	 * @param id
	 * @param model
	 * @return 글 상세조회
	 */
	@GetMapping("/detail/{id}")
	public String detail(@PathVariable Long id, Model model) {
		
		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		User infoList = userService.readInfo(principal.getId());
		if (infoList == null) {
			model.addAttribute("infoList", null);

		} else {
			model.addAttribute("infoList", infoList);
		}

		Board board = boardService.readBoard(id);
		List<Comment> commentList = boardService.readComment(id);
		List<BoardHobbies> hobbyList = boardService.readHobbyCategory();		
		model.addAttribute("board", board);
		model.addAttribute("comment", commentList);
		model.addAttribute(Define.PRINCIPAL, principal);
		model.addAttribute("hobbyList", hobbyList);

		return "/board/detail";
	}

	/**
	 * 댓글 작성
	 * 
	 * @param commentDto
	 * @param boardId
	 * @return 글 상세페이지
	 */
	@PostMapping("/comment/{boardId}")
	public String comment(CommentDto commentDto, @PathVariable Long boardId) {

		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		if (commentDto.getContent() == null || commentDto.getContent().isEmpty()) {
			throw new CustomRestfullException("내용을 입력하시오", HttpStatus.BAD_REQUEST);
		}
		boardService.createComment(commentDto, principal.getId(), boardId);

		return "redirect:/board/detail/" + boardId;
	}

	/**
	 * @param id
	 * @param model
	 * @return 글 수정
	 * @return 글 수정 폼
	 */
	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model) {
		
		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		User infoList = userService.readInfo(principal.getId());
		if (infoList == null) {
			model.addAttribute("infoList", null);

		} else {
			model.addAttribute("infoList", infoList);
		}

		Board board = boardService.readBoard(id);
		List<BoardHobbies> hobbyList = boardService.readHobbyCategory();
		model.addAttribute("board", board);
		model.addAttribute("hobbyList", hobbyList);
		return "/board/updateForm";
	}

	/**
	 * 글 수정 폼
	 * 
	 * @param id
	 * @param updateFormDTO
	 * @return 글 전체 조회
	 */
	@PostMapping("/update-proc/{id}")
	public String updateProc(@PathVariable Long id, UpdateFormDto updateFormDTO) {

		User principal = (User) session.getAttribute("principal");
		if (updateFormDTO.getTitle() == null || updateFormDTO.getTitle().isEmpty()) {
			throw new CustomRestfullException("제목을 입력해주세요", HttpStatus.BAD_REQUEST);
		}
		if (updateFormDTO.getContent() == null || updateFormDTO.getContent().isEmpty()) {
			throw new CustomRestfullException("내용을 입력해주세요", HttpStatus.BAD_REQUEST);
		}

		boardService.updatePost(updateFormDTO, principal.getId(), id);
		return "redirect:/board/list";
	}

	@GetMapping("/update-cmt/{id}/{boardId}")
	public String updateComment(@PathVariable Long id, @PathVariable Long boardId, Model model) {
		
		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		User infoList = userService.readInfo(principal.getId());
		if (infoList == null) {
			model.addAttribute("infoList", null);

		} else {
			model.addAttribute("infoList", infoList);
		}

		Board board = boardService.readBoard(boardId);
		List<Comment> commentList = boardService.readComment(boardId);
		List<BoardHobbies> hobbyList = boardService.readHobbyCategory();		
		model.addAttribute("board", board);
		model.addAttribute("comment", commentList);
		model.addAttribute("cid", id);
		model.addAttribute("hobbyList", hobbyList);

		return "/board/updateCmtForm";

	}

	@PostMapping("/cmt-proc/{id}/{boardId}")
	public String updateCommentProc(@PathVariable Long id, @PathVariable Long boardId, CommentDto commentDto) {

		if (commentDto.getContent() == null || commentDto.getContent().isEmpty()) {
			throw new CustomRestfullException("내용을 입력해주세요", HttpStatus.BAD_REQUEST);
		}
		boardService.updateComment(commentDto, id);

		return "redirect:/board/detail/" + boardId;

	}

	/**
	 * 글 삭제
	 * 
	 * @param id
	 * @return 글 전체 조회
	 */
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {

		boardService.deletePost(id);
		return "redirect:/board/list";
	}

	@GetMapping("/delete-cmt/{id}/{boardId}")
	public String deleteComment(@PathVariable Long id, @PathVariable Long boardId) {

		boardService.deleteComment(id);
		return "redirect:/board/detail/" + boardId;
	}

}
