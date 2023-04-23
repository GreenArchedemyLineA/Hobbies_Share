package com.tenco.hobby.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenco.hobby.dto.UpdateFormDTO;
import com.tenco.hobby.dto.WriteFormDTO;
import com.tenco.hobby.repository.interfaces.BoardRepository;
import com.tenco.hobby.repository.model.Board;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	public List<Board> ReadBoardList() {

		List<Board> list = boardRepository.findAll();

		return list;

	}

	public Board readBoard(Long id) {

		Board boardEntity = boardRepository.findById(id);

		return boardEntity;
	}

	// public void createPost(WriteFormDTO writeFormDTO, Long principalId) {
	public void createPost(WriteFormDTO writeFormDTO, int principalId) {

		Board board = new Board();
		board.setTitle(writeFormDTO.getTitle());
		board.setContent(writeFormDTO.getContent());
		board.setUserId(principalId);
		board.setHobbyId(writeFormDTO.getHobbyId());
		int resultRowCount = boardRepository.insert(board);
		if (resultRowCount != 1) {
			// throw new
		}
	}

	// public void updatePost(UpdateFormDTO updateFormDTO, Long principalId) {
	public void updatePost(UpdateFormDTO updateFormDTO, int principalId, Long id) {

		Board board = new Board();
		board.setTitle(updateFormDTO.getTitle());
		board.setContent(updateFormDTO.getContent());
		board.setUserId(principalId);
		board.setHobbyId(updateFormDTO.getHobbyId());
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
