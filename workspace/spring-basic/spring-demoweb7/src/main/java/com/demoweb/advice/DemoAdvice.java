package com.demoweb.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class DemoAdvice {
	
	public void doBefore() {
		System.out.println("doBefore");
	}
	
	public void doAfter(JoinPoint joinPoint) { // JoinPoint : 현재 실행중인 메서드 정보
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		
		System.out.printf("doAfter is called after %s.%s\n", className, methodName);
	}
	
	public Object doAround(ProceedingJoinPoint joinPoint) {
		
		//String className = joinPoint.getTarget().getClass().getName();
		//String methodName = joinPoint.getSignature().getName();
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
