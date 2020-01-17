package com.aashman.myassignmentapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aashman.myassignmentapp.models.Student;
import com.aashman.myassignmentapp.repos.StudentRepository;
import com.aashman.myassignmentapp.repos.TeacherRepository;
import com.aashman.myassignmentapp.service.StudentService;
import com.aashman.myassignmentapp.service.TeacherService;

@Controller
public class StudentController {
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	StudentService studentService;
	
	@Autowired
    TeacherRepository teacherRepository;
	
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
			Model model) {
		if (studentService.enterStudentHomePage(userName, password)) {
			return "StudentHome";
		} else {
			model.addAttribute("msg", "username or password is incorrect, please try again");
			return "index";
		}
	}
	
    @RequestMapping("/showStudentAccountPage")
	public String showStudentAccount() {
		return "student/account";
	}
    
    @RequestMapping("/showStudentTeachersPage")
    public String showStudentTeachers(Model model) {
    	model.addAttribute("teacher", teacherRepository.findAll());
    	return "student/teachers";
    }
    
    @RequestMapping("/showStudentAssignmentsPage")
    public String showStudentAssignments() {
    	return "student/assignments";
    }
    
    @RequestMapping("/showStudentHome")
    public String showStudentHome() {
    	return "StudentHome";
    }
}















