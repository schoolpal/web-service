package com.schoolpal.aop;

import com.schoolpal.consts.LogLevel;
import com.schoolpal.db.model.TLogWithBLOBs;
import com.schoolpal.model.ServiceLogRecord;
import com.schoolpal.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceLogAdvice {

    private Logger logger = LoggerFactory.getLogger(getClass());

//    @Autowired
//    private ServiceLogRecord logRecord;
    @Autowired
    private LogService logService;

    public void before(JoinPoint joinPoint){
        logger.debug("###ServiceLogAdvice - before()");
    }

    public void after(JoinPoint joinPoint){
        logger.debug("###ServiceLogAdvice - after()");
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.debug("###ServiceLogAdvice - around() - before");

        Object retVal = proceedingJoinPoint.proceed();

        logger.debug("###ServiceLogAdvice - around() - after");
        return retVal;
    }

    public void afterReturning(JoinPoint joinPoint, Object retVal){
        logger.debug("###ServiceLogAdvice - afterReturning()");

//        logRecord.loadContextInfo(joinPoint);
//        logRecord.setReturnVal(retVal);

//        logService.log(LogLevel.INFO, "", logRecord);
        logService.log(LogLevel.INFO, "", TLogWithBLOBs.Produce(joinPoint, retVal));
    }

    public void afterThrowing(JoinPoint joinPoint, Throwable e){
        logger.debug("###ServiceLogAdvice - afterThrowing()");

//        logRecord.loadContextInfo(joinPoint);
//        logRecord.setReturnVal(e.getMessage());
//
//        logService.log(LogLevel.ERROR, "", logRecord);
        logService.log(LogLevel.ERROR, "", TLogWithBLOBs.Produce(joinPoint, e));
    }
}
