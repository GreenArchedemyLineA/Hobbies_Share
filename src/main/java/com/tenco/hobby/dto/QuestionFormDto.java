package com.tenco.hobby.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class QuestionFormDto {

	private Long id;
	private Long userId;
	private String content;
	private Timestamp createdAt;

}
