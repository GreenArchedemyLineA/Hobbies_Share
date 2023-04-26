package com.tenco.hobby.repository.model;

import lombok.Data;

@Data
public class QandA {
	private Long id;
	private Long userId;
	private String content;
	private Boolean proceed;
}
