package com.tenco.hobby.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tenco.hobby.dto.CommentDto;
import com.tenco.hobby.dto.UpdateFormDto;
import com.tenco.hobby.dto.WriteFormDto;
import com.tenco.hobby.handler.exception.CustomRestfullException;
import com.tenco.hobby.repository.interfaces.BoardRepository;
import com.tenco.hobby.repository.interfaces.CommentRepository;
import com.tenco.hobby.repository.interfaces.HobbyRepository;
import com.tenco.hobby.repository.model.Board;
import com.tenco.hobby.repository.model.BoardHobbies;
import com.tenco.hobby.repository.model.Comment;
import com.tenco.hobby.repository.model.Hobby;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private HobbyRepository hobbyRepository;

	/**
	 * 전체 글조회
	 */
	public List<Board> readBoardList() {
		List<Board> list = boardRepository.findAll();
		return list;
	}

	/**
	 * 취미 전체조회
	 */
	public List<BoardHobbies> readHobbyList() {
		List<BoardHobbies> list = hobbyRepository.findAllHobbies();
		return list;
	}

	/**
	 * 글선택조회
	 * @param id
	 */
	public Board readBoard(Long id) {

		Board boardEntity = boardRepository.findById(id);
		return boardEntity;
	}

	/**
	 * 댓글 조회 
	 * @param boardId
	 * @return comment
	 */
	public List<Comment> readComment(Long boardId) {

		List<Comment> commentList = commentRepository.findByBoardId(boardId);
		return commentList;
	}

	/**
	 * 글작성
	 * @param writeFormDto
	 * @param principalId
	 */
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
	 * @param commentDto
	 * @param principalId
	 * @param boardId
	 */
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
	 * @param updateFormDto
	 * @param principalId
	 * @param id
	 */
	public void updatePost(UpdateFormDto updateFormDto, Long principalId, Long id) {

		Board board = new Board();
		board.setTitle(updateFormDto.getTitle());
		board.setContent(updateFormDto.getContent());
		board.setUserId(principalId);
		board.setHobbyId(updateFormDto.getHobbyId());
		board.setId(id);
		int resultRowCount = boardRepository.updateById(board);
		if (resultRowCount != 1) {
			throw new CustomRestfullException("글수정 실패하였습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * 댓글 수정
	 * @param commentDto
	 * @param id
	 */
	public void updateComment(CommentDto commentDto, Long id) {

		Comment comment = new Comment();
		comment.setContent(commentDto.getContent());
		comment.setId(id);
		int resultRowCount = commentRepository.updateById(comment);
		if (resultRowCount != 1) {
			throw new CustomRestfullException("댓글수정에 실패하였습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 글삭제
	 * @param id
	 */
	public void deletePost(Long id) {

		int resultRowCount = boardRepository.deleteById(id);
		if (resultRowCount != 1) {
			throw new CustomRestfullException("글삭제 실패하였습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 댓글 삭제
	 * @param id
	 */
	public void deleteComment(Long id) {
		int resultRowCount = commentRepository.deleteById(id);
		if (resultRowCount != 1) {
			throw new CustomRestfullException("댓글삭제 실패하였습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
