<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table>
    <thead>
        <tr>
            <th><span class="glyphicon glyphicon-link"></span></th>
            <th>状态</th>
            <th>用户名</th>
            <th>姓名</th>
            <th>昵称</th>
            <th>电话号码</th>
            <th>电子邮件</th>
            <th>IM(QQ)</th>
            <th>用户角色</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var='user' items='${users}'>
	        <tr <c:if test='${!user.available}'>class="disable"</c:if>>
	            <td><input type="radio" id="${user.id}" name="userinput" /></td>
	            <td>${user.state}</td>
	            <td>${user.loginName}</td>
	            <td>${user.realName}</td>
	            <td>${user.nickName}</td>
	            <td>${user.mobile}</td>
	            <td>${user.email}</td>
	            <td>${user.im}</td>
	            <td>${user.roles}</td>
	        </tr>
        </c:forEach>
    </tbody>
</table>