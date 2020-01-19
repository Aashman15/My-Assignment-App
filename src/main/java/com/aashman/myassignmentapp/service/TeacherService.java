package com.aashman.myassignmentapp.service;


import com.aashman.myassignmentapp.models.Teacher;

public interface TeacherService {
     boolean addTeacher(Teacher teacher);
     boolean enterTeacherHomePage(String username, String password);
     Teacher findTeacherByUserName(String username);
}
