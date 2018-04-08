package org.yifeng.spring.boot.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	@Pointcut("execution(* org.yifeng.spring.boot.aop.MyController.*(..))")
	public void pointcut() {}
	
	@Before("pointcut()")
	public void before() {
		System.out.println("Start");
	}
	
	@Around("pointcut()")
	public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		proceedingJoinPoint.proceed();
		System.out.println("Runtime: " + (System.currentTimeMillis() - startTime));
	}
	
	@After("pointcut()")
	public void after() {
		System.out.println("End");
	}
}
