<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="title"></div>
<table>
	<thead>
		<tr>
			<th>系统菜单</th>
			<th>选取</th>
			<th>功能权限</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var='func' items='${funcRows}'>
		    <c:if test='${func.type == 1 || func.type == 2}'>
			    <tr <c:if test='${func.type == 1}'>class="top"</c:if>>
			        <td>
			            <c:forEach var='i' begin='1' end='${func.level}'>
				            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				        </c:forEach>
			            ${func.name}
			        </td>
			        <td><input type="checkbox" id="${func.id}" <c:if test='${!func.excluded}'>checked="checked"</c:if> /></td>
			        <td>
			            <c:if test='${func.type == 2}'>
			                <c:forEach var='fc' items='${funcRows}'>
			                    <c:if test='${fc.parentId == func.id}'>
			                        <input type="checkbox" id="${fc.id}" <c:if test='${!fc.excluded}'>checked="checked"</c:if> />
			                        <span>${fc.name}</span>
			                    </c:if>
			                </c:forEach>
			            </c:if>
			        </td>
			    </tr>
		    </c:if>
		</c:forEach>
	</tbody>
</table>

<script type="text/javascript">
    var excludedIds = [
        <c:forEach var='func' items='${funcRows}'>
            <c:if test='${func.excluded}'>'${func.id}',</c:if>
        </c:forEach>
    ];
</script>

<script type="text/javascript" src="<c:url value='/js/config/auth/roleSelection.js'/>"></script>