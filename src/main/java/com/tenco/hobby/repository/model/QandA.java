package com.tenco.hobby.repository.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class QandA {

	private Long id;
	private Long userId;
	private String nickname;
	private String content;
	private Boolean proceed;
	private Timestamp createdAt;

	public String formatName() {

		String qnaName = nickname.substring(0, 1) + "**";

		return qnaName;

	}
}
