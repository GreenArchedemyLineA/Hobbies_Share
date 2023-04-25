package com.tenco.hobby.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenco.hobby.dto.CommentDto;
import com.tenco.hobby.dto.UpdateFormDto;
import com.tenco.hobby.dto.WriteFormDto;
import com.tenco.hobby.repository.interfaces.BoardRepository;
import com.tenco.hobby.repository.interfaces.CommentRepository;
import com.tenco.hobby.repository.model.Board;
import com.tenco.hobby.repository.model.Comment;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	@Autowired
	private CommentRepository commentRepository;

	public List<Board> ReadBoardList() {

		List<Board> list = boardRepository.findAll();

		return list;

	}

	public Board readBoard(Long id) {

		Board boardEntity = boardRepository.findById(id);
		return boardEntity;
	}

	/**
	 * 댓글 조회
	 * 
	 * @param boardId
	 * @return comment
	 */
	public List<Comment> readComment(Long boardId) {

		List<Comment> commentList = commentRepository.findByBoardId(boardId);
		return commentList;
	}

	// TODO 세션추가
	// public void createPost(WriteFormDto writeFormDto, Long principalId) {
	public void createPost(WriteFormDto writeFormDto, int principalId) {

		Board board = new Board();
		board.setTitle(writeFormDto.getTitle());
		board.setContent(writeFormDto.getContent());
		board.setUserId(principalId);
		board.setHobbyId(writeFormDto.getHobbyId());
		int resultRowCount = boardRepository.insert(board);
		if (resultRowCount != 1) {
			// throw new
		}
	}

	// TODO 세션추가
	// public void createComment(CommentDto commentDto, Long principalId, Long boardId) {
	public void createComment(CommentDto commentDto, int principalId, Long boardId) {

		Comment comment = new Comment();
		comment.setContent(commentDto.getContent());
		comment.setUserId(principalId);
		comment.setBoardId(boardId);
		int resultRowCount = commentRepository.insert(comment);
		if(resultRowCount != 1) {
			// throw new
		}

	}

	// public void updatePost(UpdateFormDTO updateFormDTO, Long principalId) {
	public void updatePost(UpdateFormDto updateFormDto, int principalId, Long id) {

		Board board = new Board();
		board.setTitle(updateFormDto.getTitle());
		board.setContent(updateFormDto.getContent());
		board.setUserId(principalId);
		board.setHobbyId(updateFormDto.getHobbyId());
		board.setId(id);
		int resultRowCount = boardRepository.updateById(board);
		if (resultRowCount != 1) {
			// throw new
		}

	}

	// delete from board_tb where id = #{id}
	public void deletePost(Long id) {

		int resultRowCount = boardRepository.deleteById(id);
		if (resultRowCount != 1) {
			// throw new
		}
	}

}
