package com.aashman.myassignmentapp.models;

public class StudentRequest {
	private int id;
	private int studentId;
	private String studentFullName;
	private String studentUserName;
	private String seen;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentFullName() {
		return studentFullName;
	}

	public void setStudentFullName(String studentFullName) {
		this.studentFullName = studentFullName;
	}

	public String getStudentUserName() {
		return studentUserName;
	}

	public void setStudentUserName(String studentUserName) {
		this.studentUserName = studentUserName;
	}

	public String getSeen() {
		return seen;
	}

	public void setSeen(String seen) {
		this.seen = seen;
	}

	@Override
	public String toString() {
		return "StudentRequest [id=" + id + ", studentId=" + studentId + ", studentFullName=" + studentFullName
				+ ", studentUserName=" + studentUserName + ", seen=" + seen + "]";
	}
}
