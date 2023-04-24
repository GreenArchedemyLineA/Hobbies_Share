package com.tenco.hobby.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.hobby.repository.model.Comment;

@Mapper
public interface CommentRepository {
	
	public int insert(Comment comment); 
	public List<Comment> findByBoardId(Long boardId);

}
