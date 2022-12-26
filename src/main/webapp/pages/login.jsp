<%--
  Created by IntelliJ IDEA.
  User: h
  Date: 7/30/2022
  Time: 2:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>login</title>
        <link href="../css/login.css" rel="stylesheet">
        <style>
            #errorMsg{
                color: red;
            }
        </style>
    </head>

    <body>
        <div id="loginDiv" style="height: 350px">
            <%--<form action="http://localhost:8080/ssm-demo1/loginServlet" id="form">--%>
            <form action="http://localhost:8080/ssm-demo1/login" id="form" method="post">
                <h1 id="loginMsg">LOGIN IN</h1>
                <div id="errorMsg" align="centre">${login_err_msg}</div>
                <p>Username:<input id="username" name="username" type="text" value="${cookie.username.value}"></p>

                <p>Password:<input id="password" name="password" type="password" value="${cookie.password.value}"></p>
                <p>Remember:<input id="remember" name="remember" value="1" type="checkbox"></p>
                <div id="subDiv">
                    <button class="button" id="btn">login up</button>
<%--                    <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;--%>
                        <br>
                        <br>
                        <br>
                    <a href="../register.jsp">没有账号？</a>
                </div>
            </form>
        </div>
    </body>

    <script src="../js/axios.min.js"></script>
    <script>

        var user = {
            "username":"mingming",
            "password":"123"
        }
        document.getElementById("btn").onclick = function (){
            axios({
                method: "POST",
                url: "http://localhost:8080/ssm-demo1/login",
                data : user,
                header:{
                    'Content-Type':'application/json'  //如果写成contentType会报错,如果不写这条也报错
                    //Content type 'application/x-www-form-urlencoded;charset=UTF-8'...
                }
            }).then(function (resp){
                alert(resp.data.msg)
                alert(JSON.stringify(user))
            })
        }

    </script>
</html>