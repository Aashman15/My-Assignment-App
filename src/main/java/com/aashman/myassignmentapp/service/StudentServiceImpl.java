package com.aashman.myassignmentapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashman.myassignmentapp.models.McQuestion;
import com.aashman.myassignmentapp.models.MultipleChoiceAssignment;
import com.aashman.myassignmentapp.models.Student;
import com.aashman.myassignmentapp.models.StudentRequest;
import com.aashman.myassignmentapp.models.Teacher;
import com.aashman.myassignmentapp.repos.McAssignmentRepository;
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

	@Autowired
	McAssignmentRepository mcaRepository;

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

	@Override
	public List<MultipleChoiceAssignment> findMcAssignmentsOfStudent(Student student) {
		Set<Teacher> teachers = student.getTeachers();
		List<MultipleChoiceAssignment> mcAssignmentsOfStudent = new ArrayList<MultipleChoiceAssignment>();
		for (Teacher teacher : teachers) {
			for (MultipleChoiceAssignment mcAssignment : teacher.getAssignments()) {
				mcAssignmentsOfStudent.add(mcAssignment);
			}
		}
		return mcAssignmentsOfStudent;
	}

	@Override
	public int submitAssignment(List<McQuestion> mcQuestions, String option1, String option2, String option3,
			String option4, String option5, String option6, String option7, String option8, String option9,
			String option10) {

		int marks = 0;

		if (option1 != null) {
			if (mcQuestions.get(0).getCorrectOption().equalsIgnoreCase(option1)) {
				marks++;
			}
		}

		if (option2 != null) {
			if (mcQuestions.get(1).getCorrectOption().equalsIgnoreCase(option2)) {
				marks++;
			}
		}

		if (option3 != null) {
			if (mcQuestions.get(2).getCorrectOption().equalsIgnoreCase(option3)) {
				marks++;
			}
		}

		if (option4 != null) {
			if (mcQuestions.get(3).getCorrectOption().equalsIgnoreCase(option4)) {
				marks++;
			}
		}

		if (option5 != null) {
			if (mcQuestions.get(4).getCorrectOption().equalsIgnoreCase(option5)) {
				marks++;
			}
		}

		if (option6 != null) {
			if (mcQuestions.get(5).getCorrectOption().equalsIgnoreCase(option6)) {
				marks++;
			}
		}

		if (option7 != null) {
			if (mcQuestions.get(6).getCorrectOption().equalsIgnoreCase(option7)) {
				marks++;
			}
		}

		if (option8 != null) {
			if (mcQuestions.get(7).getCorrectOption().equalsIgnoreCase(option8)) {
				marks++;
			}
		}

		if (option9 != null) {
			if (mcQuestions.get(8).getCorrectOption().equalsIgnoreCase(option9)) {
				marks++;
			}
		}

		if (option10 != null) {
			if (mcQuestions.get(9).getCorrectOption().equalsIgnoreCase(option10)) {
				marks++;
			}
		}
		return marks;
	}

}