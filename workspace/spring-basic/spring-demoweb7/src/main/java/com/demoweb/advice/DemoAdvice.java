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
		
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object returnValue = null;
		
		System.out.printf("doAround 1 with %s.%s\n", className, methodName); 	// Before
		
		try {
			returnValue = joinPoint.proceed(); // 실제 메서드 호출
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.printf("doAround 2 with %s.%s\n", className, methodName);	// After
		
		return returnValue;
	}
	
	public void doAfterReturning() {
		System.out.println("doAfterReturning");
	}
	
	public void doAfterThrowing() {
		System.out.println("doAfterThrowing");
	}

}
