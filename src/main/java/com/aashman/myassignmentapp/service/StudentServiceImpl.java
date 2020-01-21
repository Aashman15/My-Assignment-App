package com.aashman.myassignmentapp.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashman.myassignmentapp.models.Student;
import com.aashman.myassignmentapp.models.StudentRequest;
import com.aashman.myassignmentapp.models.Teacher;
import com.aashman.myassignmentapp.repos.StudentRepository;
import com.aashman.myassignmentapp.repos.StudentRequestRepository;
import com.aashman.myassignmentapp.repos.TeacherRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	StudentRequestRepository srRepository;

	@Autowired
	TeacherRepository tRepository;

	@Autowired
	TeacherService tService;

	@Override
	public boolean addStudent(Student student) {
		if (student.getFirstName().isEmpty() || student.getLastName().isEmpty() || student.getAddress().isEmpty()
				|| student.getPhoneNumber().isEmpty() || student.getDob().isEmpty()
				|| student.getGender().toString().isEmpty() || student.getUserName().isEmpty()
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
		List<Student> allStudents = studentRepository.findAll();
		for (Student s : allStudents) {
			if (s.getUserName().equals(userName)) {
				return s;
			}
		}
		return null;
	}

	@Override
	public Student findStudentByIntegerId(int id) {
		List<Student> allStudents = studentRepository.findAll();
		for (Student s : allStudents) {
			if (s.getStudentId() == id) {
				return s;
			}
		}
		return null;
	}

	@Override
	public List<Teacher> findAvailableTeachersOfStudent(Student student) {
		List<Teacher> availableTeachers = tRepository.findAll();
		List<StudentRequest> allSr = srRepository.findAll();
		for (StudentRequest sr : allSr) {
			Teacher teacher = tRepository.findById(sr.getTeacherId()).get();
			int studentId = sr.getStudentId();
			if (student.getStudentId() == studentId && availableTeachers.contains(teacher)) {
				availableTeachers.remove(teacher);
			}
		}
		Set<Teacher> teachersOfStudent = student.getTeachers();

		for (Teacher t : teachersOfStudent) {
			if (availableTeachers.contains(t)) {
				availableTeachers.remove(t);
			}
		}
		return availableTeachers;
	}
}