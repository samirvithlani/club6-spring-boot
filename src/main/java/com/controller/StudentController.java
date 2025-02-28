package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.StudentBean;
import com.dao.StudentDao;

@RestController
public class StudentController {

	@Autowired
	StudentDao studentDao;

	@PostMapping(value = "/student")
	public ResponseEntity<?> addStudent(@RequestBody StudentBean studentBean) {

		StudentBean savedStudent = studentDao.createStudent(studentBean);
		if (savedStudent != null) {

			return new ResponseEntity<StudentBean>(studentBean, HttpStatus.CREATED);
		}

		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@GetMapping(value = "/students")
	public ResponseEntity<?> getAllStudents() {

		List<StudentBean> allStudents = studentDao.getAllStudents();
		if (allStudents.size() > 0) {

			return new ResponseEntity<List<StudentBean>>(allStudents, HttpStatus.CREATED);

		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}
	
	@DeleteMapping(value = "/student/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") int id){
		
		studentDao.deleteUser(id);
		return new ResponseEntity<String>("student deleted", HttpStatus.CREATED);

		
	}

}
