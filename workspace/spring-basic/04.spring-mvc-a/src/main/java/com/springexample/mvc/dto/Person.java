package com.springexample.mvc.dto;

import lombok.Data;

@Data // 모든 필드에 대해 getter, setter 자동 생성
public class Person {

	private String name;
	private String phone;
	private String email;
	private int age;
	

}
