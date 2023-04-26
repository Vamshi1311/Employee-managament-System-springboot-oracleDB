package com.emp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.emp.model.EmpData;
@Repository
public interface EmpRepository extends JpaRepository<EmpData, Integer>{


}
