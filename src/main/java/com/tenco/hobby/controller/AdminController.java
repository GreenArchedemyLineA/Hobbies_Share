package com.tenco.hobby.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.tenco.hobby.dto.UpdateInfoFormDto;
import com.tenco.hobby.repository.model.ReportBoard;
import com.tenco.hobby.repository.model.ReportComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenco.hobby.dto.AdminSignInDTO;
import com.tenco.hobby.dto.AnswerFormDTO;
import com.tenco.hobby.dto.UpdateAdminInfoFormDto;
import com.tenco.hobby.repository.model.Board;
import com.tenco.hobby.repository.model.Comment;
import com.tenco.hobby.repository.model.QandA;
import com.tenco.hobby.repository.model.User;
import com.tenco.hobby.service.AdminService;
import com.tenco.hobby.service.BoardService;
import com.tenco.hobby.service.UserService;
import com.tenco.hobby.util.Define;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private UserService userService;
	private BoardService boardService;
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
			BoardService boardService,
			AdminService adminService
			) {
		this.userService = userService;
		this.boardService = boardService;
		this.adminService = adminService;
		this.totalPosts = adminService.checkQandA().size();
		this.TOTALPAGE = ((this.totalPosts - 1) / this.POSTPERPAGE) + 1;
	}
	@GetMapping("/main")
	public String adminMain(Integer checkId, @RequestParam(name="boardId", required=false) Integer boardId, Model model) {
			if(checkId == null) checkId = 1;
			System.out.println(checkId);
			switch(checkId) {
			case 1:
				List<User> userList = adminService.allUserList();
				System.out.println(userList);
				model.addAttribute("userList", userList);
				break;
			case 2:
				int currentPage = boardId == null ? 1 : boardId;
				int startPage = ((currentPage -1)/this.DISPLAYPAGENUM) * this.DISPLAYPAGENUM + 1;
				int endPage = (((currentPage -1)/this.DISPLAYPAGENUM)+1) * this.DISPLAYPAGENUM;
				if(this.TOTALPAGE < endPage) {
					endPage = this.TOTALPAGE;
				}
				model.addAttribute("size", ((this.totalPosts - 1)/10) +1);
				model.addAttribute("startPage", startPage);
				model.addAttribute("endPage", endPage);
				model.addAttribute("boardId", currentPage);
				List<QandA> qandAList = adminService.pagefindById(Integer.toUnsignedLong(currentPage));
				model.addAttribute(Define.QANDA, qandAList);
				System.out.println(qandAList);
				break;
			case 3:
				List<ReportBoard> reportBoardList = adminService.findAllReportBoard();
				model.addAttribute("reportBoard", reportBoardList);
				break;
			case 4:
				List<ReportComment> reportCommentList = adminService.findAllReportComment();
				model.addAttribute("reportComment", reportCommentList);
				break;
			}
		return "admin/adminPage";
	}
	@GetMapping("/main/question/{id}")
	public String questionForm(@PathVariable Long id, Model model) {
		System.out.println(id);
		QandA question = adminService.questionfindById(id);
		User user = userService.readInfo(question.getId());
		model.addAttribute("question", question);
		model.addAttribute("user", user);
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
	
	@GetMapping("/main/user/{id}")
	public String userManage(@PathVariable Long id, Model model) {
		User user = userService.readInfo(id);
		model.addAttribute("user", user);
		return "admin/userManage";
	}
	@PostMapping("/main/user/{id}")
	public String userManage(@PathVariable Long id, AnswerFormDTO answerFormDTO) {
		answerFormDTO.setQuestionId(id);
		answerFormDTO.setUserId(((User)session.getAttribute(Define.PRINCIPAL)).getId());
		adminService.createAnswer(answerFormDTO);
		return "redirect:/admin/main";
	}

	// 유저 회원 수정(관리자)
	@PostMapping("/main/usermanage/{id}")
	public String userManiging(@PathVariable Long id, UpdateAdminInfoFormDto updateAdminInfoFormDto){
		// 수정 필요 userService.updateInfo(updateInfoFormDto, id);
		adminService.updateUserInfo(updateAdminInfoFormDto);
		return "redirect:/admin/main/user/"+id;
	}

	@GetMapping("/main/reportBoard/{id}")
	public String detailReportBoard(@PathVariable Long id, Model model) {
		ReportBoard reportBoard = adminService.findReportBoard(id);
		User user = userService.readInfo(reportBoard.getReportUserId());
		Board board = boardService.readBoard(reportBoard.getReportBoardId());
		model.addAttribute("user", user);
		model.addAttribute("board", board);
		return "admin/reportBoard";
	}
	@GetMapping("/main/reportComment/{id}")
	public String detailReportComment(@PathVariable Long id, Model model){
		ReportComment reportComment = adminService.findReportComment(id);
		User user = userService.readInfo(reportComment.getReportUserId());
		Comment comment = boardService.findCommentById(reportComment.getReportCommentId());
		model.addAttribute("user", user);
		model.addAttribute("comment", comment);
		return "admin/reportComment";
	}
	@PostMapping("/main/reportBoard/{id}")
	public String checkReportBoard(@PathVariable Long id){
		ReportBoard reportBoard = adminService.findReportBoard(id);
		User user = userService.readInfo(reportBoard.getReportUserId());
		boardService.deletePost(reportBoard.getId(), user.getId());
		return "redirect:/admin/main?checkId=3";
	}

	@PostMapping("/main/reportComment/{id}")
	public String checkReportComment(@PathVariable Long id){
		ReportComment reportComment = adminService.findReportComment(id);
		User user = userService.readInfo(reportComment.getReportUserId());
		boardService.deleteComment(reportComment.getId(), user.getId());
		return "redirect:/admin/main?checkId=4";
	}
}
