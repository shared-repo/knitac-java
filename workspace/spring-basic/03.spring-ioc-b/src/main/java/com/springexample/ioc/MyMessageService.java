package com.springexample.ioc;

public class MyMessageService implements MessageService {
	
	int data;
	public MyMessageService() {
		data = (int)(Math.random() * 900) + 100;
	}
	
	public String getMessage() {
		return "Hello, Spring IoC Container !!!" + data;
	}
	
	public void init() {
		System.out.println("MyMessageService.init()");
	}
	
	public void destroy() {
		System.out.println("MyMessageServce.destroy()");
	}

}
