package com.tenco.hobby.dto;

import java.sql.Date;
import java.sql.Timestamp;

import com.tenco.hobby.enums.UserRole;

import lombok.Data;

@Data
public class JoinUpFormDto {

	private String email;
	private String password;
	private String username;
	private String nickname;
	private Date birth;
	private String phone;
	private UserRole userRole;
	private Timestamp createdAt;

}
