<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../../_head.jsp">
        <jsp:param name="subTitle" value="组织管理" />
    </jsp:include>
    <link href="<c:url value='/css/config/org/form.css'/>" rel="stylesheet" type="text/css" />
</head>
<body>
    <header>
        <div class="container-fluid">
            <div class="row">
                <ol class="breadcrumb col-xs-6">
                    <li><strong>组织管理</strong></li>
                    <li class="active"><strong>新建组织</strong></li>
                </ol>
                <div class="col-xs-6">
                    <div class="btn-toolbar pull-right" role="toolbar">
                        <button class="btn btn-default" data-type="CommandButton" id="new">
                            <span class="glyphicon glyphicon-save"></span>&nbsp;&nbsp;保存
                        </button>
                        <button class="btn btn-default" data-type="CancelButton">
                            <span class="glyphicon glyphicon-share-alt"></span>&nbsp;&nbsp;返回
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </header>
    
    <section>
        <ul>
            <li>
                <label for="name">组织名称 : </label>
                <input id="name" type="text" value="${form.Name}" />
            </li>
            <li>
                <label for="code">组织代码 : </label>
                <input id="code" type="text" value="${form.orgCode}" />
            </li>
            <li>
                <label for="parent">父级组织 : </label>
                <input id="parent" type="text" disabled />
                <span class="glyphicon glyphicon-list-alt"></span>
            </li>
            <li id="area">
                <label for="state">所在地区 : </label>
                <select id="state"></select>
                <select id="city"></select>
                <select id="county"></select>
            </li>
            <li>
                <label for="address">详细地址 : </label>
                <input id="address" type="text" value="${form.address}" />
            </li>
            <li>
                <label for="owner">负责人 : </label>
                <input id="owner" type="text" value="${form.owner}" />
            </li>
            <li>
                <label for="phone">联系电话 : </label>
                <input id="phone" type="text" value="${form.phone}" />
            </li>
        </ul>
    </section>
    
    <div id="confirm" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" style="display: none;">
	    <div class="modal-dialog modal-sm">
	        <div class="modal-content text-success">
	            <div class="modal-header">
	                <h4 class="modal-title" id="mySmallModalLabel">提示信息</h4>
	            </div>
	            <div class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success" data-dismiss="modal">继续新增</button>
					<button type="button" class="btn btn-danger" data-type="CancelButton">完成返回</button>
				</div>
			</div>
	    </div>
	</div>

	<div id="orgList" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
                <section class="orgsection"></section>
			</div>
		</div>
	</div>

	<%@ include file="../../_bottom.jsp"%>
    <script type="text/javascript" src="<c:url value='/js/config/org/china.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/config/org/new.js'/>"></script>
</body>
</html>