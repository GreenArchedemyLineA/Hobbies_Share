package com.tenco.hobby.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tenco.hobby.dto.WriteQuestionFormDto;
import com.tenco.hobby.repository.model.QandA;

@Mapper
public interface QuestionRepository {

	public int insert(WriteQuestionFormDto writeQuestionFormDto);

	public int updateById(QandA qandA);

	public int deleteById(Long id);

	public List<QandA> findAll();

	public QandA findById(Long id);

	public List<QandA> findQuestionList(Long userId);
}
