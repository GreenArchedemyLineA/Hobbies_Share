package com.tenco.hobby.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.tenco.hobby.dto.CommentDto;
import com.tenco.hobby.dto.MessageFormDto;
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

		List<Board> boardList = boardService.readBoardList();
		List<BoardHobbies> hobbyList = boardService.readHobbyCategory();
		model.addAttribute("boardList", boardList);
		model.addAttribute("hobbyList", hobbyList);

		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		if (principal != null) {
			User infoList = userService.readInfo(principal.getId());
			if (infoList == null) {
				model.addAttribute("infoList", null);

			} else {
				model.addAttribute("infoList", infoList);
			}
		}

		return "/board/list";
	}

	/**
	 * @param id
	 * @param model
	 * @return 취미별 게시글 조회
	 */
	@GetMapping("/hobbyList/{id}")
	public String hobbyList(@PathVariable Long id, Model model) {

		List<Board> boardList = boardService.readHobbyList(id);
		List<BoardHobbies> hobbyList = boardService.readHobbyCategory();
		model.addAttribute("id", id);
		model.addAttribute("boardList", boardList);
		model.addAttribute("hobbyList", hobbyList);

		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		if (principal != null) {
			User infoList = userService.readInfo(principal.getId());
			if (infoList == null) {
				model.addAttribute("infoList", null);

			} else {
				model.addAttribute("infoList", infoList);
			}
		}
		// {id} => model
		// {id} => model

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
		if (writeFormDto.getHobbyId() == 0 || writeFormDto.getHobbyId().longValue() < 0) {
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

		Board board = boardService.readBoard(id);
		List<Comment> commentList = boardService.readComment(id);
		List<BoardHobbies> hobbyList = boardService.readHobbyCategory();
		model.addAttribute("board", board);
		model.addAttribute("comment", commentList);
		model.addAttribute("hobbyList", hobbyList);
		
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		if (principal != null) {
			User infoList = userService.readInfo(principal.getId());
			if (infoList == null) {
				model.addAttribute("infoList", null);

			} else {
				model.addAttribute("infoList", infoList);
			}
		}
		model.addAttribute(Define.PRINCIPAL, principal);

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

		User principal = (User) session.getAttribute(Define.PRINCIPAL);
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

		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		if (commentDto.getContent() == null || commentDto.getContent().isEmpty()) {
			throw new CustomRestfullException("내용을 입력해주세요", HttpStatus.BAD_REQUEST);
		}
		boardService.updateComment(commentDto, id, principal.getId());

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

		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		boardService.deletePost(id, principal.getId());
		return "redirect:/board/list";
	}

	@GetMapping("/delete-cmt/{id}/{boardId}")
	public String deleteComment(@PathVariable Long id, @PathVariable Long boardId) {

		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		boardService.deleteComment(id, principal.getId());
		return "redirect:/board/detail/" + boardId;
	}

	@GetMapping("/reportBoard/{id}")
	public ModelAndView reportBoard(@PathVariable Long id, HttpServletResponse response) throws IOException {

		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		boardService.createReportPost(id, principal.getId());

		View view = new View() {

			@Override
			public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
					throws Exception {
				response.setContentType("text/html; charset=UTF-8");
				response.setCharacterEncoding("UTF-8");
				PrintWriter outs = response.getWriter();
				outs.println("<html>");
				outs.println("<head>");
				outs.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
				outs.println("<script type='text/javascript'>");
				outs.println("alert('신고가 접수되었습니다');");
				outs.println("history.back();");
				outs.println("</script>");
				outs.println("</head>");
				outs.println("</body>");
				outs.println("</html>");
				outs.flush();
			}
		};
		return new ModelAndView(view);

	}

	@GetMapping("/reportCmt/{id}")
	public ModelAndView reportCmt(@PathVariable Long id, HttpServletResponse response) throws IOException {

		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		boardService.createReportCmt(id, principal.getId());

		View view = new View() {

			@Override
			public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
					throws Exception {
				response.setContentType("text/html; charset=UTF-8");
				response.setCharacterEncoding("UTF-8");
				PrintWriter outs = response.getWriter();
				outs.println("<html>");
				outs.println("<head>");
				outs.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
				outs.println("<script type='text/javascript'>");
				outs.println("alert('신고가 접수되었습니다');");
				outs.println("history.back();");
				outs.println("</script>");
				outs.println("</head>");
				outs.println("</body>");
				outs.println("</html>");
				outs.flush();
			}
		};
		return new ModelAndView(view);
	}

}
