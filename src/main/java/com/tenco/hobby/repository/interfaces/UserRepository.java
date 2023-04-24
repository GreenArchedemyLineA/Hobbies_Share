package com.tenco.hobby.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.hobby.dto.AdminSignInDTO;
import com.tenco.hobby.dto.DropFormDto;
import com.tenco.hobby.dto.JoinUpFormDto;
import com.tenco.hobby.dto.LogInFormDto;
import com.tenco.hobby.dto.UpdateInfoFormDto;
import com.tenco.hobby.repository.model.User;

@Mapper
public interface UserRepository {

//	회원가입
	public int insert(JoinUpFormDto joinUpDto);

//	로그인
	public User findByEmail(LogInFormDto logInDto);

//	프로필 수정
	public int updateAvatar();

	public int updateById(User user);

	public int updatePasswordById(User user);

	public User findById(UpdateInfoFormDto updateInfoFormDto);

	public int deleteByEmailAndPassword(DropFormDto dropFormDto);

	public User findForDelete(DropFormDto dropFormDto);

	public User findByAdminEmail(AdminSignInDTO adminSignUpDTO);

//	회원 정보 찾기
	public User findById(Long id);

	public List<User> findByAll();

}
