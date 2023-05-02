package com.tenco.hobby.repository.model;

import lombok.Data;

@Data
public class PopularUserDTO {
	private User user;
	private Integer msgCount;
}
