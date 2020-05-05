package com.spring.boot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.util.StopWatch;

import com.spring.boot.annotation.RunTime;

public class RunTimeAspect {
	@Around("@annotation(runTime)")
	public Object execute(ProceedingJoinPoint point, RunTime runTime) throws Throwable {
		
		if(!runTime.active()) {
			return point.proceed();
		}
		
		String className = point.getSignature().getDeclaringType().getSimpleName();
		String methodName = point.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		
		stopWatch.start();
		
		Object result = point.proceed();
		
		stopWatch.stop();
		
		
		System.out.println(className + "#" + methodName + " runned in  " + stopWatch.getTotalTimeMillis() + " ms");
		
		
		return result;
	}

}
