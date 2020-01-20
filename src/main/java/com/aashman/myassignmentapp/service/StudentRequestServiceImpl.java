package com.aashman.myassignmentapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashman.myassignmentapp.models.Student;
import com.aashman.myassignmentapp.models.StudentRequest;
import com.aashman.myassignmentapp.models.Teacher;
import com.aashman.myassignmentapp.repos.StudentRequestRepository;

@Service
public class StudentRequestServiceImpl implements StudentRequestService {

	@Autowired
	StudentRequestRepository repository;

	@Autowired
	StudentService sService;

	@Override
	public boolean addStudentRequest(int studentId, int teacherId) {
		String sidTid = Integer.toString(studentId) + Integer.toString(teacherId);

		StudentRequest sr = new StudentRequest();
		sr.setStudentId(studentId);
		sr.setTeacherId(teacherId);
		sr.setSidTid(sidTid);
		sr.setSeen("false");
		List<StudentRequest> allSr = repository.findAll();
		for (StudentRequest strt : allSr) {
			if (strt.getSidTid().equals(sidTid)) {
				return false;
			}
		}
		repository.save(sr);
		return true;
	}

	@Override
	public List<Student> findSrOfActiveTeacher(Teacher teacher) {

		List<StudentRequest> allSr = repository.findAll();
		List<StudentRequest> srOfActiveTeacher = new ArrayList<StudentRequest>();
		List<Student> listOfStudents = new ArrayList<Student>();

		for (StudentRequest sr : allSr) {
			if (sr.getTeacherId() == teacher.getTeacherId()) {
				srOfActiveTeacher.add(sr);
			}
		}
		for (StudentRequest s : srOfActiveTeacher) {
			Student student = sService.findStudentByIntegerId(s.getStudentId());
			listOfStudents.add(student);
		}
		return listOfStudents;
	}

	@Override
	public StudentRequest findSrBySid_Tid(String sid_tid) {
		List<StudentRequest> allSr = repository.findAll();
		
		for(StudentRequest sr : allSr) {
			if(sr.getSidTid().equals(sid_tid)) {
				return sr;
			}
		}
		return null;
	}
}
