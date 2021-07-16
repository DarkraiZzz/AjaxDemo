<%--
  Created by IntelliJ IDEA.
  User: Nemo
  Date: 2021/7/15
  Time: 1:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <style type="text/css">
        table{
            border: aqua;
        }
        td{
            background: dodgerblue;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <td>编号</td>
        <td>姓名</td>
    </tr>
    <c:forEach items="${empList}" var="e">
        <tr>
            <td>${e.eid}</td>
            <td>${e.ename}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
