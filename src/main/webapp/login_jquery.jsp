<%--
  Created by IntelliJ IDEA.
  User: Nemo
  Date: 2021/7/13
  Time: 0:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>AjaxDemo</title>
    <script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/2.0.3/jquery-2.0.3.min.js"></script>
    <script type="text/javascript">
        function login() {
            $('#mydiv').html('');
            var name = $('#name').val();
            var password = $('#password').val();
            if (name == "" || password == "") {
                $('#mydiv').html("用户名或密码为空");
                return;
            }
            $('#myspan').html('<img src="image/ajax-loader.gif">正在加载中...');
            $.post("UserServlet?method=login", {name: name, password: password},
                function (data) {
                    $('#myspan').html('');
                    if (data==1){
                      $('#mydiv').html("登陆失败");
                    }else {
                        $('#mydiv').html("登陆成功");
                    }
                });
        }
    </script>
</head>
<body>
<p>姓名：<input type="text" id="name"/></p>
<p>密码：<input type="password" id="password"/></p>
<p><input type="button" value="登录" onclick="login()"/></p>
<span id="myspan"></span>
<div id="mydiv">显示结果</div>
</body>
</html>
