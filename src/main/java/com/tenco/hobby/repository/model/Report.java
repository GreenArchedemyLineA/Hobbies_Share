package com.tenco.hobby.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
public class Report {
	private Long id;
	private Long userId;
	private Long targetId;
	private Boolean proceed;
}
