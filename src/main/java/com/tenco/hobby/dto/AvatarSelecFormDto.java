package com.tenco.hobby.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class AvatarSelecFormDto {

	private Long id;
	private String nickname;

//	이미지 관련
	private MultipartFile file;
	private String originFileName;
	private String uploadFileName;

}
