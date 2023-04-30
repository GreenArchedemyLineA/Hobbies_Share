package com.tenco.hobby.dto;

import lombok.Data;

@Data
public class LogInFormDto {

	private String email;
	private String password;
	private boolean remember;

	public boolean isRemember() {
		return remember;
	}

	public void setRemember(boolean remember) {
		this.remember = remember;
	}

}
