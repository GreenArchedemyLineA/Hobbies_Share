package com.tenco.hobby.service;

import java.util.List;

import com.tenco.hobby.dto.UpdateInfoFormDto;
import com.tenco.hobby.repository.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.hobby.dto.AnswerFormDTO;
import com.tenco.hobby.handler.exception.CustomRestfullException;
import com.tenco.hobby.repository.interfaces.AdminRepository;
import com.tenco.hobby.repository.model.QandA;
import com.tenco.hobby.repository.model.Report;
import com.tenco.hobby.repository.model.ReportBoard;
import com.tenco.hobby.repository.model.User;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private UserRepository userRepository;
	public List<QandA> checkQandA(){
		List<QandA> qandAList = adminRepository.findAllQandA();
		return qandAList;
	}
	
	public QandA questionfindById(Long id) {
		QandA qandA = adminRepository.findbyIdQuestion(id);
		return qandA;
	}
	
	public List<QandA> pagefindById(Long id) {
		Long findId = (id-1) * 10; 
		
		List<QandA> qandAList = adminRepository.findRangeQandA(findId);
		return qandAList;
	}
	
	public List<User> allUserList(){
		List<User> userList = adminRepository.findAllUserList();
		return userList;
	}
	
	public void test() {
		List<ReportBoard> reportBoard = adminRepository.findAllReportBoard();
		List<Report> reportComment = adminRepository.findAllReportComment();
		System.out.println(reportBoard.toString());
		System.out.println(reportComment.toString());
	}
	
	@Transactional
	public void createAnswer(AnswerFormDTO answerFormDTO) {
		int answerResult = adminRepository.insertAnswer(answerFormDTO);
		int questionResult = adminRepository.updateQuestion(answerFormDTO.getQuestionId());
		if (answerResult != 1 && questionResult!=1) {
			throw new CustomRestfullException("댓글작성 실패하였습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Transactional
	public void updateUserInfo(UpdateInfoFormDto updateInfoFormDto, Long id){
		int result = userRepository.updateUserByEmail(updateInfoFormDto);

		if(result != 1){
			throw new CustomRestfullException("정보 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Transactional
	public Report findAllReportBoard(){
		Report reportBoard = (Report)adminRepository.findAllReportBoard();
		return reportBoard;
	}

	@Transactional
	public Report findAllReportComment(){
		Report reportBoard = (Report)adminRepository.findAllReportComment();
		return reportBoard;
	}
}
