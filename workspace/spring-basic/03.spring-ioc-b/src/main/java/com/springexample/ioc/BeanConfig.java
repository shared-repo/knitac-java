package com.springexample.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // app-context.xml 파일과 같은 설정을 처리하는 클래스로 지정
public class BeanConfig {
	
	@Bean //(name = "serviceConsumer") app-context.xml에서는 <bean id="serviceConsumer" ...
	public ServiceConsumer serviceConsumer() {
		MyServiceConsumer serviceConsumer = new MyServiceConsumer();
		serviceConsumer.setMessageService(messageService());
		serviceConsumer.setTimeService(timeService("yyyy-MM-dd hh:mm:ss"));
		return serviceConsumer;
	}	
	@Bean
	public MessageService messageService() {
		return new MyMessageService();
	}	
	@Bean
	public TimeService timeService(String format) {
		return new MyTimeService(format);
	}

}
