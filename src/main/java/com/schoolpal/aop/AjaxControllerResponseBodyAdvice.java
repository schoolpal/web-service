package com.schoolpal.aop;

import com.schoolpal.web.ajax.model.AjaxResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AjaxControllerResponseBodyAdvice {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public void before(JoinPoint joinPoint){
        logger.debug("###AjaxControllerResponseBodyAdvice - before()");
    }

    public void after(JoinPoint joinPoint){
        logger.debug("###AjaxControllerResponseBodyAdvice - after()");
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.debug("###AjaxControllerResponseBodyAdvice - around() - before");

        Object retVal = proceedingJoinPoint.proceed();

        if (!(retVal instanceof AjaxResponse)) {
            AjaxResponse res = new AjaxResponse();
            res.setData(retVal);
            retVal = res;
        }

        logger.debug("###AjaxControllerResponseBodyAdvice - around() - after");
        return retVal;
    }

    public void afterReturning(JoinPoint joinPoint, Object retVal){
        logger.debug("###AjaxControllerResponseBodyAdvice - afterReturning()");
    }

    public void afterThrowing(JoinPoint joinPoint, Throwable e){
        logger.debug("###AjaxControllerResponseBodyAdvice - afterThrowing()");
    }
}
