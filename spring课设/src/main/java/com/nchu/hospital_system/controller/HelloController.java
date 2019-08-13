package com.nchu.hospital_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloController {

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/register")
	public String register(){
		return "register";
	}

	@RequestMapping("/login")
	public String login(){
		return "login";
	}

}
