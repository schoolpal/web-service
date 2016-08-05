<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var='role' items='${roleRows}'>
	<tr data-role='${role.id}'>
		<td>
		    <input type="radio" name="roleId" id="${role.id}" />
		</td>
		<td>
		    <c:forEach var='func' items='${role.funcNames}' varStatus='status'>
                ${func}<c:if test='${!status.last}'>、</c:if>
            </c:forEach>
        </td>
		<td>${role.rankName}</td>
        <td>${role.name}</td>
        <td>${role.desc}</td>
	</tr>
</c:forEach>