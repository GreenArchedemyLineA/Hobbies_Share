package com.tenco.hobby.controller;

import com.tenco.hobby.dto.AdminSignUpDTO;
import com.tenco.hobby.enums.UserRole;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestController {
	@Test
    public void Test() {
    	// when
    	// 로그인 한다하고 가정
    	// 로그인 된 유저와 우리가 예상하는 유저가 일치한가?
    	UserController userController = new UserController();
    	AdminSignUpDTO dto = new AdminSignUpDTO();
    	dto.setEmail("admin");
    	
    	assertNotEquals(dto.getUserRole(), UserRole.USER);
    }
}
