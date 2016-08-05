<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../../_head.jsp">
        <jsp:param name="subTitle" value="组织管理" />
    </jsp:include>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/config/org/index.css'/>" />
</head>
<body>
    <header>
	    <div class="container-fluid">
	        <div class="row">
	            <ol class="breadcrumb col-xs-6">
	                <li class="active"><strong>组织管理</strong></li>
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
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th><span class="glyphicon glyphicon-link"></span></th>
                    <th>组织名称</th>
                    <th>所在地区</th>
                    <th>详细地址</th>
                    <th>负责人</th>
                    <th>联系电话</th>
                </tr>
            </thead>
            <tbody id="orgs">
            </tbody>
		</table>
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
	<script type="text/javascript" src="<c:url value='/js/config/org/index.js'/>"></script>
</body>
</html>