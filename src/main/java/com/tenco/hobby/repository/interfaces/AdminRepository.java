package com.tenco.hobby.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.hobby.dto.AnswerFormDTO;
import com.tenco.hobby.repository.model.QandA;
import com.tenco.hobby.repository.model.Report;
import com.tenco.hobby.repository.model.ReportBoard;
import com.tenco.hobby.repository.model.User;

@Mapper
public interface AdminRepository {
	List<QandA> findAllQandA();
	QandA findbyIdQuestion(Long id);
	List<QandA> findRangeQandA(Long id);
	List<User> findAllUserList();
	int insertAnswer(AnswerFormDTO answerFormDTO);
	int updateQuestion(Long Id);
	List<ReportBoard>findAllReportBoard();
	List<Report>findAllReportComment();
	
}
