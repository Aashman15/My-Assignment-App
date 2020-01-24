package com.aashman.myassignmentapp.service;

import java.util.List;

import com.aashman.myassignmentapp.models.MultipleChoiceAssignment;
import com.aashman.myassignmentapp.models.Student;
import com.aashman.myassignmentapp.models.Teacher;

public interface StudentService {
	boolean addStudent(Student student);
	boolean enterStudentHomePage(String email, String password);
	Student findStudentByUserName(String userName);
	Student findStudentByIntegerId(int id);
	List<Teacher> findAvailableTeachersOfStudent(Student student);
	List<MultipleChoiceAssignment> findMcAssignmentsOfStudent(Student student);
}
