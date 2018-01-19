package com.schoolpal.db.model;

import com.google.gson.Gson;
import com.schoolpal.consts.Const;
import com.schoolpal.consts.LogLevel;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

public class TLogWithBLOBs extends TLog implements Serializable {
    private String args;

    private String returnVal;

    private static final long serialVersionUID = 1L;

    private static Gson gson = new Gson();

    public static TLogWithBLOBs Produce(JoinPoint joinPoint, Object returnVal){
        TLogWithBLOBs logWithBLOBs = new TLogWithBLOBs();

        logWithBLOBs.setInvocation(joinPoint.getSignature().getDeclaringTypeName() + "." +
                joinPoint.getSignature().getName());
        logWithBLOBs.setArgs(gson.toJson(joinPoint.getArgs()));
        logWithBLOBs.setReturn(gson.toJson(returnVal));

        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        logWithBLOBs.setIp(req.getRemoteAddr());

        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser != null && currentUser.getPrincipal() != null) {
            Session session = currentUser.getSession(true);
            TUser user = gson.fromJson((String) session.getAttribute(Const.SESSION_KEY_CURRENT_USER), TUser.class);
            logWithBLOBs.setUserId(user.getcId());
            logWithBLOBs.setUserName(user.getcLoginName());
        }

        return logWithBLOBs;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args == null ? null : args.trim();
    }

    public String getReturn() {
        return returnVal;
    }

    public void setReturn(String returnVal) {
        this.returnVal = returnVal == null ? null : returnVal.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TLogWithBLOBs other = (TLogWithBLOBs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDatetime() == null ? other.getDatetime() == null : this.getDatetime().equals(other.getDatetime()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getMessage() == null ? other.getMessage() == null : this.getMessage().equals(other.getMessage()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getInvocation() == null ? other.getInvocation() == null : this.getInvocation().equals(other.getInvocation()))
            && (this.getArgs() == null ? other.getArgs() == null : this.getArgs().equals(other.getArgs()))
            && (this.getReturn() == null ? other.getReturn() == null : this.getReturn().equals(other.getReturn()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDatetime() == null) ? 0 : getDatetime().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getMessage() == null) ? 0 : getMessage().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getInvocation() == null) ? 0 : getInvocation().hashCode());
        result = prime * result + ((getArgs() == null) ? 0 : getArgs().hashCode());
        result = prime * result + ((getReturn() == null) ? 0 : getReturn().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", args=").append(args);
        sb.append(", return=").append(returnVal);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}