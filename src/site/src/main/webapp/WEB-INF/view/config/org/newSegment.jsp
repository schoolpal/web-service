<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var='org' items='${orgRows}'>
    <div>
        <c:forEach var='i' begin='0' end='${org.level}'>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </c:forEach>
        <c:if test='${org.father}'>
            <span id="${org.id}" class="glyphicon glyphicon-minus-sign"></span>&nbsp;
        </c:if>
        <a href="#" id="${org.id}">${org.cnFullName} (${org.code})</a>
    </div>
</c:forEach>