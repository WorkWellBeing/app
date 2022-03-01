package com.example.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;


import lombok.extern.slf4j.Slf4j;

//ToDo#1
//ToDo#2
@Slf4j
public class PerformanceAspect {
	
	@After("execution(* com.example.service.*.*(..))")
    public void profile(ProceedingJoinPoint pjp) throws Throwable {
            long start = System.currentTimeMillis();
            pjp.proceed();
            long elapsedTime = System.currentTimeMillis() - start;
            log.info("Method execution time: " + elapsedTime + " milliseconds.");
    }
}
