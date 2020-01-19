package com.aashman.myassignmentapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int teacherId;
	private int studentId;
	private String sidTid;
	private String seen;

	public int getId() {
		return id;
	}

	public String getSidTid() {
		return sidTid;
	}

	public void setSidTid(String sidTid) {
		this.sidTid = sidTid;
	}

	public String getSeen() {
		return seen;
	}

	public void setSeen(String seen) {
		this.seen = seen;
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

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "StudentRequest [id=" + id + ", teacherId=" + teacherId + ", studentId=" + studentId + ", sidTid="
				+ sidTid + ", seen=" + seen + "]";
	}

}
