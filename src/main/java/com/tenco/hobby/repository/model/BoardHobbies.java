package com.tenco.hobby.repository.model;

import com.tenco.hobby.enums.UserHobby;

import lombok.Data;

@Data
public class BoardHobbies {
	
	private Long id;
	private UserHobby hobby;
}
