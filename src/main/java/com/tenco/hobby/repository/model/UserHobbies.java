package com.tenco.hobby.repository.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class UserHobbies {
	private Long id;
	private String hobby;
	private Long userId;
	private Timestamp createdAt;
}
