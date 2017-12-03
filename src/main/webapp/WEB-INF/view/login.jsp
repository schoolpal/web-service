<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <title>Login</title>
    <meta charset="utf-8">
</head>
<body>
<form action="<c:url value='/login.do'/>" method="post">
    <input type="text" id="name" name="name" placeholder="账号/邮箱/手机号码"/>
    <input type="password" id="password" name="password" placeholder="密码"/>
    <input type="hidden" id="loginName" name="loginName"/>
    <input type="hidden" id="mixedPWD" name="mixedPWD"/>
    <button id="btnLogin">登录</button>
</form>

<script type="application/javascript" src="<c:url value='/lib/jquery/jquery.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/lib/md5.js'/>"></script>

<script type="application/javascript">
    $('#btnLogin').click(function(e) {
        $('#name').attr('disabled', 'disabled');
        $('#password').attr('disabled', 'disabled');
        $(this).attr('disabled', 'disabled');

        $.post("<c:url value='/ajax/user/salt.do'/>", null, function(salt) {
            $('#loginName').val($('#name').val())
            $('#mixedPWD').val(MD5(MD5(MD5($('#password').val()))+salt.data))
            $('#name').val('#')
            $('#password').val('#')
            $('form').submit();
        });
        e.preventDefault();
    });
</script>
</body>
</html>
