package com.tenco.hobby.enums;

public enum UserHobby {
	SOCCER("축구"), BASKETBALL("농구");
	
	private final String name;
	UserHobby(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
