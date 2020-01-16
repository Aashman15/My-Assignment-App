package com.aashman.myassignmentapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeacherController {

	@RequestMapping("/teacherLogIn")
	public String showTeacherLogIn() {
		return "login/teacherLogIn";
	}

	@RequestMapping("/signUpTeacher")
	public String signUpTeacher() {
		return "login/teacherSignUp";
	}
}
