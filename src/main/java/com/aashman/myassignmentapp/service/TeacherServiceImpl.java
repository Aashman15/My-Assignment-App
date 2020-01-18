package com.aashman.myassignmentapp.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aashman.myassignmentapp.db.Db;
import com.aashman.myassignmentapp.models.StudentRequest;
import com.aashman.myassignmentapp.models.Teacher;
import com.aashman.myassignmentapp.repos.TeacherRepository;
import com.mysql.jdbc.Statement;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherRepository teacherRepository;

	@Transactional
	@Override
	public boolean addTeacher(Teacher teacher) {
		if (teacher.getFirstName().isEmpty() || teacher.getLastName().isEmpty() || teacher.getAddress().isEmpty()
				|| teacher.getPhoneNumber().isEmpty() || teacher.getDob().isEmpty()
				|| teacher.getGender().toString().isBlank() || teacher.getUserName().isEmpty()
				|| teacher.getPassword().isEmpty()) {
			return false;
		}

		String sql = "CREATE TABLE " + teacher.getUserName() + "sr(" + "ID int NOT NULL AUTO_INCREMENT,"
				+ "studentId int," + "studentFullName varchar(500)," + "studentUserName varchar(500),"
				+ "seen varchar(100)," + " PRIMARY KEY (ID,studentUserName,studentId)" + ");";
		try {
			Statement stm = (Statement) Db.getDb().createStatement();
			stm.executeUpdate(sql);
			teacherRepository.save(teacher);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean enterTeacherHomePage(String username, String password) {
		List<Teacher> teachers = teacherRepository.findAll();
		for (Teacher t : teachers) {
			if (t.getUserName().equals(username) && t.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public List<StudentRequest> getAllStudentRequests(String dbTableName) {
		String sql = "select * from " + dbTableName;
		List<StudentRequest> allsr = new ArrayList<StudentRequest>();
		try {
			java.sql.Statement stm = Db.getDb().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				StudentRequest sr = new StudentRequest();
				sr.setId(rs.getInt("ID"));
				sr.setStudentId(rs.getInt("studentId"));
				sr.setStudentFullName(rs.getString("studentFullName"));
				sr.setStudentUserName(rs.getString("studentUserName"));
				sr.setSeen(rs.getString("seen"));
				
				allsr.add(sr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allsr;
	}
	
}
	


