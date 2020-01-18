package com.aashman.myassignmentapp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashman.myassignmentapp.db.Db;
import com.aashman.myassignmentapp.models.Teacher;
import com.aashman.myassignmentapp.repos.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherRepository teacherRepository;

	@Override
	public boolean addTeacher(Teacher teacher) {
		if (teacher.getFirstName().isEmpty() || teacher.getLastName().isEmpty() || teacher.getAddress().isEmpty()
				|| teacher.getPhoneNumber().isEmpty() || teacher.getDob().isEmpty()
				|| teacher.getGender().toString().isBlank() || teacher.getUserName().isEmpty()
				|| teacher.getPassword().isEmpty()) {
			return false;
		}
		teacherRepository.save(teacher);
		return true;
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
	public boolean createTable(String username) {
		Db db = new Db();
		String sql = "CREATE TABLE dbfor" + username + " ();";
		
		
		
		
		return false;
	}
	
}
