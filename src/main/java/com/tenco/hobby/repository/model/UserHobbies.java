package com.tenco.hobby.repository.model;

import com.tenco.hobby.enums.UserHobby;
import lombok.Data;

@Data
public class UserHobbies {
	private User user;
	private UserHobby hobby;
}
