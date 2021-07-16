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
    <script  src="js/jquery-3.2.1.js"></script>
    <script type="text/javascript">
        function send(){
            var object=new Object();
            object.name=$('#name').val();
            object.age=$('#age').val();
            object.password=$('#password').val();
            var str=JSON.stringify(object); //把对象转换成JSON格式的字符串
            $.post("FrontToBackServlet?method=send",{user:str},function (data){
               alert(data);
            });
        }
        function send2(){
            var list=[];
            for(var i=0;i<3;i++){
                var object=new Object();
                object.name="姓名"+i;
                object.age=10+i;
                object.password="密码"+i;
                list.push(object);
            }
            var str=JSON.stringify(list); //把对象转换成JSON格式的字符串
            $.post("FrontToBackServlet?method=send2",{users:str},function (data){
                alert(data);
            });
        }
        function send3(){
            var object=new Object();
            object.name=$('#name').val();
            object.age=$('#age').val();
            object.password=$('#password').val();
            var str=JSON.stringify({
                "user":object,
                "msg":"testMap",
                "num":99
            });
            alert(str);
            $.post("FrontToBackServlet?method=send3",{str:str},function (data){
                data=JSON.parse(data);
                alert(data);
                $('#s').html(data.name);
            });
        }
    </script>
</head>
<body>
<p>姓名：<input type="text" id="name"/></p>
<p>年龄：<input type="text" id="age"/></p>
<p>密码：<input type="password" id="password"/></p>
<p><input type="button" value="发送数据" onclick="send()"/></p>
<p><input type="button" value="发送数组" onclick="send2()"/></p>
<p><input type="button" value="发送Map" onclick="send3()"/></p>
<span id="s"></span>
</body>
</html>
