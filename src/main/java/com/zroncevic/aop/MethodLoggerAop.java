	package com.zroncevic.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

public class MethodLoggerAop {

	@Aspect
	@Component
	@ConditionalOnProperty(name = "method.logger.enabled", matchIfMissing = false)
	public class MethodLogger {

	    @Before("execution(* com.zroncevic..*(..))")
	    public void before(JoinPoint point) throws Throwable {
	        
	    	System.out.println("AOP IN :" +
	                     MethodSignature.class.cast(point.getSignature()).getMethod().getName()
	                     + point.getArgs());
	        return;
	    }

	    @AfterReturning(pointcut = "execution(* com.zroncevic..*(..))", returning = "result")
	    public void after(JoinPoint point, Object result) throws Throwable {
	        long start = System.currentTimeMillis();
	        System.out.println(MethodSignature.class.cast(point.getSignature()).getMethod().getName()
	                     + point.getArgs() + 
	                     result.toString() + " in " + 
	                     (System.currentTimeMillis() - start) + " milis");
	        return;
		}
	}
}