package com.aashman.myassignmentapp.controllers;

import java.util.List;

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

import com.aashman.myassignmentapp.models.NotificationOfStudent;
import com.aashman.myassignmentapp.models.Student;
import com.aashman.myassignmentapp.models.Teacher;
import com.aashman.myassignmentapp.repos.StudentRepository;
import com.aashman.myassignmentapp.repos.TeacherRepository;
import com.aashman.myassignmentapp.service.NotificationOfStudentService;
import com.aashman.myassignmentapp.service.StudentRequestService;
import com.aashman.myassignmentapp.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	StudentService studentService;

	@Autowired
	TeacherRepository teacherRepository;

	@Autowired
	StudentRequestService studentRequestService;

	@Autowired
	NotificationOfStudentService nosService;

	@RequestMapping("/studentLogIn")
	public String showStudentLogIn() {
		return "login/studentLogIn";
	}

	@RequestMapping("/signUpStudent")
	public String signUpStudent() {
		return "login/studentSignUp";
	}

	@RequestMapping(value = "/registerStudent", method = RequestMethod.POST)
	@Transactional
	public String registerStudent(@ModelAttribute Student student, Model model) {
		if (studentService.addStudent(student)) {
			model.addAttribute("message", "Sign Up Sucessfully, Go back and Do Log In.");
			return "login/studentSignUp";
		} else {
			model.addAttribute("msg", "Please fill the boxes.");
			return "login/studentSignUp";
		}
	}

	@RequestMapping(value = "/enterStudentHome", method = RequestMethod.POST)
	public String logInStudent(@RequestParam("userName") String userName, @RequestParam("password") String password,
			Model model, HttpServletRequest request) {
		if (studentService.enterStudentHomePage(userName, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("student", studentService.findStudentByUserName(userName));
			return "StudentHome";
		} else {
			model.addAttribute("msg", "username or password is incorrect, please try again");
			return "index";
		}
	}

	@RequestMapping("/showStudentAccountPage")
	public String showStudentAccount(HttpServletRequest studentRequest) {
		if (studentRequest.getSession().getAttribute("student") == null) {
			return "index";
		}
		return "student/account";
	}

	@RequestMapping("/showStudentTeachersPage")
	public String showStudentTeachers(Model model, HttpServletRequest studentRequest) {
		if (studentRequest.getSession().getAttribute("student") == null) {
			return "index";
		}
		model.addAttribute("teacher", teacherRepository.findAll());
		return "student/teachers";
	}

	@RequestMapping("/showStudentAssignmentsPage")
	public String showStudentAssignments(HttpServletRequest studentRequest) {
		if (studentRequest.getSession().getAttribute("student") == null) {
			return "index";
		}
		return "student/assignments";
	}

	@RequestMapping("/showStudentHome")
	public String showStudentHome(HttpServletRequest studentRequest) {
		if (studentRequest.getSession().getAttribute("student") == null) {
			return "index";
		}
		return "StudentHome";
	}

	@RequestMapping("/showNotificationsPage")
	public String showNotifications(HttpServletRequest request, @RequestParam("studentId") int studentId, Model model) {
		List<NotificationOfStudent> nos = nosService.getNotificationsOfAStudent(studentId);
		if (request.getSession().getAttribute("student") == null) {
			return "index";
		}
		if (nos.equals(null)) {
			model.addAttribute("noNos", "You donot have any notifications yet!");
		} else {
			model.addAttribute("nos", nos);
		}
		return "student/notifications";
	}

	@RequestMapping("/logOut")
	public String logOut(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	@RequestMapping("/sendRequest")
	public String sendRequestToTeacher(@RequestParam("studentId") int studentId,
			@RequestParam("teacherId") int teacherId, Model model) {
		Teacher teacher = teacherRepository.findById(teacherId).get();

		if (studentRequestService.addStudentRequest((Integer) studentId, (Integer) teacherId)) {
			model.addAttribute("requestSentMsg", "request sent! wait to get response back !");
			model.addAttribute("beStudent", "Be" + teacher.getFirstName() + "'s Student");
		} else {
			model.addAttribute("errorsendingrequest",
					"Sorry request failed ! May be you have already clicked the link and sent the request!");
		}
		model.addAttribute("teacher", teacherRepository.findAll());
		return "student/teachers";
	}
}
