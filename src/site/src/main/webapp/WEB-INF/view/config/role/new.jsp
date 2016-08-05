<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../../_head.jsp">
        <jsp:param name="subTitle" value="角色管理" />
    </jsp:include>
    <link href="<c:url value='/css/config/role/form.css'/>" rel="stylesheet" type="text/css" />
</head>
<body>
    <header>
        <div class="container-fluid">
            <div class="row">
                <ol class="breadcrumb col-xs-6">
                    <li><strong>角色管理</strong></li>
                    <li class="active"><strong>新建角色</strong></li>
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
                <label for="parent">所属组织 : </label>
                <input id="parent" type="text" value="${page.orgHierarchy}" disabled />
                <input id="orgId" type="hidden" value="${page.id}" />
            </li>
            <li>
                <label>角色职能 : </label>
                <ul id="funcs">
                    <li><input type="checkbox" value="1" /> 市场</li>
                    <li><input type="checkbox" value="2" /> 销售</li>
                    <li><input type="checkbox" value="3" /> 客服</li>
                    <li><input type="checkbox" value="4" /> 财务</li>
                    <li><input type="checkbox" value="5" /> 教务</li>
                    <li><input type="checkbox" value="6" /> 教学</li>
                    <li><input type="checkbox" value="7" /> 系统</li>
                </ul>
            </li>
            <li>
                <label>角色职级 : </label>
                <ul id="roles">
                    <li><input type="radio" name="pos" value="1" /> 经理</li>
                    <li><input type="radio" name="pos" value="2" /> 主管</li>
                    <li><input type="radio" name="pos" value="3" /> 专员</li>
                    <li><input type="radio" name="pos" value="4" /> 系统管理员</li>
                </ul>
            </li>
            <li>
                <label for="name">角色名称 : </label>
                <input id="name" type="text" />
            </li>
            <li>
                <label for="desc">角色描述 : </label>
                <input id="desc" type="text" />
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

	<%@ include file="../../_bottom.jsp"%>
    <script type="text/javascript" src="<c:url value='/js/config/role/form.js'/>"></script>
</body>
</html>