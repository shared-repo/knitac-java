package com.springexample.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springexample.mvc.dto.Person;

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
//	@RequestMapping(path = { "/demo/param.action" })
//	public String processGetRequest(String data1, 
//									int data2,
//									@RequestParam(defaultValue = "0") int data3) { // 요청 데이터에 없는 전달인자
//		
//		System.out.println(data1 + " / " + data2 + " / " + data3);
//		
//		return "result"; // "/WEB-INF/views/" + result + ".jsp"
//	}
	
	//6. method 속성으로 요청 구분 ( get 요청 수신 )
//	// @RequestMapping(path = { "/demo/param.action" }, method = RequestMethod.GET)
//	@GetMapping(path = { "/demo/param.action" })
//	public String processGetRequest(String data1, 
//									int data2,
//									@RequestParam(defaultValue = "0") int data3) { // 요청 데이터에 없는 전달인자
//		
//		System.out.println(data1 + " / " + data2 + " / " + data3);
//		
//		return "result"; // "/WEB-INF/views/" + result + ".jsp"
//	}
	
	//7. method 속성으로 요청 구분 ( post 요청 수신 )
//	// @RequestMapping(path = { "/demo/param.action" }, method = RequestMethod.POST)
//	@PostMapping(path = { "/demo/param.action" })
//	public String processPostRequest(String name, 
//									 String phone,
//									 String email, 
//									 int age) {
//		
//		Person person = new Person();
//		person.setName(name);
//		person.setPhone(phone);
//		person.setEmail(email);
//		person.setAge(age);
//		
//		// System.out.printf("[%s][%s][%s][%d]\n", name, phone, email, age);
//		System.out.printf(person.toString());
//		
//		return "result"; // "/WEB-INF/views/" + result + ".jsp"
//	}
	
	//8. DTO 전달인자 사용	
//	//   DTO 전달인자 사용하면 자동으로 DTO객체 생성하고 setXXX 메서드 호출
//	//   이 때 property 이름과 요청 데이터 이름이 같아야 합니다
//	//   예를 들어 요청 데이터가 name이면 setName 호출
//	@PostMapping(path = { "/demo/param.action" })
//	public String processPostRequest(Person person, 
//									 String name) { // DTO와 별개로 개별 데이터 수신 가능 
//
//		System.out.println(person.toString());
//		System.out.println("name = " + name);
//		
//		return "result"; // "/WEB-INF/views/" + result + ".jsp"
//	}
	
	//////////////////////////////////////////////////////////////////
	
	//9. JSP로 데이터 전달 ( Model 타입 전달인자 사용 )
	@GetMapping(path = { "/demo/param.action" })
	public String processGetRequest(String data1, 
									int data2,
									Model model) { // Model 타입 전달인자는 JSP로 데이터 전달 통로
		
		model.addAttribute("msg", data1); // -> request 객체에 데이터 저장
		model.addAttribute("cnt", data2);
		model.addAttribute("test", "테스트 데이터를 JSP로 전달합니다." );
		
		return "result"; // "/WEB-INF/views/" + result + ".jsp"
	}
	
	//10. JSP로 데이터 전달 ( DTO 타입의 전달인자 사용 )	
//	@PostMapping(path = { "/demo/param.action" })
//	public String processPostRequest(Person person, // DTO 전달인자는 자동으로 request에 저장 
//									 String name) { // DTO와 별개로 개별 데이터 수신 가능 
//		
//		return "result"; // "/WEB-INF/views/" + result + ".jsp"
//	}
	
	//11. JSP로 데이터 전달 ( ModelAndView 타입의 반환 값 사용 )	
	@PostMapping(path = { "/demo/param.action" })
	public ModelAndView processPostRequest(Person person, // DTO 전달인자는 자동으로 request에 저장 
									 String name) { // DTO와 별개로 개별 데이터 수신 가능 
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result"); // "/WEB-INF/views/" + result + ".jsp"
		mav.addObject("myperson", person);
		
		return mav;
	}

}






