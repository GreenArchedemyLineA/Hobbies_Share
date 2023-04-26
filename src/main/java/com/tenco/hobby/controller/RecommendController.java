package com.tenco.hobby.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenco.hobby.enums.UserHobby;
import com.tenco.hobby.repository.model.User;
import com.tenco.hobby.util.RecommendSystem;

@RestController
@RequestMapping("/recommend")
public class RecommendController {
	@Autowired
	private RecommendSystem recommendSystem;
	
	@GetMapping("/age")
	public List<User> ageRecommend(Integer id) {
		System.out.println(id);
		List<User> userList = recommendSystem.ageRecommendUserList(id);
		return userList;
	}
	
	@GetMapping("/hobby")
	public List<User> hobbyRecommend(UserHobby name) {
		List<User> userList = recommendSystem.hobbyRecommendUserList(name);
		return userList;
	}
}
