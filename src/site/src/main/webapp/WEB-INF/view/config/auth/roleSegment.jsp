<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var='role' items='${roleRows}'>
    <div id="${role.id}" 
        title="<c:forEach var='func' items='${role.funcNames}' varStatus='status'>${func}<c:if test='${!status.last}'>、</c:if></c:forEach>">
        <span>${role.name}</span>
    </div>
</c:forEach>

<script type="text/javascript" src="<c:url value='/js/config/auth/roleSegment.js'/>"></script>