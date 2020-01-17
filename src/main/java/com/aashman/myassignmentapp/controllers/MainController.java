package com.aashman.myassignmentapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
     
	@RequestMapping("")
	public String showIndexJsp() {
		return "index";
	}
	
	@RequestMapping("/showIndex")
	public String showIndex() {
		return "index";
	}
}
