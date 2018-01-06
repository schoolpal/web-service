package com.schoolpal.model;

import com.google.gson.Gson;
import com.schoolpal.consts.Const;
import com.schoolpal.db.model.TUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
public class AjaxControllerLogRecord {

    private String clazzName;
    private String methodName;
    private Object[] args;

    private String ip;
    private String httpMethod;
    private String uri;

    private Object response;

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String userId;
    private String userName;

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void loadContextInfo(JoinPoint joinPoint){
        this.loadInvocationInfo(joinPoint);
        this.loadRequestInfo();
        this.loadLoginUserInfo();
    }

    public void loadRequestInfo(){
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        this.setIp(req.getRemoteAddr());
        this.setHttpMethod(req.getMethod());
        this.setUri(req.getRequestURI());
    }

    public void loadInvocationInfo(JoinPoint joinPoint){
        this.setClazzName(joinPoint.getSignature().getDeclaringTypeName());
        this.setMethodName(joinPoint.getSignature().getName());
        this.setArgs(joinPoint.getArgs());
    }

    public void loadLoginUserInfo(){
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser == null || currentUser.getPrincipal() == null) {
            return;
        }

        Session session = currentUser.getSession(true);
        Gson gson = new Gson();
        TUser user = gson.fromJson((String) session.getAttribute(Const.SESSION_KEY_CURRENT_USER), TUser.class);
        this.setUserId(user.getcId());
        this.setUserName(user.getcLoginName());
    }
}
