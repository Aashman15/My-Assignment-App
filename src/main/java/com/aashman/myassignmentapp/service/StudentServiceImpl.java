package com.aashman.myassignmentapp.service;

import java.util.List;

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
				|| student.getPhoneNumber().isEmpty() || student.getDob().isEmpty()
				|| student.getGender().toString().isBlank() || student.getUserName().isEmpty()
				|| student.getPassword().isEmpty()) {
			return false;
		}
		studentRepository.save(student);
		return true;
	}

	@Override
	public boolean enterStudentHomePage(String userName, String password) {
		List<Student> students = studentRepository.findAll();
		for (Student s : students) {
			if (s.getUserName().equals(userName) && s.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Student findStudentByUserName(String userName) {
		List<Student> allStudents =  studentRepository.findAll();
		for(Student s : allStudents) {
			if(s.getUserName().equals(userName)) {
				return s;
			}
		}
		return null;
	}
}
