package com.tenco.hobby.repository.model;

import java.sql.Timestamp;

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

}
