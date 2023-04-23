package com.tenco.hobby.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tenco.hobby.dto.JoinUpDto;
import com.tenco.hobby.dto.LogInDto;
import com.tenco.hobby.repository.model.User;

@Mapper
public interface UserRepository {

	public int insert(JoinUpDto joinUpDto);

	public int updateById(User user);

	public int updatePasswordById(User user);

	public int deleteById(Integer id);

	public User findByEmail(LogInDto logInDto);

//	회원 정보 찾기
	public User findById(Integer id);
	
	public List<User> readUserInfo(@Param("id") Long id);

}
