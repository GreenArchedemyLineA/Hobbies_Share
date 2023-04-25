package com.tenco.hobby.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.hobby.dto.AdminSignInDTO;
import com.tenco.hobby.dto.AvatarSelecFormDto;
import com.tenco.hobby.dto.DropFormDto;
import com.tenco.hobby.dto.JoinUpFormDto;
import com.tenco.hobby.dto.LogInFormDto;
import com.tenco.hobby.dto.UpdateInfoFormDto;
import com.tenco.hobby.handler.exception.CustomRestfullException;
import com.tenco.hobby.repository.interfaces.UserRepository;
import com.tenco.hobby.repository.model.User;
import com.tenco.hobby.util.Define;

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
	public void createUser(JoinUpFormDto joinUpFormDto) {

		String rawPwd = joinUpFormDto.getPassword();
		String hashPwd = passwordEncoder.encode(rawPwd);
		joinUpFormDto.setPassword(hashPwd);

		int result = userRepository.insert(joinUpFormDto);
		if (result != 1) {
			throw new CustomRestfullException("회원가입 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * 관리자 로그인 처리
	 * 
	 * @param adminSignInDTO
	 * @return
	 */
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

	/**
	 * 로그인 처리
	 * 
	 * @param logInDto
	 * @return userEntity 응답
	 */
	@Transactional
	public User logIn(LogInFormDto logInformDto) {

		String pwd = logInformDto.getPassword();

		User userEntity = userRepository.findByEmail(logInformDto);

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

	/**
	 * 프로필 수정 처리
	 * 
	 * @param avatarSelecFormDto
	 */
	@Transactional
	public void updateAvatar(AvatarSelecFormDto avatarSelecFormDto) {

		int result = userRepository.updateAvatar(avatarSelecFormDto);
		if (result != 1) {
			throw new CustomRestfullException("프로필 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}

	/**
	 * 회원 정보 수정 처리
	 * 
	 * @param updateInfoFormDto
	 * @return
	 * @return
	 */
	@Transactional
	public void updateInfo(UpdateInfoFormDto updateInfoFormDto, HttpSession session) {

		String userInputPassword = updateInfoFormDto.getPassword();

		User loginUser = (User) session.getAttribute(Define.PRINCIPAL);

		String sessionPassword = userRepository.findById(loginUser.getId()).getPassword();
		boolean isMatched = passwordEncoder.matches(userInputPassword, sessionPassword);

		if (isMatched == false) {
			throw new CustomRestfullException("비밀번호가 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
		}

		int result = userRepository.updateUserByEmail(updateInfoFormDto);

		if (result != 1) {
			throw new CustomRestfullException("정보 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * 회원 탈퇴 기능
	 * 
	 * @param email
	 * @param password
	 */
	@Transactional
	public void deleteUser(DropFormDto dropFormDto, HttpSession session) {

		String userInputPwd = dropFormDto.getPassword();

		User loginUser = (User) session.getAttribute(Define.PRINCIPAL);

		String userEntity = loginUser.getEmail();
		// 1. 이메일과 비밀번호로 select 하기

		// 2. select 결과에서 getId하기

		// 3. getId 한 값 매개변수에 넣기

		if (userEntity == null) {
			throw new CustomRestfullException("해당 계정이 존재하지 않습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		String sessionPwd = userRepository.findById(loginUser.getId()).getPassword();
		boolean isMatched = passwordEncoder.matches(userInputPwd, sessionPwd);

		if (isMatched == false) {
			throw new CustomRestfullException("비밀번호가 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
		}

		userRepository.deleteByEmail(dropFormDto);

	}

}
