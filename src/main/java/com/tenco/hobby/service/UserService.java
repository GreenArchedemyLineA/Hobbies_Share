package com.tenco.hobby.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.hobby.dto.JoinUpDto;
import com.tenco.hobby.handler.exception.CustomRestfullException;
import com.tenco.hobby.repository.interfaces.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public void createUser(JoinUpDto joinUpDto) {

		int result = userRepository.insert(joinUpDto);
		if (result != 1) {
			throw new CustomRestfullException("회원가입 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	

}
