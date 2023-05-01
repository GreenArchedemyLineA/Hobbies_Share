package com.tenco.hobby.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.hobby.enums.UserHobby;
import com.tenco.hobby.repository.model.BoardHobbies;
import com.tenco.hobby.repository.model.Hobby;
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
	
	public List<BoardHobbies> findAllHobbies();
}
