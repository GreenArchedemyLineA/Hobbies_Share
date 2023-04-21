package com.tenco.hobby.repository.interfaces;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.hobby.dto.JoinUpDto;
import com.tenco.hobby.repository.model.User;

@Mapper
public interface UserRepository {

	public int insert(JoinUpDto joinUpDto);

	public int updateById(User user);
	
	public int updatePasswordById(User user);

	public int deleteById(Integer id);

	public User findById(Integer id);

}
