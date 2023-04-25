package com.tenco.hobby.dto;

import lombok.Data;

@Data
public class UpdatePwdFormDto {

	private Long id;
	private String password;
	private String newPwd;
	private String checkPwd;

}
