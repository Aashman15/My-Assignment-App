package com.aashman.myassignmentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aashman.myassignmentapp.models.McQuestion;
import com.aashman.myassignmentapp.models.MultipleChoiceAssignment;
import com.aashman.myassignmentapp.models.NotificationOfStudent;
import com.aashman.myassignmentapp.models.Student;
import com.aashman.myassignmentapp.models.StudentRequest;
import com.aashman.myassignmentapp.models.Teacher;
import com.aashman.myassignmentapp.repos.McAssignmentRepository;
import com.aashman.myassignmentapp.repos.NotificationOfStudentRepository;
import com.aashman.myassignmentapp.repos.StudentRequestRepository;
import com.aashman.myassignmentapp.repos.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherRepository teacherRepository;

	@Autowired
	StudentRequestService srService;

	@Autowired
	StudentRequestRepository srRepository;

	@Autowired
	NotificationOfStudentRepository nosRepository;

	@Autowired
	McAssignmentRepository mcAssignmentRepository;

	@Transactional
	@Override
	public boolean addTeacher(Teacher teacher) {
		if (teacher.getFirstName().isEmpty() || teacher.getLastName().isEmpty() || teacher.getAddress().isEmpty()
				|| teacher.getPhoneNumber().isEmpty() || teacher.getDob().isEmpty()
				|| teacher.getGender().toString().isEmpty() || teacher.getUserName().isEmpty()
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
	public Teacher findTeacherByUserName(String username) {
		List<Teacher> teachers = teacherRepository.findAll();
		for (Teacher teacher : teachers) {
			if (teacher.getUserName().equals(username)) {
				return teacher;
			}
		}
		return null;
	}

	@Override
	@Transactional
	public boolean addStudentToList(Student student, String teacherUserName, Teacher teacher) {
		int teacherId = teacher.getTeacherId();
		String sid_tid = Integer.toString(student.getStudentId()) + Integer.toString(teacherId);
		StudentRequest sr = srService.findSrBySid_Tid(sid_tid);

		String notification = "Teacher: " + teacher.getFirstName() + "  have accepted your request! "
				+ " Enjoy assignments. Make your future bright.";
		NotificationOfStudent nos = new NotificationOfStudent();
		nos.setStudentId(student.getStudentId());
		nos.setNotification(notification);

		nosRepository.save(nos);
		srRepository.delete(sr);
		teacher.getStudent().add(student);

		return true;
	}

	@Override
	public boolean addMcAssignment(List<McQuestion> mcQuestion, String topic, Teacher teacher) {
		MultipleChoiceAssignment mcAssignment = new MultipleChoiceAssignment();
		mcAssignment.setQuestion(mcQuestion);
		mcAssignment.setTopic(topic);
		mcAssignment.setTeacher(teacher);
		return true;
	}

	@Override
	public boolean updateTeacher(Teacher teacher, Teacher updatedTeacher) {
		teacher.setFirstName(updatedTeacher.getFirstName());
		teacher.setMiddleName(updatedTeacher.getMiddleName());
		teacher.setLastName(updatedTeacher.getLastName());
		teacher.setAddress(updatedTeacher.getAddress());
		teacher.setDob(updatedTeacher.getDob());
		teacher.setGender(updatedTeacher.getGender());
		teacher.setPassword(updatedTeacher.getPassword());
		teacher.setUserName(updatedTeacher.getUserName());
		teacher.setPhoneNumber(updatedTeacher.getPhoneNumber());
		teacherRepository.save(teacher);
		return true;
	}
}
