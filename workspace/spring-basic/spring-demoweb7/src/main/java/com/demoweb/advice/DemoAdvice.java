package com.demoweb.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class DemoAdvice {
	
	public void doBefore() {
		System.out.println("doBefore");
	}
	
	public void doAfter() {
		System.out.println("doAfter");
	}
	
	public Object doAround(ProceedingJoinPoint joinPoint) {
		
		Object returnValue = null;
		
		System.out.println("doAround 1"); 	// Before
		
		try {
			returnValue = joinPoint.proceed(); // 실제 메서드 호출
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("doAround 2");	// After
		
		return returnValue;
	}
	
	public void doAfterReturning() {
		System.out.println("doAfterReturning");
	}
	
	public void doAfterThrowing() {
		System.out.println("doAfterThrowing");
	}

}
