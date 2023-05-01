package com.tenco.hobby.dto;

import java.sql.Date;
import java.sql.Timestamp;

import javax.validation.constraints.Size;

import com.tenco.hobby.enums.UserRole;

import lombok.Data;

@Data
public class JoinUpFormDto {

	private String email;
	
	private boolean checkEmail;

	private String password;
	private String username;
	@Size(min = 2, message = "닉네임은 2자 이상 입력해주세요.")
	private String nickname;
	private Date birth;
	private String phone;
	private UserRole userRole;
	private Timestamp createdAt;

}
