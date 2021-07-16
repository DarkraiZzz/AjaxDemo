<%--
  Created by IntelliJ IDEA.
  User: Nemo
  Date: 2021/7/15
  Time: 0:46
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
    <script type="text/javascript">
        var httpRequest = null;
        function getemp(obj) {
            try {
                httpRequest = new ActiveXObject("Msxml2.XMLHTTP");
            } catch (e) {
                try {
                    httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
                } catch (e) {
                    try {
                        httpRequest = new XMLHttpRequest();
                        if (httpRequest.overrideMimeType) {
                            httpRequest.overrideMimeType("text/xml");
                        }
                    } catch (e) {
                    }
                }
            }
            if (httpRequest == null) {
                alert("浏览器不支持XMLHttpRequest");
                return;
            }
            httpRequest.open("post", "EmpDeptServlet", true); //传递方式,传递的地址,是否开启异步
            httpRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); //头文件 键值对
            httpRequest.onreadystatechange = getempback;//是下面回调函数的名字,不要加括号
            httpRequest.send("from=emp2&did="+obj.value); //将要传递的参数传递到后端
        }

        function getempback() {
            if (httpRequest.readyState == 4 && httpRequest.status == 200) {
                var object = httpRequest.responseText;
                document.getElementById("mydiv").innerHTML =object;
            }
        }

    </script>
</head>
<body>

    部门：<select id="dep" onchange="getemp(this)">
        <c:forEach var="d" items="${deptList}">
            <option value="${d.did}">${d.dname}</option>
        </c:forEach>
        </select>

        <div id="mydiv"></div>
</body>
</html>
