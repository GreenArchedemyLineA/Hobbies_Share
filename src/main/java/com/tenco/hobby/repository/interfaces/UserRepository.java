package com.tenco.hobby.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tenco.hobby.dto.AdminSignInDTO;
import com.tenco.hobby.dto.JoinUpFormDto;
import com.tenco.hobby.dto.LogInFormDto;
import com.tenco.hobby.repository.model.User;

@Mapper
public interface UserRepository {

	public int insert(JoinUpFormDto joinUpDto);

	public int updateAvatar();

	public int updateById(User user);

	public int updatePasswordById(User user);

	public String deleteById(String password);

	public User findByEmail(LogInFormDto logInDto);

	public User findByAdminEmail(AdminSignInDTO adminSignUpDTO);

//	회원 정보 찾기
	public User findById(Long id);

	public List<User> findByAll();

	public List<User> readUserInfo(@Param("id") Long id);

}
