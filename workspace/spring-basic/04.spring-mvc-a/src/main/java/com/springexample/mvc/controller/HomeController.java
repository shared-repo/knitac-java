package com.springexample.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // http 요청 처리 객체로 ioc 컨테이너에 등록
public class HomeController {
	
	@RequestMapping(path = { "/", "/home" })
	public String home() {
		
		return "home"; // /WEB-INF/views/ + home + .jsp -> /WEB-INF/views/home.jsp
	}

}
