package com.aashman.myassignmentapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashman.myassignmentapp.models.MultipleChoiceAssignment;
import com.aashman.myassignmentapp.models.NotificationOfTeacher;
import com.aashman.myassignmentapp.models.Student;
import com.aashman.myassignmentapp.repos.NotificationOfTeacherRepository;
import com.aashman.myassignmentapp.repos.StudentRepository;

@Service
public class NotificationOfTeacherServiceImpl implements NotificationOfTeacherService {

	@Autowired
	NotificationOfTeacherRepository notRepository;

	@Autowired
	StudentRepository sRepository;

	@Autowired
	StudentService studentService;

	@Override
	public boolean addStudentDidAssignmentNotification(int studentID, MultipleChoiceAssignment mca, int teacherId,String leftWords) {
		Student student = studentService.findStudentByIntegerId(studentID);
		String notification = "Your student " + student.getFirstName() + " " + student.getLastName()
				+ " did your assignment: " + mca.getTopic() + " " + leftWords;
		NotificationOfTeacher not = new NotificationOfTeacher();
		not.setNotification(notification);
		not.setTeacherId(teacherId);
		notRepository.save(not);
		return true;
	}

}
