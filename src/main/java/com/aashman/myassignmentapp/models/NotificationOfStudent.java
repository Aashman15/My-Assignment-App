package com.aashman.myassignmentapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notificationofstudent")
public class NotificationOfStudent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int notificationId;
	int studentId;
	String notification;

	public int getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	@Override
	public String toString() {
		return "NotificationOfStudent [notificationId=" + notificationId + ", studentId=" + studentId
				+ ", notification=" + notification + "]";
	}

}
