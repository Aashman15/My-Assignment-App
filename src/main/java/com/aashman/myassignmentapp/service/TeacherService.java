package com.aashman.myassignmentapp.service;


import java.util.List;

import com.aashman.myassignmentapp.models.McQuestion;
import com.aashman.myassignmentapp.models.Student;
import com.aashman.myassignmentapp.models.Teacher;

public interface TeacherService {
     boolean addTeacher(Teacher teacher);
     boolean enterTeacherHomePage(String username, String password);
     Teacher findTeacherByUserName(String username);
     boolean addStudentToList(Student student, String teacherUserName, Teacher teacher);
     boolean addMcAssignment(List<McQuestion> mcQuestion, String topic, Teacher teacher);
     boolean updateTeacher(Teacher teacher,Teacher updatedTeacher);
}
