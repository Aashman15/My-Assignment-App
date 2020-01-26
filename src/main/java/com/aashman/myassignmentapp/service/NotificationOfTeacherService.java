package com.aashman.myassignmentapp.service;

import com.aashman.myassignmentapp.models.MultipleChoiceAssignment;

public interface NotificationOfTeacherService {
    boolean addStudentDidAssignmentNotification(int studentID,MultipleChoiceAssignment mca, int teacherId);
}
