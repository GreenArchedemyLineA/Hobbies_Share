package com.tenco.hobby.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.hobby.repository.model.QandA;
import com.tenco.hobby.repository.model.User;

@Mapper
public interface AdminRepository {
	List<QandA> findAllQandA();
	QandA findbyIdQuestion(Integer id);
	List<QandA> findRangeQandA(Integer id);
	List<User> findAllUserList();
}
