package com.demoweb.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class DemoAspect2 {
	
	@Pointcut("execution(* *..*Controller.*(..))")
	public void controllerPointcut() {}
	
	@Before("controllerPointcut()")
	public void doBefore(JoinPoint joinPoint) {
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		
		System.out.printf("doBefore is called after %s.%s\n", className, methodName);
	}

}
