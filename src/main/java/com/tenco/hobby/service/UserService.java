package com.tenco.hobby.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.hobby.dto.AdminSignInDTO;
import com.tenco.hobby.dto.JoinUpDto;
import com.tenco.hobby.dto.LogInDto;
import com.tenco.hobby.handler.exception.CustomRestfullException;
import com.tenco.hobby.repository.interfaces.UserRepository;
import com.tenco.hobby.repository.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * 회원가입 처리
	 * 
	 * @param joinUpDto
	 */
	@Transactional
	public void createUser(JoinUpDto joinUpDto) {

		String rawPwd = joinUpDto.getPassword();
		String hashPwd = passwordEncoder.encode(rawPwd);
		joinUpDto.setPassword(hashPwd);

		int result = userRepository.insert(joinUpDto);
		if (result != 1) {
			throw new CustomRestfullException("회원가입 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * 로그인 처리
	 * 
	 * @param logInDto
	 * @return userEntity 응답
	 */
	@Transactional
	public User logIn(LogInDto logInDto) {

		String pwd = logInDto.getPassword();

		User userEntity = userRepository.findByEmail(logInDto);

		if (userEntity == null) {
			throw new CustomRestfullException("해당 계정이 존재하지 않습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		String hashPwd = userEntity.getPassword();
		boolean isMatched = passwordEncoder.matches(pwd, hashPwd);

		if (isMatched == false) {
			throw new CustomRestfullException("비밀번호가 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
		}
		return userEntity;
	}

	/**
	 * 회원 정보 읽기
	 * 
	 * @param id
	 * @return userEntity 응답
	 */
	@Transactional
	public User readInfo(Long id) {

		User userEntity = userRepository.findById(id);

		if (userEntity == null) {
			throw new CustomRestfullException("회원 정보를 찾을 수 없습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return userEntity;
	}

	public List<User> readUserInfo(Long id) {

		List<User> userInfo = userRepository.readUserInfo(id);

		return userInfo;
	}

	@Transactional
	public User adminLogin(AdminSignInDTO adminSignInDTO) {
		User userEntity = userRepository.findByAdminEmail(adminSignInDTO);

		if (userEntity == null) {
			throw new CustomRestfullException("해당 관리자는 존재하지 않습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		String adminPasword = userEntity.getPassword();
		if (!passwordEncoder.matches(adminSignInDTO.getPassword(), adminPasword)) {
			throw new CustomRestfullException("아이디 혹은 비밀번호가 일치하지 않습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return userEntity;
	}

}
