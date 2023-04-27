package com.tenco.hobby.repository.model;

import java.sql.Timestamp;

import com.tenco.hobby.util.TimestampUtil;

import lombok.Data;

@Data
public class Comment {
	
	private Long id;
	private String content;
	private Long userId;
	private Long boardId;
	private Timestamp createdAt;	
	
	private String nickname;
	
	public String formatCreatedAt() {
		return TimestampUtil.timestampToString(createdAt);
	}
}
