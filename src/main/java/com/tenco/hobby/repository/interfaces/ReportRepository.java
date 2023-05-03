package com.tenco.hobby.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.hobby.repository.model.ReportBoard;
import com.tenco.hobby.repository.model.ReportComment;
import com.tenco.hobby.repository.model.ReportCount;

@Mapper
public interface ReportRepository {
	
	int insertReportBoard(ReportBoard report);
	int insertReportComment(ReportComment report);
	int insertReportUser(Long id);
	
	List<ReportCount> findReportCount(Long userId);
}
