package com.springexample.ioc;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		
		//1. 클래스를 명시적으로 사용 (의존성 발생 )
		// MyServiceConsumer serviceConsumer = new MyServiceConsumer();
		
		//2. 인터페이스 사용 ( 의존성 잔존 )
		// ServiceConsumer serviceConsumer = new MyServiceConsumer();
		
		//3. 스프링의 IoC Container 사용 ( 의존성 제거 )
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("app-context.xml");
		ServiceConsumer serviceConsumer = 
				context.getBean("serviceConsumer", ServiceConsumer.class);
		
		serviceConsumer.doSomething();
		
		context.close();
	}

}





