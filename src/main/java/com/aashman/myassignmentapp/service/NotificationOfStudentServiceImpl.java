package com.aashman.myassignmentapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashman.myassignmentapp.models.NotificationOfStudent;
import com.aashman.myassignmentapp.repos.NotificationOfStudentRepository;

@Service
public class NotificationOfStudentServiceImpl implements NotificationOfStudentService {

	@Autowired
	NotificationOfStudentRepository nosRepository;

	@Override
	public List<NotificationOfStudent> getNotificationsOfAStudent(int studentId) {
		List<NotificationOfStudent> allNotifications = nosRepository.findAll();
		List<NotificationOfStudent> notificationsOfAStudent = new ArrayList<NotificationOfStudent>();
		for (NotificationOfStudent nos : allNotifications) {
             if(nos.getStudentId() == studentId) {
            	 notificationsOfAStudent.add(nos);
             }
		}
		return notificationsOfAStudent;
	}
}
