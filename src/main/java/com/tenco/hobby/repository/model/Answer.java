package com.tenco.hobby.repository.model;

import lombok.Data;

@Data
public class Answer {
	private Long id;
	private Long userId;
	private String content;
	private Long questionId;
}
