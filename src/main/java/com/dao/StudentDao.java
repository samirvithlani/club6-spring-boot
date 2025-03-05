package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.StudentBean;
import com.repository.StudentRepository;

@Service
public class StudentDao {

	// jpaRepos
	@Autowired
	StudentRepository studentRepository;

	// create student
	public StudentBean createStudent(StudentBean studentBean) {

		return studentRepository.save(studentBean);
	}

	public List<StudentBean> getAllStudents() {

		return studentRepository.findAll();
	}

	public void deleteUser(int id) {

		studentRepository.deleteById(id);

	}

	public StudentBean updateUser(Integer id, StudentBean studentBean) {

		return studentRepository.findById(id).map(stu -> {
			stu.setName(studentBean.getName());
			stu.setEmail(studentBean.getEmail());
			stu.setAge(studentBean.getAge());
			return studentRepository.save(stu);
		}).orElse(null);

	}
	
	public StudentBean getStudentByEmail(String email) {
		
		return studentRepository.findByEmail(email);
	}

}
