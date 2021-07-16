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
    <script type="text/javascript">
        var httpRequest = null;
        function checkName(oval){
            if(oval==""){
                return;
            }
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

            httpRequest.open("post", "UserServlet?method=register", true); //传递方式,传递的地址,是否开启异步

            httpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded"); //头文件 键值对

            httpRequest.onreadystatechange = callBack;//是下面回调函数的名字,不要加括号

            httpRequest.send("uname=" + oval); //将要传递的参数传递到后端
        }
        function callBack(){
            if (httpRequest.readyState==4 && httpRequest.status==200){
                document.getElementById("namespan").innerHTML=httpRequest.responseText;
            }
        }

    </script>
</head>
<body>
<form action="RegisterServlet&?method=register" method="post" enctype="application/x-www-form-urlencoded">
    <p>姓名：<input type="text" onblur="checkName(this.value)"/>
        <span id="namespan">请输入用户名</span>
    </p>
    <p>密码：<input type="password"/></p>
    <p><input type="submit" value="提交"></p>
</form>
</body>
</html>
