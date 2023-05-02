package com.tenco.hobby.service;

import java.util.List;

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
import com.tenco.hobby.dto.MessageFormDto;
import com.tenco.hobby.dto.UpdateInfoFormDto;
import com.tenco.hobby.dto.UpdatePwdFormDto;
import com.tenco.hobby.dto.WriteQuestionFormDto;
import com.tenco.hobby.handler.exception.CustomRestfullException;
import com.tenco.hobby.repository.interfaces.MessageRepository;
import com.tenco.hobby.repository.interfaces.QuestionRepository;
import com.tenco.hobby.repository.interfaces.UserRepository;
import com.tenco.hobby.repository.model.Message;
import com.tenco.hobby.repository.model.PopularUserDTO;
import com.tenco.hobby.repository.model.QandA;
import com.tenco.hobby.repository.model.User;
import com.tenco.hobby.util.Define;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private MessageRepository messageRepository;

	/**
	 * 
	 * @param email
	 * @return 이메일 중복 체크
	 */
	public boolean checkEmail(String email) {
		int result = userRepository.existsByEmail(email) == null ? 0 : 1;
		if (result == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param nickname
	 * @return 닉네임 중복 체크
	 */
	public boolean checkNickname(String nickname) {
		int result = userRepository.existsByNickname(nickname) == null ? 0 : 1;
		if (result == 0) {
			return true;
		} else {
			return false;
		}
	}

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
	 * @return userEntity 응답
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
	 * @param session
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
	 * 비밀번호 변경 기능
	 * 
	 * @param updatePwdFormDto
	 * @param session
	 */
	@Transactional
	public void updatePwd(UpdatePwdFormDto updatePwdFormDto, HttpSession session) {

		String userInputPassword = updatePwdFormDto.getPassword();

		User loginUser = (User) session.getAttribute(Define.PRINCIPAL);

		String sessionPassword = userRepository.findById(loginUser.getId()).getPassword();
		boolean isMatched = passwordEncoder.matches(userInputPassword, sessionPassword);

		if (isMatched == false) {
			throw new CustomRestfullException("비밀번호가 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
		}

		String NewPwd = updatePwdFormDto.getNewPwd().toString();
		String checkPwd = updatePwdFormDto.getCheckPwd().toString();

		if (NewPwd.equals(checkPwd) == false) {
			throw new CustomRestfullException("새 비밀번호와 비밀번호 확인이 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
		}

		String hashPwd = passwordEncoder.encode(NewPwd);
		updatePwdFormDto.setPassword(hashPwd);

		int result = userRepository.updatePasswordById(updatePwdFormDto);

		if (result != 1) {
			throw new CustomRestfullException("비밀번호 변경 실패하였습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
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

	/**
	 * QnA 전체조회 기능
	 * 
	 * @return QnA 리스트
	 */
	@Transactional
	public List<QandA> readQuestionList(Long userId) {

		List<QandA> questionList = questionRepository.findQuestionList(userId);
		return questionList;
	}

	/**
	 * QnA 작성 기능
	 * 
	 * @param writeQuestionFormDto
	 * @param session
	 */
	@Transactional
	public void createQuestion(WriteQuestionFormDto writeQuestionFormDto, Long userId) {

		writeQuestionFormDto.setUserId(userId);
		int result = questionRepository.insert(writeQuestionFormDto);

		if (result != 1) {
			throw new CustomRestfullException("문의사항 등록에 실패 하였습니다.", HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Q&A 읽어오기 기능
	 * 
	 * @param id
	 * @return qustionEntity 응답
	 */
	@Transactional
	public QandA readQuestion(Long id) {

		QandA questionEntity = questionRepository.findById(id);

		if (questionEntity == null) {
			throw new CustomRestfullException("작성하신 글을 불러올 수 없습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return questionEntity;
	}

	/**
	 * Q&A 수정 기능
	 * 
	 * @param qAndA
	 */
	@Transactional
	public void updateQuestion(QandA qAndA) {

		int result = questionRepository.updateById(qAndA);

		if (result != 1) {
			throw new CustomRestfullException("정보 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * Q&A 삭제 기능
	 * 
	 * @param id
	 */
	@Transactional
	public void deleteQuestion(Long id) {

		int result = questionRepository.deleteById(id);

		if (result != 1) {
			throw new CustomRestfullException("글 삭제를 실패하였습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 쪽지 전송
	 * 
	 * @param messageFormDto
	 * @param userId
	 * @param principalId
	 */
	@Transactional
	public boolean createMessage(MessageFormDto messageFormDto, Long userId, Long principalId) {
		
		Message message = new Message();
		message.setSender(principalId);
		message.setReceiver(userId);
		message.setMessage(messageFormDto.getMessage());
		
		boolean success = true;
		
		int resultRowCount = messageRepository.insert(message);
		if(resultRowCount != 1) {
			return false;
		}else if(resultRowCount == 1) {
			return true;			
		}		
		
		return success;
	}

	/**
	 * 받은 메세지 확인
	 * @param principalId
	 * @return
	 */
	@Transactional
	public List<Message> readReceiveMessage(Long principalId) {

		List<Message> list = messageRepository.findByReceiver(principalId);

		return list;
	}
	
	/**
	 * 보낸 메세지 확인
	 * @param principalId
	 * @return
	 */

	@Transactional
	public List<Message> readSendMessage(Long principalId) {

		List<Message> list = messageRepository.findBySender(principalId);

		return list;
	}
	
	public List<Message> readAllMessage(Long principalId){
		
		List<Message> list = messageRepository.findByAll(principalId);
		
		return list;
	}
	
	/**
	 * @return PopularUserDTO
	 */
	public List<PopularUserDTO> findPopularUserList(){
		List<PopularUserDTO> popularUserList = userRepository.popularList();
		return popularUserList;
	}
}
