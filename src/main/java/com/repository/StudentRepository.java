package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.StudentBean;

@Repository
public interface  StudentRepository  extends JpaRepository<StudentBean, Integer> {

	
	StudentBean findByEmail(String email);
	//custome methods...
}
