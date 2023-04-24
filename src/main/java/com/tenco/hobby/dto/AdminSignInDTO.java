package com.tenco.hobby.dto;

import com.tenco.hobby.enums.UserRole;
import lombok.Data;

@Data
public class AdminSignInDTO {
    private String email;
    private String password;
    private UserRole userRole = UserRole.ADMIN;
}
