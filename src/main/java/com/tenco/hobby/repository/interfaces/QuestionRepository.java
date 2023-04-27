package com.tenco.hobby.repository.interfaces;

import com.tenco.hobby.dto.QuestionFormDto;
import com.tenco.hobby.repository.model.QandA;

public interface QuestionRepository {

	public int insert(QuestionFormDto questionFormDto);
	
	public int updateById();
	
	public int deleteByUserId();
	
	public QandA findAll();
}
