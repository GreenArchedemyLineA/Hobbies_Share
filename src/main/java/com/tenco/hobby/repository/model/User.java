package com.tenco.hobby.repository.model;

import java.sql.Date;
import java.sql.Timestamp;

import com.tenco.hobby.enums.UserRole;
import lombok.Data;

@Data
public class User {

	private Long id;
	private String email;
	private String password;
	private String username;
	private String nickname;
	private Date birth;
	private String phone;
	private UserRole userRole; // Enum
	private Timestamp createdAt;

	private String uploadFileName;

	public String setUpUserImage() {

		return uploadFileName == null ? "" : "/images/uploads/" + uploadFileName;
	}

}
