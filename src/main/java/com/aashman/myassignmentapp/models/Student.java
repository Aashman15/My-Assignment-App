package com.aashman.myassignmentapp.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String dob;
	private String gender;
	private String userName;
	private String password;

	@ManyToMany(mappedBy = "student")
	private List<Teacher> teacher = new ArrayList<Teacher>();

	public List<Teacher> getTeachers() {
		return teacher;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teacher = teachers;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", address=" + address + ", phoneNumber=" + phoneNumber + ", dob=" + dob
				+ ", gender=" + gender + ", userName=" + userName + ", password=" + password + ", teacher=" + teacher
				+ "]";
	}

}
