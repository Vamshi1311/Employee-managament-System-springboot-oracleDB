package com.emp.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.emp.model.EmpData;

public interface EmpService {

	List<EmpData> getAllEmp();
	
	void addEmployee(EmpData empData);
	
	EmpData getEmpById(int id);
	
	void deleteEmloyee(int id);
	
	Page<EmpData> findPegignation(int no,int size);
}
