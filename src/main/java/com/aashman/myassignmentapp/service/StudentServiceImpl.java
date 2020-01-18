package com.aashman.myassignmentapp.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashman.myassignmentapp.db.Db;
import com.aashman.myassignmentapp.models.Student;
import com.aashman.myassignmentapp.repos.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public boolean addStudent(Student student) {
		if (student.getFirstName().isEmpty() || student.getLastName().isEmpty() || student.getAddress().isEmpty()
				|| student.getPhoneNumber().isEmpty() || student.getDob().isEmpty()
				|| student.getGender().toString().isBlank() || student.getUserName().isEmpty()
				|| student.getPassword().isEmpty()) {
			return false;
		}
		studentRepository.save(student);
		return true;
	}

	@Override
	public boolean enterStudentHomePage(String userName, String password) {
		List<Student> students = studentRepository.findAll();
		for (Student s : students) {
			if (s.getUserName().equals(userName) && s.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Student findStudentByUserName(String userName) {
		List<Student> allStudents =  studentRepository.findAll();
		for(Student s : allStudents) {
			if(s.getUserName().equals(userName)) {
				return s;
			}
		}
		return null;
	}

	@Override
	public boolean addStudentRequest(String dbTableName, Student student) {
		String tname = dbTableName.toLowerCase();
		
		String query = "select studentFullName from " + tname + " where studentId = " + student.getId();
		try {
			java.sql.Statement stm = Db.getDb().createStatement();
			ResultSet rs = stm.executeQuery(query);
			if(rs.next()) {
				return false;
			}else {
				String sql = "insert into " + tname+ " (studentId,studentFullName,studentUserName,seen) values(?,?,?,?)";
				try {
					PreparedStatement pstm = Db.getDb().prepareStatement(sql);
					pstm.setInt(1, student.getId());
					pstm.setString(2, student.getFirstName()+ " " + student.getMiddleName()+ " " + student.getLastName());
					pstm.setString(3, student.getUserName());
					pstm.setString(4, "false");
					pstm.execute();
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}
}