package com.demoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping(path = { "/", "/home" })
	public String home() {
		
		return "home";	// /WEB-INF/views/ + "home" + .jsp -> /WEB-INF/views/home2.jsp
		
	}

}
