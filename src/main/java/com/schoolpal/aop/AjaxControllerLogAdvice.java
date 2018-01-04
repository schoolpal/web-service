package com.schoolpal.aop;

import com.schoolpal.web.ajax.model.AjaxResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AjaxControllerLogAdvice {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public void before(JoinPoint joinPoint){
        logger.debug("###AjaxControllerLogAdvice - before()");
    }

    public void after(JoinPoint joinPoint){
        logger.debug("###AjaxControllerLogAdvice - after()");
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.debug("###AjaxControllerLogAdvice - around() - before");

        Object retVal = proceedingJoinPoint.proceed();

        logger.debug("###AjaxControllerLogAdvice - around() - after");
        return retVal;
    }

    public void afterReturning(JoinPoint joinPoint, Object retVal){
        logger.debug("###AjaxControllerLogAdvice - afterReturning()");


        logger.info();
    }

    public void afterThrowing(JoinPoint joinPoint, Throwable e){
        logger.debug("###AjaxControllerLogAdvice - afterThrowing()");
    }
}
