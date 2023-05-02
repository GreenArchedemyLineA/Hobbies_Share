package com.tenco.hobby.dto;

import com.tenco.hobby.enums.UserRole;

import lombok.Data;

@Data
public class UpdateAdminInfoFormDto {

	private Long id;
	private String email;
	private String password;
	private String username;
	private String phone;
	private UserRole restriction;
}
