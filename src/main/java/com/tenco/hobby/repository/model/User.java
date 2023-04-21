package com.tenco.hobby.repository.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class User {

	private Long id;
	private String email;
	private String password;
	private String username;
	private int age;
	private String phone;
	private String userRole;
	private Timestamp createdAt;

}
