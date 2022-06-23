package com.demoweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demoweb.dto.Member;
import com.demoweb.service.AccountService;
import com.demoweb.service.AccountServiceImpl;

@Controller
@RequestMapping(path = { "/account" })
public class AccountController {
	
	@Autowired
	@Qualifier("accountService")
	private AccountService accountService;
	
	
	// 아래 코드와 같이 컨트롤러의 역할이 오직 jsp로 전달하는 것이라면 
	// 설정 파일을 통해 대체 가능 ( <view-controller 요소 사용 )
	
	// @GetMapping(path = { "/account/register" })
	@GetMapping(path = { "/register" }) // /account 경로를 Controller 클래스에 설정
	public String showRegisterForm() {
		
		return "account/register"; // -> /WEB-INF/views/account/register.jsp
	}
	
	
	@PostMapping(path = { "/register2" })
	public String register(Member member) {
		
		// AccountService accountService = new AccountServiceImpl();
		accountService.registerMember(member);
		
		return "redirect:login";
	}
	
	@GetMapping(path = { "/login" })
	public String showLoginForm() {
		
		return "account/login";
	}
	
	@PostMapping(path = { "/login" })
	public String login(Member member, HttpSession session) {
		
		// AccountService accountService = new AccountServiceImpl();
		Member member2 = accountService.findMemberByIdAndPasswd(member);
		
		if (member2 != null) {
			session.setAttribute("loginuser", member2);
		} else {			
		}
		
		return "redirect:/home";
	}
	
	@GetMapping(path = { "/logout" })
	public String logout(HttpSession session) {
		
		session.removeAttribute("loginuser");
		
		return "redirect:/home";
	}

}






