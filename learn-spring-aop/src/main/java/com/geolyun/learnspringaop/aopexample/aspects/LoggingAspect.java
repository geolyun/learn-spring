package com.geolyun.learnspringaop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //Pointcut - When?
    // execution(* PACKAGE.*.*(..))
    @Before("execution(* com.geolyun.learnspringaop.aopexample.*.*.*(..))")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
        logger.info("Before Aspect - {} is called with arguments: {}"
                , joinPoint, joinPoint.getArgs()); //WHAT
    }

    @After("execution(* com.geolyun.learnspringaop.aopexample.*.*.*(..))")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        logger.info("After Aspect - {} has executed", joinPoint); //WHAT
    }

    @AfterThrowing(
            pointcut = "execution(* com.geolyun.learnspringaop.aopexample.*.*.*(..))",
            throwing = "exception"
    )
    public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
        logger.info("AfterThrowing Aspect - {} has thrown an exception {}", joinPoint, exception); //WHAT
    }

    @AfterReturning(
            pointcut = "execution(* com.geolyun.learnspringaop.aopexample.*.*.*(..))",
            returning = "resultValue"
    )
    public void logMethodCallAfterSuccessfulException(JoinPoint joinPoint, Object resultValue) {
        logger.info("AfterReturning Aspect - {} has returned {}", joinPoint, resultValue ); //WHAT
    }
}

// @After : 어떤 상황이든 메소드 실행 후에 할 작업을 지정할 때 사용
// @AfterReturning : 매소드가 성공적으로 실행됐다면 하려는 작업을 지정할 때 사용
// @AfterThrowing : 메소드가 익셉션을 던졌을 때 뭔가를 해야 할 때 사용
