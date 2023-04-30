package com.tenco.hobby.repository.interfaces;

import com.tenco.hobby.repository.model.ReportBoard;
import com.tenco.hobby.repository.model.ReportComment;
import org.apache.ibatis.annotations.Mapper;

import com.tenco.hobby.repository.model.Report;

@Mapper
public interface ReportRepository {
	
	public int insertReportBoard(ReportBoard report);
	public int insertReportComment(ReportComment report);
}
