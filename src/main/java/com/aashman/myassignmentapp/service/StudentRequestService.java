package com.aashman.myassignmentapp.service;

import java.util.List;

import com.aashman.myassignmentapp.models.Student;
import com.aashman.myassignmentapp.models.StudentRequest;
import com.aashman.myassignmentapp.models.Teacher;

public interface StudentRequestService {
	boolean addStudentRequest(int studentId, int teacherId);
	List<Student> findSrOfActiveTeacher(Teacher teacher);
	StudentRequest findSrBySid_Tid(String sid_tid);
}
