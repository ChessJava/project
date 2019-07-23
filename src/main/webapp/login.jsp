<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/7/18
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
    <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
    <link type="text/css" rel="stylesheet" href="css/login.css">
</head>
<body background="images/1.gif">
    <script type="text/javascript">
        function submitData(){
            var username = $("#username").val();
            var password = $("#password").val();
            $.ajax({
                url:"/user/login",
                type:"post",
                data:{"username":username,"password":password},
                dataType:"json",
                success:function (result) {
                    alert(result.result);
                    if(result.result == "请求成功"){
                        window.location.href = "/show";
                    }else{
                        window.location.reload();
                    }
                }
            })
        }
    </script>
    <input type="text" id="username" name="username" placeholder="请输入账户"><br>
    <input type="password" id="password" name="password" placeholder="请输入密码"><br>
    <button type="submit" onclick="submitData()">登陆</button>
</body>
</html>
