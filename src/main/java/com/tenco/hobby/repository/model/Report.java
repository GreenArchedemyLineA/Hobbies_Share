package com.tenco.hobby.repository.model;

import lombok.Data;

@Data
public class Report {
	private Long id;
	private Long userId;
	private Long targetId;
	private Boolean proceed;
}
