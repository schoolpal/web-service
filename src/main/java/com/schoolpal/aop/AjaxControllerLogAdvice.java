package com.schoolpal.aop;

import com.google.gson.Gson;
import com.schoolpal.model.AjaxControllerLogRecord;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AjaxControllerLogAdvice {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private Gson gson = new Gson();

    @Autowired
    private AjaxControllerLogRecord logRecord;

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

        logRecord.loadContextInfo(joinPoint);
        logRecord.setResponse(retVal);

        logger.info(gson.toJson(logRecord));
    }

    public void afterThrowing(JoinPoint joinPoint, Throwable e){
        logger.debug("###AjaxControllerLogAdvice - afterThrowing()");

        logRecord.loadContextInfo(joinPoint);
        logRecord.setResponse(null);

        logger.error(e.getMessage());
        logger.info(gson.toJson(logRecord));
    }
}
