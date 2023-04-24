package com.tenco.hobby.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.hobby.repository.model.Board;
import com.tenco.hobby.repository.model.Comment;

@Mapper
public interface BoardRepository {

	public int insert(Board board);
	public int updateById(Board board);
	public int deleteById(Long id);
	public List<Board> findAll();
	public Board findById(Long id);
	// public List<Board> findByHobby(Long hobbyId);

}
