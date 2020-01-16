package com.aashman.myassignmentapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashman.myassignmentapp.models.Student;
import com.aashman.myassignmentapp.repos.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public boolean addStudent(Student student) {
		if (student.getFirstName().isEmpty() || student.getLastName().isEmpty() || student.getAddress().isEmpty()
				|| student.getPhoneNumber().isEmpty() || student.getDob().isEmpty() || student.getGender().toString().isBlank()
				|| student.getEmail().isEmpty() || student.getUserName().isEmpty() || student.getPassword().isEmpty()) {
			return false;
		} 
			studentRepository.save(student);
			return true;
	}
}