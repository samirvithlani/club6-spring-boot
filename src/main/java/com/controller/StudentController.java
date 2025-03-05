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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.StudentBean;
import com.dao.StudentDao;
import com.util.CustomeResponse;

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
		CustomeResponse response = new CustomeResponse();
		if (allStudents.size() > 0) {

			response.setData(allStudents);
			response.setMessage("all students fetched successfully..");

			return new ResponseEntity<CustomeResponse>(response, HttpStatus.CREATED);

		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@DeleteMapping(value = "/student/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") int id) {

		studentDao.deleteUser(id);
		return new ResponseEntity<String>("student deleted", HttpStatus.CREATED);

	}

	@PutMapping(value = "/student/{id}")
	public ResponseEntity<?> updateStudent(@RequestBody StudentBean studentBean, @PathVariable("id") int id) {

		StudentBean studentBean2 = studentDao.updateUser(id, studentBean);
		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	@GetMapping(value = "/student/{email}")
	public ResponseEntity<?> getStudentByEmail(@PathVariable("email") String email) {

		StudentBean studentBean = studentDao.getStudentByEmail(email);

		return new ResponseEntity<StudentBean>(studentBean, HttpStatus.OK);

	}

}
