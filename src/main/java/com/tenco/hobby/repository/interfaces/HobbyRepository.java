package com.tenco.hobby.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tenco.hobby.dto.AdminSignInDTO;
import com.tenco.hobby.dto.JoinUpDto;
import com.tenco.hobby.dto.LogInDto;
import com.tenco.hobby.repository.model.User;
import com.tenco.hobby.repository.model.UserHobbies;

/**
 * 
 * @author 이현서
 * 취미찾기 
 */
@Mapper
public interface HobbyRepository {
	public List<UserHobbies> findUserHobbies(Long id);
	public List<UserHobbies> findByAll();
}
