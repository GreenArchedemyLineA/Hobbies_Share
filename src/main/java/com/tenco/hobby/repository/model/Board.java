package com.tenco.hobby.repository.model;

import java.sql.Timestamp;

import com.tenco.hobby.enums.UserHobby;
import com.tenco.hobby.util.TimestampUtil;

import lombok.Data;

@Data
public class Board {

	private Long id;
	private String title;
	private String content;
	private Long userId;
	private Long hobbyId;
	private Timestamp createdAt;

	private String nickname;
	private UserHobby hobby;

	private String uploadFileName;

	public String formatCreatedAt() {
		return TimestampUtil.timestampToString(createdAt);
	}

	public String setUpUserImage() {

		return uploadFileName == null ? "https://cdn-icons-png.flaticon.com/512/3529/3529423.png"
				: "/images/uploads/" + uploadFileName;
	}

}
