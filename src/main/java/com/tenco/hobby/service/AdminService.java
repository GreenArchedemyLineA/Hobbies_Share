package com.tenco.hobby.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenco.hobby.repository.interfaces.AdminRepository;
import com.tenco.hobby.repository.model.QandA;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;
	
	public List<QandA> checkQandA(){
		List<QandA> qandAList = adminRepository.findAllQandA();
		return qandAList;
	}
	
	public QandA questionfindById(Integer id) {
		QandA qandA = adminRepository.findbyIdQuestion(id);
		return qandA;
	}
}
