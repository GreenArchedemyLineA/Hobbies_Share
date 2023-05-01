package com.tenco.hobby.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenco.hobby.dto.CheckDTO;
import com.tenco.hobby.dto.DuplicateResponseDTO;
import com.tenco.hobby.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserService userService;

	@PostMapping("/email-check")
	public CheckDTO emailChecker(@RequestBody DuplicateResponseDTO duplicateResponseDTO) {
		System.out.println(duplicateResponseDTO);
		CheckDTO checkDTO = new CheckDTO();
		if (userService.checkEmail(duplicateResponseDTO.getEmail())) {
			checkDTO.setSuccessCode(true);
			return checkDTO;
		} else {
			checkDTO.setSuccessCode(false);
			return checkDTO;
		}
	}

	@PostMapping("/nickname-check")
	public CheckDTO nickNameChecker(@RequestBody DuplicateResponseDTO duplicateResponseDTO) {
		CheckDTO checkDTO = new CheckDTO();
		if (userService.checkNickname(duplicateResponseDTO.getNickname())) {
			checkDTO.setSuccessCode(true);
			return checkDTO;
		} else {
			checkDTO.setSuccessCode(false);
			return checkDTO;
		}
	}

}
