<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../_head.jsp">
        <jsp:param name="subTitle" value="登录" />
    </jsp:include>
    <link href="<c:url value='/css/home/index.css'/>" rel="stylesheet" type="text/css" />
</head>
<body>
    <form class="container" action="<c:url value='/main/'/>">
        <div class="col-md-4 col-md-offset-4 text-center">
            <h1>校 客</h1>
            <div class="form-group input-group input-group-lg">
                <span class="input-group-addon">
                    <span class="glyphicon glyphicon-user"></span>
                </span>
                <input type="text" class="form-control" id="name" placeholder="账号/邮箱/手机号码" />
            </div>
			<div class="form-group input-group input-group-lg">
			    <span class="input-group-addon">
			        <span class="glyphicon glyphicon-lock"></span>
			    </span>
			    <input type="password" class="form-control" id="pwd" placeholder="密码" />
			</div>
            <button id="btnLogin" class="btn btn-default"><i class="glyphicon glyphicon-log-in"></i>&nbsp;&nbsp;登&nbsp;录</button>
        </div>
    </form>
    
    <%@ include file="../_bottom.jsp" %>
    <script type="text/javascript" src="<c:url value='/js/md5.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/home/index.js'/>"></script>
</body>
</html>