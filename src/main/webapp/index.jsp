<%--
  Created by IntelliJ IDEA.
  User: h
  Date: 8/16/2022
  Time: 9:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head lang="en">
        <meta charset="UTF-8">
        <title> 静态资源后台管理系统主页</title>
        <link rel="stylesheet" href="css/public.css"/>
        <link rel="stylesheet" href="css/style.css"/>
        <script src="js/jquery.js"></script>
    </head>
    <body>
        <!--头部-->
        <header class="publicHeader">
            <h1> 静态资源后台管理系统</h1>

            <div class="publicHeaderR">
                <div style="width: 46px;height: 46px;border-radius: 50%;overflow: hidden;margin-left: -100px;float: left">
                    <img style="width: 100%" src="img/head_img.jpeg" alt="头像">
                </div>
                <span style="float: left" ><a href="_login.jsp">退出</a></span>
            </div>
        </header>
        <!--时间-->
        <section class="publicTime">
            <span id="time">2019年1月1日 11:11  星期一</span>

        </section>
        <!--主体内容-->
        <section class="publicMian">
            <div class="left">
                <ul class="list">
                    <li><a href="http://localhost:8080/ssm-demo1/vipCheckServlet" onclick="${check_msg}">用户管理</a></li>
                    <li><a href="password.jsp">密码修改</a></li>
                    <li ><a href="#">视频管理</a></li>
                    <li><a href="#">图片管理</a></li>
                    <li><a href="#">角色管理</a></li>
                </ul>
            </div>
            <div class="right">
                <img class="wColck" src="img/clock.jpg" alt=""/>
                <div class="wFont">
<%--                    <span id="username_err" class="err_msg" >${check_msg}</span>--%>
                    <h2>${user.username}</h2>
                    <p>欢迎来到 静态资源后台管理系统!</p>
                    <span id="hours"></span>
                </div>
            </div>
        </section>
        <script src="js/time.js"></script>
        <footer class="footer">
        </footer>


        <script>

            function check (){
                alert("权限不足")
            }

            $(function () {
                $(".left").load("common_pri.html");
            }) ;
        </script>
    </body>
</html>
