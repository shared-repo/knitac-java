package com.springexample.ioc;

public class TestMain {

	public static void main(String[] args) {
		
		//1. 클래스를 명시적으로 사용
		// MyServiceConsumer serviceConsumer = new MyServiceConsumer();
		
		//2. 인터페이스 사용
		ServiceConsumer serviceConsumer = new MyServiceConsumer();
		
		serviceConsumer.doSomething();
	}

}
