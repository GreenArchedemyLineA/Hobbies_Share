package com.tenco.hobby.service;

import java.util.List;

import com.tenco.hobby.repository.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.hobby.dto.CommentDto;
import com.tenco.hobby.dto.MessageFormDto;
import com.tenco.hobby.dto.UpdateFormDto;
import com.tenco.hobby.dto.WriteFormDto;
import com.tenco.hobby.handler.exception.CustomRestfullException;
import com.tenco.hobby.repository.interfaces.BoardRepository;
import com.tenco.hobby.repository.interfaces.CommentRepository;
import com.tenco.hobby.repository.interfaces.HobbyRepository;
import com.tenco.hobby.repository.interfaces.MessageRepository;
import com.tenco.hobby.repository.interfaces.ReportRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private HobbyRepository hobbyRepository;
	@Autowired
	private ReportRepository reportRepository;
	@Autowired
	private MessageRepository messageRepository;

	/**
	 * 전체 글조회
	 */
	@Transactional
	public List<Board> readBoardList() {
		List<Board> list = boardRepository.findAll();
		return list;
	}

	/**
	 * 글선택조회
<<<<<<< HEAD
s	 * @param id
=======
	 * 
	 * @param id
>>>>>>> a3a909c5a8402219d01c06b6ad409e62ee2b68d3
	 */
	@Transactional
	public Board readBoard(Long id) {

		Board boardEntity = boardRepository.findById(id);
		return boardEntity;
	}

	/**
	 * @return 취미 전체조회
	 */
	@Transactional
	public List<BoardHobbies> readHobbyCategory() {
		List<BoardHobbies> list = hobbyRepository.findAllHobbies();
		return list;
	}

	/**
	 * @param id
	 * @return 취미카테고리 글 조회
	 */
	@Transactional
	public List<Board> readHobbyList(Long id) {
		List<Board> list = boardRepository.findByHobbyId(id);
		return list;
	}

	/**
	 * 댓글 조회
	 * @param boardId
	 * @return comment
	 */
	@Transactional
	public List<Comment> readComment(Long boardId) {

		List<Comment> commentList = commentRepository.findByBoardId(boardId);
		return commentList;
	}

	/**
	 * 글작성
	 * 
	 * @param writeFormDto
	 * @param principalId
	 */
	@Transactional
	public void createPost(WriteFormDto writeFormDto, Long principalId) {

		Board board = new Board();
		board.setTitle(writeFormDto.getTitle());
		board.setContent(writeFormDto.getContent());
		board.setUserId(principalId);
		board.setHobbyId(writeFormDto.getHobbyId());
		int resultRowCount = boardRepository.insert(board);
		if (resultRowCount != 1) {
			throw new CustomRestfullException("글쓰기를 실패했습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 댓글 작성
	 * 
	 * @param commentDto
	 * @param principalId
	 * @param boardId
	 */
	@Transactional
	public void createComment(CommentDto commentDto, Long principalId, Long boardId) {

		Comment comment = new Comment();
		comment.setContent(commentDto.getContent());
		comment.setUserId(principalId);
		comment.setBoardId(boardId);
		int resultRowCount = commentRepository.insert(comment);
		if (resultRowCount != 1) {
			throw new CustomRestfullException("댓글작성 실패하였습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 글 수정
	 * 
	 * @param updateFormDto
	 * @param principalId
	 * @param id
	 */
	@Transactional
	public void updatePost(UpdateFormDto updateFormDto, Long principalId, Long id) {

		Board boardEntity = boardRepository.findById(id);
		if (boardEntity == null) {
			throw new CustomRestfullException("해당 글이 존재하지 않습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (principalId != boardEntity.getUserId()) {
			throw new CustomRestfullException("수정 권한이 없습니다", HttpStatus.BAD_REQUEST);
		}
		boardEntity.setTitle(updateFormDto.getTitle());
		boardEntity.setContent(updateFormDto.getContent());
		boardEntity.setUserId(principalId);
		boardEntity.setHobbyId(updateFormDto.getHobbyId());
		boardEntity.setId(id);
		int resultRowCount = boardRepository.updateById(boardEntity);
		if (resultRowCount != 1) {
			throw new CustomRestfullException("글수정 실패하였습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * 댓글 수정
	 * 
	 * @param commentDto
	 * @param id
	 */
	@Transactional
	public void updateComment(CommentDto commentDto, Long id, Long principalId) {

		Comment commentEntity = commentRepository.findById(id);
		if (commentEntity == null) {
			throw new CustomRestfullException("해당 댓글이 존재하지 않습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (principalId != commentEntity.getUserId()) {
			throw new CustomRestfullException("수정권한이 없습니다", HttpStatus.BAD_REQUEST);
		}

		commentEntity.setContent(commentDto.getContent());
		commentEntity.setId(id);
		int resultRowCount = commentRepository.updateById(commentEntity);
		if (resultRowCount != 1) {
			throw new CustomRestfullException("댓글수정에 실패하였습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 글삭제
	 * 
	 * @param id
	 */
	@Transactional
	public void deletePost(Long id, Long principalId) {

		Board boardEntity = boardRepository.findById(id);
		if (boardEntity == null) {
			throw new CustomRestfullException("해당 글이 존재하지 않습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (principalId != boardEntity.getUserId()) {
			throw new CustomRestfullException("접근 권한이 없습니다", HttpStatus.BAD_REQUEST);
		}

		int resultRowCount = boardRepository.deleteById(id);
		if (resultRowCount != 1) {
			throw new CustomRestfullException("글삭제 실패하였습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 댓글 삭제
	 * 
	 * @param id
	 */
	@Transactional
	public void deleteComment(Long id, Long principalId) {
		
		Comment commentEntity = commentRepository.findById(id);
		if (commentEntity == null) {
			throw new CustomRestfullException("해당 댓글이 존재하지 않습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (principalId != commentEntity.getUserId()) {
			throw new CustomRestfullException("접근 권한이 없습니다", HttpStatus.BAD_REQUEST);
		}
		
		int resultRowCount = commentRepository.deleteById(id);
		if (resultRowCount != 1) {
			throw new CustomRestfullException("댓글삭제 실패하였습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/**
	 * 게시글 신고
	 * @param id
	 * @param principalId
	 */
	@Transactional
	public void createReportPost(Long id, Long principalId) {

		ReportBoard reportBoard = new ReportBoard();
		reportBoard.setReportUserId(principalId);
		reportBoard.setReportBoardId(id);

		int resultRowCount = reportRepository.insertReportBoard(reportBoard);
		if (resultRowCount != 1) {
			throw new CustomRestfullException("게시글 신고 실패하였습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 댓글 신고
	 * @param id
	 * @param principalId
	 */
	@Transactional
	public void createReportCmt(Long id, Long principalId) {

		ReportComment reportComment = new ReportComment();
		reportComment.setReportUserId(principalId);
		reportComment.setReportCommentId(id);

		int resultRowCount = reportRepository.insertReportComment(reportComment);
		if (resultRowCount != 1) {
			throw new CustomRestfullException("댓글 신고 실패하였습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * 쪽지 전송
	 * @param messageFormDto
	 * @param userId
	 * @param principalId
	 */
	@Transactional
	public void createMessage(MessageFormDto messageFormDto, Long userId, Long principalId) {
		
		Message message = new Message();
		message.setSender(principalId);
		message.setReceiver(userId);
		message.setMessage(messageFormDto.getMessage());
		
		int resultRowCount = messageRepository.insert(message);
		if(resultRowCount != 1) {
			throw new CustomRestfullException("쪽지 전송실패하였습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * 받은 메세지 확인
	 * @param principalId
	 * @return
	 */
	@Transactional
	public List<Message> readRMessage(Long principalId){
		
		List<Message> list = messageRepository.findByReceiver(principalId);
		
		return list;
	}
	@Transactional
	public List<Message> readSMessage(Long principalId){
		
		List<Message> list = messageRepository.findBySender(principalId);
		
		return list;
	}
	

	@Transactional
	public List<Board> readOtherUserBoardList(Long userId) {

		List<Board> otherUserBoardList = boardRepository.findForOtherUserBoardList(userId);

		return otherUserBoardList;
	}

	@Transactional
	public List<Comment> readOtherUserCommentList(Long userId) {

		List<Comment> otherUserCommentList = commentRepository.findForOtherUserComment(userId);

		return otherUserCommentList;
	}
}
