package com.springexample.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // app-context.xml 파일과 같은 설정을 처리하는 클래스로 지정
public class BeanConfig {
	
	@Bean //(name = "serviceConsumer") app-context.xml에서는 <bean id="serviceConsumer" ...
	public ServiceConsumer serviceConsumer() {
		return new MyServiceConsumer();
	}

}
