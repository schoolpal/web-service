package com.schoolpal.model;

import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;

import javax.servlet.http.HttpServletRequest;

public class AjaxControllerInfo {
    private String clazz;
    private String method;
    private String param;
    private String user;
    private String ip;

    public void loadRequestInfo(HttpServletRequest req){
        this.ip = req.getRemoteAddr();
    }

    public void loadUserInfo(Subject subject){

    }

    public void loadInvocationInfo(JoinPoint joinPoint){
        this.clazz = joinPoint.getTarget().getClass().getName();
        this.method = joinPoint.getSignature().getName();

    }

}
