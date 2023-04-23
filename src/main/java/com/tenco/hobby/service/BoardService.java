package com.tenco.hobby.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	

	//public void createPost(WriteFormDTO writeFormDTO, Long principalId) {
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

}
