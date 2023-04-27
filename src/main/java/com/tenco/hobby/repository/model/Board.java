package com.tenco.hobby.repository.model;

import java.sql.Timestamp;

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
	private String hobby;
	
	public String formatCreatedAt() {
		return TimestampUtil.timestampToString(createdAt);
	}

}
