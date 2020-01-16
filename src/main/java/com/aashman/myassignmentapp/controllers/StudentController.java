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
import com.aashman.myassignmentapp.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	StudentService studentService;

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
	public String registerStudent(@RequestParam("gender") String gender, @ModelAttribute Student student, Model model) {
		if (studentService.addStudent(student)) {
			return "login/studentLogIn";
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
			model.addAttribute("msg", "username or password is incorrect");
			return "login/studentLogIn";
		}
	}
}
