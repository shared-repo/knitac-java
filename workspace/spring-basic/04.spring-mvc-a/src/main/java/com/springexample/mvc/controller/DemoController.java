package com.springexample.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

	//1. 요청 데이터 수신하지 않고 처리 ( 전달인자 없음 )
//	@RequestMapping(path = { "/demo/param.action" })
//	public String processGetRequest() {
//		
//		return "result"; // "/WEB-INF/views/" + result + ".jsp"
//	}
	
	//2. HttpServletRequest 전달 인자로 요청 데이터 수신
//	@RequestMapping(path = { "/demo/param.action" })
//	public String processGetRequest(HttpServletRequest req) {
//		
//		String data1 = req.getParameter("data1");
//		String sData2 = req.getParameter("data2");
//		int data2 = Integer.parseInt(sData2);
//		
//		System.out.println(data1 + " / " + data2);
//		
//		return "result"; // "/WEB-INF/views/" + result + ".jsp"
//	}
	
	//3. 전달 인자로 직접 요청 데이터 수신 ( 전달인자의 이름과 요청 데이터의 이름이 일치해야 합니다. )
//	@RequestMapping(path = { "/demo/param.action" })
//	public String processGetRequest(String data1, int data2) {
//		
//		System.out.println(data1 + " / " + data2);
//		
//		return "result"; // "/WEB-INF/views/" + result + ".jsp"
//	}
	
	//4. 전달 인자로 직접 요청 데이터 수신 ( 전달인자의 이름과 요청 데이터의 이름이 다른 경우 )
//	@RequestMapping(path = { "/demo/param.action" })
//	public String processGetRequest(@RequestParam(name="data1")String d1, 
//									@RequestParam(name="data2")int d2) {
//		
//		System.out.println(d1 + " / " + d2);
//		
//		return "result"; // "/WEB-INF/views/" + result + ".jsp"
//	}
	
	//5. 전달 인자로 직접 요청 데이터 수신 ( 지정된 전달인자에 해당하는 요청 데이터가 없는 경우 )
	@RequestMapping(path = { "/demo/param.action" })
	public String processGetRequest(String data1, 
									int data2,
									@RequestParam(defaultValue = "0") int data3) { // 요청 데이터에 없는 전달인자
		
		System.out.println(data1 + " / " + data2 + " / " + data3);
		
		return "result"; // "/WEB-INF/views/" + result + ".jsp"
	}

}






