package com.tenco.hobby.repository.model;

import lombok.Data;

@Data
public class Report {
	
	private Long id;
	private Long reportUserId;
	private Long reportBoardId;
	private Long reportCommentId;
	private int proceed;

	
}
