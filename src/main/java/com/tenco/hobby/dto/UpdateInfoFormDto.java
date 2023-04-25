package com.tenco.hobby.dto;

import lombok.Data;

@Data
public class UpdateInfoFormDto {

	private Long id;
	private String email;
	private String password;
	private String username;
	private String phone;

}
