<%--
  Created by IntelliJ IDEA.
  User: Nemo
  Date: 2021/7/15
  Time: 23:33
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
    <title>Title</title>
    <script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/2.0.3/jquery-2.0.3.min.js"></script>
    <script type="text/javascript">
        function getData(object) {
            $.get("MultiParaServlet", {name: object, from: "case1"}, function (data) {
                var strs = data.split("!");
                $('#s1').html(strs[0]);
                $('#s2').html(strs[1]);
            });
        }

        function getData2(object) {
            $.get("MultiParaServlet", {name: object, from: "case2"}, function (data) {
                data = JSON.parse(data);
                $('#s3').html(data.name);
                $('#s4').html(data.password);
            });
        }

        function getData3(object) {
            $.getJSON("MultiParaServlet", {name: object, from: "case3"}, function (data) {
                // data=JSON.parse(data);
                $('#s5').html(data.name);
                $('#s6').html(data.password);
            });
        }

        function getBtn() {
            $.ajax({
                url: "MultiParaServlet",
                type: "get",
                data: {name: "aa", from: "case4"},
                success: function (data) {
                    alert(typeof (data));
                    alert(data);
                },
                error: function (XMLHttpRequest, textStatus) {
                    alert(XMLHttpRequest.status + "----" + textStatus);
                }
            })
        }

        function postBtn() {
            $.ajax({
                url: "MultiParaServlet",
                type: "post",
                data: {name: "aa", from: "case4"},
                success: function (data) {
                    alert(typeof (data));
                    alert(data);
                },
                error: function (XMLHttpRequest, textStatus) {
                    alert(XMLHttpRequest.status + "----" + textStatus);
                }
            })
        }

        function postBtn2() {
            $.ajax({
                url: "MultiParaServlet",
                type: "post",
                data: {name: "aa", from: "case4"},
                dataType: "json",
                success: function (data) {
                    alert(typeof (data));
                    alert(data);
                    alert(data.name+"---"+data.password);
                },
                error: function (XMLHttpRequest, textStatus) {
                    alert(XMLHttpRequest.status + "----" + textStatus);
                }
            })
        }


    </script>
</head>
<body>
(????????????$.ajax)
<input type="button" value="get??????" onclick="getBtn()"/>
<input type="button" value="post??????" onclick="postBtn()"/>
<input type="button" value="post??????Json??????" onclick="postBtn2()"/>
<br/>
<br/>
<br/>
<br/>
(????????????$.get ???????????????????????????)
<br/>
??????????????????aa???bb:
<input type="text" onblur="getData(this.value)"/>
<br/>??????1???
<span id="s1"></span>
<br/>??????2???
<span id="s2"></span>
<br/>
<br/>
<br/>
<br/>
(????????????$.get+JSON.parse????????????)
<br/>
??????????????????aa???bb:
<input type="text" onblur="getData2(this.value)"/>
<br/>??????3???
<span id="s3"></span>
<br/>??????4???
<span id="s4"></span>
<br/>
<br/>
<br/>
<br/>
(????????????$.getJSON ????????????)
<br/>
??????????????????aa???bb:
<input type="text" onblur="getData3(this.value)"/>
<br/>??????5???
<span id="s5"></span>
<br/>??????6???
<span id="s6"></span>
</body>
</html>
