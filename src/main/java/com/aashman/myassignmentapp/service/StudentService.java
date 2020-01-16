package com.aashman.myassignmentapp.service;

import com.aashman.myassignmentapp.models.Student;

public interface StudentService {
	boolean addStudent(Student student);
	boolean enterStudentHomePage(String email, String password);
}
