package com.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.weaving.DefaultContextLoadTimeWeaver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.emp.model.EmpData;
import com.emp.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpRepository empRepository;

	@Override
	public List<EmpData> getAllEmp() {
		List<EmpData> list = (List<EmpData>) empRepository.findAll();
		return list;
	}

	@Override
	public void addEmployee(EmpData empData) {
		this.empRepository.save(empData);

	}

	@Override
	public EmpData getEmpById(int id) {
		EmpData empData=null;
		Optional<EmpData> optional=empRepository.findById(id);
		if (optional.isPresent()) {
			empData=optional.get();
		}else {
			throw new RuntimeException("Employee not found for "+id+" this id");
		}
		return empData;
	}

	@Override
	public void deleteEmloyee(int id) {
		// TODO Auto-generated method stub
		empRepository.deleteById(id);
	}

	@Override
	public Page<EmpData> findPegignation(int no, int size) {
		Pageable pageable=PageRequest.of(no, size);
		
		return empRepository.findAll(pageable);
	}

	

}
