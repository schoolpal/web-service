<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../../_head.jsp">
        <jsp:param name="subTitle" value="角色管理" />
    </jsp:include>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/config/role/index.css'/>" />
</head>
<body>
    <header>
        <div class="container-fluid">
            <div class="row">
                <ol class="breadcrumb col-xs-6">
                    <li class="active"><strong>角色管理</strong></li>
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
                        <span id="${org.id}" class="name">${org.name}</span>
                    </div>
                </c:forEach>
            </div>
            <div class="col-xs-9">
                <div id="title"></div>
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th><span class="glyphicon glyphicon-link"></span></th>
							<th>角色职能</th>
							<th>角色职级</th>
							<th>角色名称</th>
							<th>角色描述</th>
						</tr>
					</thead>
					<tbody id="roles">
					</tbody>
				</table>
			</div>
        </div>
    </section>
    
    <div id="confirm" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" style="display: none;">
        <div class="modal-dialog modal-sm">
            <div class="modal-content text-warning">
                <div class="modal-header">
                    <h4 class="modal-title" id="mySmallModalLabel">删除确认</h4>
                </div>
                <div class="modal-body"></div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-danger" id="btnConfirm">确认删除</button>
                </div>
            </div>
        </div>
    </div>

    <%@ include file="../../_bottom.jsp"%>
    <script type="text/javascript" src="<c:url value='/js/config/role/index.js'/>"></script>
</body>
</html>