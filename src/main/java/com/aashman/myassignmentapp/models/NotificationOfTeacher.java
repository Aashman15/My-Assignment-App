package com.aashman.myassignmentapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notificationofteacher")
public class NotificationOfTeacher {

	@Id
	@GeneratedValue
	@Column(name = "not_id")
	int id;
	@Column(name = "teacher_id")
	int teacherId;
	@Column(name = "notification")
	String notification;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}
}
