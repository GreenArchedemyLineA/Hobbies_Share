package com.tenco.hobby.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenco.hobby.enums.UserHobby;
import com.tenco.hobby.repository.interfaces.UserRepository;
import com.tenco.hobby.repository.model.User;
import com.tenco.hobby.service.UserService;
import com.tenco.hobby.util.RecommendSystem;

@RestController
@RequestMapping("/recommend")
public class RecommendController {
	@Autowired
	private RecommendSystem recommendSystem;
	@Autowired
	private UserService userService;
	
	@GetMapping("/id")
	public List<User> ageRecommend(Integer id) {
		User user = userService.readInfo(Integer.toUnsignedLong(id));
		List<User> userList = recommendSystem.recommendUserList(user);
		Collections.shuffle(userList);
		return userList;
	}
}
