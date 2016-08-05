<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../../_head.jsp">
        <jsp:param name="subTitle" value="用户管理" />
    </jsp:include>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/config/user/index.css'/>" />
</head>
<body>
    <header>
        <div class="container-fluid">
            <div class="row">
                <ol class="breadcrumb col-xs-6">
                    <li class="active"><strong>用户管理</strong></li>
                </ol>
                <div class="col-xs-6">
                    <div class="btn-toolbar pull-right" role="toolbar">
                        <c:forEach var='button' items='${page.buttons}'>
                            <button class="btn btn-default" id="${button.id}" data-type="${button.type}" data-action="<c:url value='${button.action}'/>">
                                <span class="${button.icon}"></span>&nbsp;&nbsp;${button.text}
                            </button>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </header>
    
    <section class="container-fluid">
        <div class="row">
            <div class="col-xs-3">
                <c:forEach var='org' items='${page.orgRows}'>
                    <div <c:if test='${org.parentId != org.id}'>data-group="${org.parentId}"</c:if>
                         <c:if test='${org.father}'>class="father"</c:if>>
                        <c:forEach begin='0' end='${org.level}'>
			                &nbsp;&nbsp;&nbsp;&nbsp;
			            </c:forEach> 
						<c:if test='${org.father}'>
							<span class="glyphicon glyphicon-minus-sign"></span>
                        </c:if>
                        <span id="${org.id}" class="name">${org.cnFullName}</span>
                    </div>
                </c:forEach>
            </div>
            <div class="col-xs-9">
                <div id="title"></div>
                <div id="users"></div>
			</div>
        </div>
    </section>

    <%@ include file="../../_bottom.jsp"%>
    <script type="text/javascript" src="<c:url value='/js/config/user/index.js'/>"></script>
</body>
</html>