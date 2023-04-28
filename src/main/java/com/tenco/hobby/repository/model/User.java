package com.tenco.hobby.repository.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.tenco.hobby.enums.UserRole;
import com.tenco.hobby.util.RecommendSystem;
import com.tenco.hobby.util.TimestampUtil;

import lombok.Data;

@Data
public class User {

	private Long id;
	private String email;
	private String password;
	private String username;

	private String nickname;
	private String originFileName;
	private String uploadFileName;

	private Date birth;
	private String phone;
	private UserRole userRole; // Enum
	private Timestamp createdAt;

	public String setUpUserImage() {

		return uploadFileName == null ? "https://cdn-icons-png.flaticon.com/512/3529/3529423.png"
				: "/images/uploads/" + uploadFileName;
	}
	
	public String setUpAdminImage() {
		
		uploadFileName = "https://cdn-icons-png.flaticon.com/512/3934/3934107.png";
		
		return uploadFileName;
	}

	public String formatCreatedAt() {

		return TimestampUtil.datestampToString(createdAt);
	}

	public String formatBirth() {

		return TimestampUtil.birthdateToString(birth);
	}

	public String formatPhone() {

		String formatPhone = phone.substring(0, 3) + " - " + phone.substring(3, 7) + " - " + phone.substring(7);

		return formatPhone;
	}
	
	public Integer getGeneration() {
		int year = this.birth.getYear() + 1900;
		int nowGeneration = 60;
		int nowYear = LocalDateTime.now().getYear();
		if(nowYear - year <= 59) {
			nowGeneration = 50;
		}
		if(nowYear - year <= 49) {
			nowGeneration = 40;
		}
		if(nowYear - year <= 39) {
			nowGeneration = 30;
		}
		if(nowYear - year <= 29 ) {
			nowGeneration = 20;
		}
		if(nowYear - year <= 19) {
			nowGeneration = 10;
		}
		return nowGeneration;
	}

}
