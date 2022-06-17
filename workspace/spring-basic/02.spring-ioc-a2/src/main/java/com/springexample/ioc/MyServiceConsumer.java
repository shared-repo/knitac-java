package com.springexample.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("serviceConsumer") // <bean id="serviceConsumer" class="...MyServiceConsumer"
public class MyServiceConsumer implements ServiceConsumer {
	
	@Autowired // 자동 주입 ( 컨테이너에 등록된 빈 중 적합한 것을 자동으로 주입 )
	@Qualifier("messageService") // id="messageService"인 빈을 자동 주입
	private MessageService messageService;
	
	@Autowired // 자동 주입 ( 컨테이너에 등록된 빈 중 적합한 것을 자동으로 주입 )
	@Qualifier("timeService") // id="messageService"인 빈을 자동 주입
	private TimeService timeService; // 주입된 의존성(객체)을 저장할 참조 변수
	
	public void doSomething() {
		
		String message = messageService.getMessage();		
		System.out.println(message);
		
		String timeString = timeService.getTimeString();
		System.out.println(timeString);
		
	}

}








