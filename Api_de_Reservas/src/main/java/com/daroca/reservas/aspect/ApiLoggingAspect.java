package com.daroca.reservas.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class ApiLoggingAspect {



        private Logger myLogger= Logger.getLogger(getClass().getName());

        @Pointcut("execution(* com.daroca.reservas.rest.*.*(..))")
        public void forControllerPackage(){}

        @Pointcut("execution(* com.daroca.reservas.service.*.*(..))")
        public void forServicePackage(){}

        @Pointcut("execution(* com.daroca.reservas.dao.*.*(..))")
        public void forDAOPackage(){}
        @Pointcut("forDAOPackage()||forControllerPackage()||forServicePackage()")
        public void forAppFlow(){}

        @Before("forAppFlow()")
        public void before(JoinPoint joinPoint){
            // Display method name
            String theMethod= joinPoint.getSignature().toShortString();

            myLogger.info("====>Before execution: "+ theMethod);
            // Display arguments to the methods
            Object[] args= joinPoint.getArgs();
            int n=0;
            for (Object tempArgs:args){
                myLogger.info("========> argument"+n+" : "+ tempArgs);

            }

        }
        @AfterReturning(
                pointcut = "forAppFlow()",
                returning = "result")
        public void afterReturning(JoinPoint joinPoint,Object result){
            // Display method name
            String theMethod= joinPoint.getSignature().toShortString();

            myLogger.info("========> After returning: calling method: "+ theMethod);
            // Display data returned

            myLogger.info("========> data returned: "+ result);



        }

}
