package com.tenco.hobby.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class AvatarDto {

	private Long id;
	private Long userId;
	private String nickname;

//	이미지 관련
	private MultipartFile file;
	private String originFileName;
	private String uploadFileName;

}
