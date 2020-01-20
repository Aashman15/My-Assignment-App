package com.aashman.myassignmentapp.service;

import java.util.List;

import com.aashman.myassignmentapp.models.NotificationOfStudent;

public interface NotificationOfStudentService {
    List<NotificationOfStudent> getNotificationsOfAStudent(int studentId);
}
