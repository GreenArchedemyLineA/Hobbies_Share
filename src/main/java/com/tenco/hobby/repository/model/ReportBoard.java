package com.tenco.hobby.repository.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ReportBoard extends Report {
	private Long id;
	private Long reportUserId;
	private Long reportBoardId;
	private Boolean proceed;
}
