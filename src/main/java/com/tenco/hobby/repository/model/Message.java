package com.tenco.hobby.repository.model;

import java.sql.Timestamp;

import lombok.Data;
@Data
public class Message {
	
	private Long id;
	private Long sender;
	private Long receiver;
	private String message;
	private Timestamp createdAt;
	
	private String nickname;

}
