<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../_head.jsp">
		<jsp:param name="subTitle" value="控制台" />
	</jsp:include>
    <link href="<c:url value='/css/main/index.css'/>" rel="stylesheet" type="text/css" />
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<ul class="nav navbar-nav navbar-left">
				<li>
				    <img alt="${page.orgCnFullName}" src="<c:url value='/img/logo/${page.orgCode}.png'/>" width="48" height="48" />
				</li>
				<li>
				    <strong>${page.orgCnFullName}</strong>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li>
				    <a href="<c:url value='/main/logout.html'/>">
				        <i class="glyphicon glyphicon-log-out"></i> 注销
				    </a>
				</li>
			</ul>
		</div>
	</nav>

	<div class="container-fluid fill">
		<div class="row">
			<div class="col-lg-2 col-md-2 col-sm-3">
			    <ul class="nav nav-pills nav-stacked">
			        <c:forEach var='menu' items='${page.menus}'>
	                    <li>
	                        <a href="#" data-target="#menu_group_${menu.id}" data-toggle="collapse">
	                            <span class="${menu.icon}"></span>&nbsp;${menu.text}&nbsp;<span class="caret"></span>
	                        </a>
	                        <ul class="nav nav-stacked collapse" id="menu_group_${menu.id}">
	                            <c:forEach var='item' items='${menu.items}'>
	                                <li>
	                                    <a href="<c:url value='${item.action}?id=${item.id}' />">
	                                        &nbsp;&nbsp;<span class="${item.icon}"></span>&nbsp;&nbsp;${item.text}
	                                    </a>
	                                </li>
	                            </c:forEach>
	                        </ul>
	                    </li>
                    </c:forEach>
                </ul>
			</div>
			
			<div class="col-lg-2 col-md-2 col-sm-3">
				<!-- Placeholder - keep empty -->
			</div>
			
			<div class="embed-responsive embed-responsive-16by9">
				<iframe class="embed-responsive-item"></iframe>
			</div>
		</div>
	</div>
    
	<%@ include file="../_bottom.jsp"%>
	<script type="text/javascript" src="<c:url value='/js/main/index.js'/>"></script>
</body>
</html>