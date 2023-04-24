package com.tenco.hobby.dto;

import lombok.Data;

@Data
public class WriteFormDto {
	
	private String title;
	private String content;
	private Long hobbyId;
}
