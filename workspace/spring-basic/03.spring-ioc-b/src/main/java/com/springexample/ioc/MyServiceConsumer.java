package com.springexample.ioc;

public class MyServiceConsumer implements ServiceConsumer {
	
	private MessageService messageService = new MyMessageService();
	public void setMessageService(MessageService messageService) { //의존성 주입 통로
		this.messageService = messageService;
	}	
	private TimeService timeService; // 주입된 의존성(객체)을 저장할 참조 변수
	public void setTimeService(TimeService timeService) { //의존성 주입 통로
		this.timeService = timeService;
	}
	public void doSomething() {		
		String message = messageService.getMessage();
		
		System.out.println(message);
		
	}

}








