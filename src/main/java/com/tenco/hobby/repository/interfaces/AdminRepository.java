package com.tenco.hobby.repository.interfaces;

import java.util.List;

import com.tenco.hobby.repository.model.*;
import org.apache.ibatis.annotations.Mapper;

import com.tenco.hobby.dto.AnswerFormDTO;

@Mapper
public interface AdminRepository {
	List<QandA> findAllQandA();
	QandA findbyIdQuestion(Long id);
	List<QandA> findRangeQandA(Long id);
	List<User> findAllUserList();
	int insertAnswer(AnswerFormDTO answerFormDTO);
	int updateQuestion(Long Id);
	List<ReportBoard>findAllReportBoard();
	List<ReportComment>findAllReportComment();
	ReportBoard findReportBoardById(Long id);
	ReportComment findReportCommentById(Long id);
}
