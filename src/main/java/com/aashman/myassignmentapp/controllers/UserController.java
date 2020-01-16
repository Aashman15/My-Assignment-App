package com.aashman.myassignmentapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    
	@RequestMapping("/studentLogIn")
	public String showStudentLogIn() {
	     return "login/studentLogIn";	
	}
	
	@RequestMapping("/teacherLogIn")
	public String showTeacherLogIn() {
	     return "login/teacherLogIn";	
	}
}
