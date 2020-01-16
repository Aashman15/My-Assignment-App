package com.aashman.myassignmentapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.aashman.myassignmentapp.models.Teacher;
import com.aashman.myassignmentapp.service.TeacherService;

@Controller
public class TeacherController {
	@Autowired
	TeacherService teacherService;

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
			return "login/teacherLogIn";
		} else {
			model.addAttribute("msg", "Please fill the boxes.");
			return "login/teacherSignUp";
		}
	}

	@RequestMapping(value = "/enterTeacherHome", method = RequestMethod.POST)
	public String enterTeacherHome(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) {
		if (teacherService.enterTeacherHomePage(username, password)) {
			return "TeacherHome";
		} else {
			model.addAttribute("msg", "Username or password is incorrect");
			return "login/teacherLogIn";
		}
	}
}
