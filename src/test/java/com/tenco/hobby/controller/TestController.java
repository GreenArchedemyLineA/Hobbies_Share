package com.tenco.hobby.controller;

import com.tenco.hobby.dto.AdminSignUpDTO;
import com.tenco.hobby.enums.UserRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestController {
    @Test
    public void Test(){
        UserRole role = UserRole.ADMIN;
        AdminSignUpDTO admin = new AdminSignUpDTO();
        Assertions.assertEquals(admin.getUserRole(), role);
    }
}
