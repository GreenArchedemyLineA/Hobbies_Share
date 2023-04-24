package com.tenco.hobby.repository.model;

import com.tenco.hobby.enums.UserHobby;

import lombok.Data;

@Data
public class Hobby {
	private Long id;
	private UserHobby hobbies;
}
