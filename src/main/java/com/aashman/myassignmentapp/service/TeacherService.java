package com.aashman.myassignmentapp.service;


import java.util.List;

import com.aashman.myassignmentapp.models.StudentRequest;
import com.aashman.myassignmentapp.models.Teacher;

public interface TeacherService {
     boolean addTeacher(Teacher teacher);
     boolean enterTeacherHomePage(String username, String password);
     List<StudentRequest> getAllStudentRequests(String dbTableName);
}
