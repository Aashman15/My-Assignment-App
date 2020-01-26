package com.aashman.myassignmentapp.service;

import java.util.List;

import com.aashman.myassignmentapp.models.McQuestion;
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

	int submitAssignment(List<McQuestion> mcQuestions, String option1, String option2, String option3, String option4,
			String option5, String option6, String option7, String option8, String option9, String option10);

	boolean updateStudent(Student student);

}
