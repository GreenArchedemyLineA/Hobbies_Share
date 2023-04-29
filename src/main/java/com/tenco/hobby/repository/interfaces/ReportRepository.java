package com.tenco.hobby.repository.interfaces;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.hobby.repository.model.Report;

@Mapper
public interface ReportRepository {
	
	public int insertReportBoard(Report report);
	public int insertReportComment(Report report);
	

}
