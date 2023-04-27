package com.tenco.hobby.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class WriteQuestionFormDto {

	private Long id;
	private Long userId;
	private String nickname;
	private String content;
	private Boolean proceed;
	private Timestamp createdAt;

}
