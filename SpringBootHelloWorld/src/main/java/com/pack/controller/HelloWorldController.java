package com.pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "index";
		
	}
	@RequestMapping("/click")
	public String welcomeUser() {
		return "details";
	}

}
