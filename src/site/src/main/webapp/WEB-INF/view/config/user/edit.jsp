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
                    <li class="active"><strong>编辑用户</strong></li>
                </ol>
                <div class="col-xs-6">
                    <div class="btn-toolbar pull-right" role="toolbar">
                        <button class="btn btn-default" data-type="CommandButton" id="edit">
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
                        <input id="userId" type="hidden" value="${page.userId}" />
		            </li>
		            <li>
		                <label for="loginName">* 用户名 : </label>
		                <input id="loginName" type="text" value="${page.form.loginName}" />
		            </li>
		            <li>
		                <label for="loginPass">* 登陆密码 : </label>
		                <input id="loginPass" type="text" placeholder="******" />
		            </li>
		            <li>
		                <label for="realName">* 姓名 : </label>
		                <input id="realName" type="text" value="${page.form.realName}" />
		            </li>
		            <li>
		                <label for="nickName">* 昵称 : </label>
		                <input id="nickName" type="text" value="${page.form.nickName}" />
		            </li>
					<li>
		                <label for="phone">电话号码 : </label>
		                <input id="phone" type="text" value="${page.form.phone}" />
		            </li>
		            <li>
		                <label for="email">电子邮箱 : </label>
		                <input id="email" type="text" value="${page.form.email}" />
		            </li>
		            <li>
		                <label for="im">IM(QQ...) : </label>
		                <input id="im" type="text" value="${page.form.im}" />
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
                    <button type="button" class="btn btn-success" data-dismiss="modal">继续修改</button>
                    <button type="button" class="btn btn-danger" data-type="CancelButton">完成返回</button>
                </div>
            </div>
        </div>
    </div>

	<%@ include file="../../_bottom.jsp"%>
    <script type="text/javascript" src="<c:url value='/js/md5.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/config/user/form.js'/>"></script>
    <script type="text/javascript">
        var roles = '${page.form.roles}';
        $(roles.split(',')).each(function(i,o) {
        	$('#roles input[value=' + o + ']').attr('checked', 'checked');
        });
    </script>
</body>
</html>