<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../../_head.jsp">
        <jsp:param name="subTitle" value="用户管理" />
    </jsp:include>
    <link href="<c:url value='/css/config/user/form.css'/>" rel="stylesheet" type="text/css" />
</head>
<body>
    <header>
        <div class="container-fluid">
            <div class="row">
                <ol class="breadcrumb col-xs-6">
                    <li><strong>用户管理</strong></li>
                    <li class="active"><strong>新建用户</strong></li>
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
    
    <table>
        <tr>
            <td>
		        <ul>
		            <li>
		                <label for="org">所属组织 : </label>
		                <input id="org" type="text" disabled value="${page.orgHierarchy}" />
		                <input id="orgId" type="hidden" value="${page.orgId}" />
		            </li>
		            <li>
		                <label for="username">* 用户名 : </label>
		                <input id="username" type="text" />
		            </li>
		            <li>
		                <label for="passwd">* 登陆密码 : </label>
		                <input id="passwd" type="text" />
		            </li>
		            <li>
		                <label for="nameCN">* 姓名 : </label>
		                <input id="nameCN" type="text" />
		            </li>
		            <li>
		                <label for="nameEN">英文名 : </label>
		                <input id="nameEN" type="text" />
		            </li>
		            <li>
		                <label for="phone">电话号码 : </label>
		                <input id="phone" type="text" />
		            </li>
		            <li>
		                <label for="email">电子邮箱 : </label>
		                <input id="email" type="text" />
		            </li>
		            <li>
		                <label for="im">IM(QQ...) : </label>
		                <input id="im" type="text" />
		            </li>
		        </ul>
		    </td>
		    <td id="roles">
		        <div>用户角色</div>
		        <c:forEach var='role' items='${page.roleRows}'>
		            <div title="<c:forEach var='func' items='${role.funcNames}' varStatus='status'>${func}<c:if test='${!status.last}'>、</c:if></c:forEach>">
		                <input 
		                    <c:choose>
		                        <c:when test='${role.rankId == 1 || role.rankId == 4}'>type="radio" name="role"</c:when>
                                <c:otherwise>type="checkbox"</c:otherwise>
		                    </c:choose>
		                    value="${role.id}" /><span>${role.name}</span>
		            </div>
		        </c:forEach>
		    </td>
        </tr>
    </table>
    
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
    <script type="text/javascript" src="<c:url value='/js/md5.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/config/user/form.js'/>"></script>
</body>
</html>