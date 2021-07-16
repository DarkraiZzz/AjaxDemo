<%--
  Created by IntelliJ IDEA.
  User: Nemo
  Date: 2021/7/16
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>serialize测试</title>
    <script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/2.0.3/jquery-2.0.3.min.js"></script>
    <script type="text/javascript">
        function getBtn() {
            $.ajax({
                url: "serialize",
                type: "post",
                data: $('#myForm').serialize(),  //使用表单序列化提交数据
                enctype: 'multipart/form-data',
                success: function (data) {
                    console.log(data);
                    alert(data);
                },
                error: function (err) {
                    alert(err);
                }
            });
        }
    </script>
</head>
<body>
<form id="myForm">
    <p>First name: <input type="text" name="fname"/></p>
    <p>Last name: <input type="text" name="lname"/></p>
    <input type="button" value="表单序列化" onclick="getBtn()" />
</form>
</body>
</html>
