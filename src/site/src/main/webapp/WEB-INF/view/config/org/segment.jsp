<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var='org' items='${orgRows}'>
	<tr <c:if test='${org.parentId != org.id}'>data-group="${org.parentId}"</c:if>
		<c:if test='${org.father}'>class="father"</c:if>>
		<td>
		    <input type="radio" name="orgIds" id="${org.id}" />
		</td>
		<td>
		    <c:forEach var='i' begin='0' end='${org.level}'>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </c:forEach> 
            <c:if test='${org.father}'>
				<span id="${org.id}" class="glyphicon glyphicon-minus-sign"></span>&nbsp;
            </c:if>
            <span data-org="${org.id}">${org.cnFullName}</span>
        </td>
		<td>${org.area}</td>
		<td>${org.address}</td>
		<td>${org.owner}</td>
		<td>${org.phone}</td>
	</tr>
</c:forEach>