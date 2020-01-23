package com.aashman.myassignmentapp.controllers;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aashman.myassignmentapp.models.Student;
import com.aashman.myassignmentapp.models.Teacher;
import com.aashman.myassignmentapp.repos.StudentRequestRepository;
import com.aashman.myassignmentapp.repos.TeacherRepository;
import com.aashman.myassignmentapp.service.StudentRequestService;
import com.aashman.myassignmentapp.service.StudentService;
import com.aashman.myassignmentapp.service.TeacherService;

@Controller
public class TeacherController {

	@Autowired
	TeacherRepository teacherRepository;

	@Autowired
	TeacherService teacherService;

	@Autowired
	StudentRequestRepository srRepository;

	@Autowired
	StudentRequestService srService;

	@Autowired
	StudentService studentService;

	@RequestMapping("/teacherLogIn")
	public String showTeacherLogIn() {
		return "login/teacherLogIn";
	}

	@RequestMapping("/signUpTeacher")
	public String signUpTeacher() {
		return "login/teacherSignUp";
	}

	@RequestMapping(value = "/registerTeacher", method = RequestMethod.POST)
	@Transactional
	public String registerStudent(@ModelAttribute Teacher teacher, Model model) {
		if (teacherService.addTeacher(teacher)) {
			model.addAttribute("message", "Sign Up Sucessfully,Click Log In To Log In.");
			return "login/teacherSignUp";
		} else {
			model.addAttribute("msg", "Please try again something went wrong");
			return "login/teacherSignUp";
		}
	}

	@RequestMapping(value = "/enterTeacherHome", method = RequestMethod.POST)
	public String enterTeacherHome(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("activeTeacher", username);
		if (teacherService.enterTeacherHomePage(username, password)) {
			return "TeacherHome";
		} else {
			model.addAttribute("msg", "Username or password is incorrect please try again");
			return "index";
		}
	}

	@RequestMapping("/showTeacherHome")
	public String showTeacherHome(HttpServletRequest request) {
		if (request.getSession().getAttribute("activeTeacher") == null) {
			return "index";
		}
		return "TeacherHome";
	}

	@RequestMapping("/showTeacherAccount")
	public String showTeacherAccount(HttpServletRequest request,Model model) {
		String userName = (String)request.getSession().getAttribute("activeTeacher");
		if (userName== null) {
			return "index";
		}
		model.addAttribute("LoggedInTeacher",teacherService.findTeacherByUserName(userName));
		return "teacher/account";
	}

	@RequestMapping("/showTeacherAssignments")
	public String showTeacherAssignments(HttpServletRequest request) {
		if (request.getSession().getAttribute("activeTeacher")== null) {
			return "index";
		}
		return "teacher/assignments";
	}

	@RequestMapping("/showTeacherNotifications")
	public String showTeacherStudentRequests(HttpServletRequest request) {
		if (request.getSession().getAttribute("activeTeacher")== null) {
			return "index";
		}
		return "teacher/notifications";
	}

	@RequestMapping("/showTeacherStudents")
	public String showTeacherStudents(HttpServletRequest request, Model model) {
		String teacherUserName = (String) request.getSession().getAttribute("activeTeacher");
		if (teacherUserName== null) {
			return "index";
		}
		Teacher teacher = teacherService.findTeacherByUserName(teacherUserName);
		Set<Student> students = teacher.getStudent();
		model.addAttribute("studentsOfActiveTeacher", students);
		return "teacher/students";
	}

	@RequestMapping("/showTeacherStudentRequests")
	public String showTeacherNotifications(HttpServletRequest request, Model model) {
		String username = (String) request.getSession().getAttribute("activeTeacher");
		if (username== null) {
			return "index";
		} else {
			List<Student> allStudentRequests = srService
					.findSrOfActiveTeacher(teacherService.findTeacherByUserName(username));
			model.addAttribute("allStudentRequests", allStudentRequests);
			return "teacher/studentrequests";
		}
	}

	@RequestMapping("/addStudentToList")
	@Transactional
	public String addStudentToList(@RequestParam("studentId") int studentId,
			@RequestParam("activeTeacher") String teacherUserName, Model model, HttpServletRequest request) {
		if (request.getSession().getAttribute("activeTeacher")== null) {
			return "index";
		}
		Teacher teacher = teacherService.findTeacherByUserName(teacherUserName);
		Student student = studentService.findStudentByIntegerId(studentId);
		List<Student> allStudentRequests = srService.findSrOfActiveTeacher(teacher);
		if (teacherService.addStudentToList(student, teacherUserName, teacher) && student.getTeachers().add(teacher)) {
			allStudentRequests = srService.findSrOfActiveTeacher(teacher);
			model.addAttribute("allStudentRequests", allStudentRequests);
			model.addAttribute("studentAddedMessage", "Student added!");
			return "teacher/studentrequests";
		}
		model.addAttribute("allStudentRequests", allStudentRequests);
		return "teacher/studentrequests";
	}

	@RequestMapping(value = "/addMcAssignment", method = RequestMethod.POST)
	public String addMcAssignment() {
		return null;
	}
	
	
	@RequestMapping("/logOutTeacher")
	public String logOutTeacher(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}
}
