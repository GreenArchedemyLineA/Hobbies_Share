package com.tenco.hobby.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.hobby.repository.model.QandA;

@Mapper
public interface AdminRepository {
	List<QandA> findAllQandA();
	QandA findbyIdQuestion(Integer id);
}
