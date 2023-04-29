package com.tenco.hobby.dto;

import lombok.Data;

@Data
public class AnswerFormDTO {
	private Long userId;
	private String answer;
	private Long questionId;
}
