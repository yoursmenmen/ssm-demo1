<%--
  Created by IntelliJ IDEA.
  User: h
  Date: 8/16/2022
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head lang="en">
        <meta charset="UTF-8">
        <title> 静态资源后台管理系统</title>
        <link rel="stylesheet" href="css/public.css"/>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        <!--头部-->
        <header class="publicHeader">
            <h1> 静态资源后台管理系统</h1>
            <div class="publicHeaderR">
                <div style="width: 46px;height: 46px;border-radius: 50%;overflow: hidden;margin-left: -100px;float: left">
                    <img style="width: 100%" src="img/head_img.jpeg" alt="头像">
                </div>
                <span style="float: left"><a href="_login.jsp">退出</a></span>
            </div>
        </header>
        <!--时间-->
        <section class="publicTime">
            <span id="time">2019年1月1日 11:11  星期一</span>
            <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
        </section>
        <!--主体内容-->
        <section class="publicMian ">
            <div class="left"></div>
            <div class="right">
                <div class="location">
                    <strong>你现在所在的位置是:</strong>
                    <span>用户管理页面</span>
                </div>
                <div class="search">
<%--                    <span>查询条件：</span>
                    <input type="text" placeholder="请输入关键字"/>
                    <input type="button" value="查询"/>--%>
                    <a href="userAdd.jsp">新增用户</a>
                </div>
                <!--用户-->
                <table class="providerTable" cellpadding="0" cellspacing="0">
                    <tr class="firstTr">
                        <th width="10%">用户编号</th>
                        <th width="15%">用户名称</th>
                        <th width="6%">头像</th>
                        <th width="10%">性别</th>
                        <th width="10%">权限</th>
                        <th width="10%">省份</th>
                        <th width="10%">操作</th>
                    </tr>
                    <c:forEach items="${users}" var="user" varStatus="sequence">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>
                            <div style="width: 46px;height: 46px;border-radius: 50%;overflow: hidden;float: left;text-align:center">
                                <img style="width: 100%; margin: auto" src="img/head_img.jpeg" alt="头像">
                            </div>
                        </td>
                        <td>公</td>
                        <td>${user.authority}</td>
                        <td>${user.province}</td>
                        <td>
                            <a id="view" href="http://localhost:8080/ssm-demo1/userViewServlet?id=${user.id}"><img src="img/read.png"
                                                       alt="查看" title="查看"
                                                       onclick="view(${user.id})"/></a>
                            <a href="http://localhost:8080/ssm-demo1/selectByIdServlet?id=${user.id}"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                            <a href="#" class="removeUser" onclick="del(${sequence.index}, ${user.id})"><img src="img/schu.png" alt="删除" title="删除"/></a>
                        </td>
                        </c:forEach>
                </table>
            </div>
        </section>

        <!--点击删除按钮后弹出的页面-->
        <div class="zhezhao"></div>
        <div class="remove" id="removeUse">
            <div class="removerChid">
                <h2>提示</h2>
                <div class="removeMain">
                    <p>你确定要删除该用户吗？</p>
                    <a href="#" id="yes">确定</a>
                    <a href="#" id="no">取消</a>
                </div>
            </div>
        </div>

        <footer class="footer">
        </footer>

        <script src="js/axios.min.js"></script>
        <script src="js/vue.js"></script>
        <script src="js/jquery.js"></script>
        <!--<script src="js/js.js"></script>-->
        <!--<script src="js/time.js"></script>-->
        <script>

            document.getElementById("view").onclick = function (id) {
                location.href = "http://localhost:8080/ssm-demo1/userViewServlet" + id;
            }

            // let userList = {};
            // new Vue({
            //     el: "#view",
            //     data: userList,
            //     method: {
            //         view(id) {
            //             let str = "http://localhost:8080/ssm-demo1/users?id" + id;
            //             axios({
            //                 method: "GET",
            //                 url: str,
            //             }).then(function (resp) {
            //                 this.userList = resp.data.data;
            //             })
            //         },
            //     }
            //
            // })
            $(function () {
                $(".left").load("common_pri.html");
            });

            const deleteButton = document.getElementById("del");
            deleteButton.onclick = del;
            function del(id, userId) {
                let confirm = window.confirm("确认删除?");
                // alert(confirm);
                <%--location.href = "http://localhost:8080/brand_demo/deleteServlet?id=${brand.id}"--%>
                if(confirm){
                    location.href = "http://localhost:8080/ssm-demo1/deleteServlet?id=" + userId
                }

            }
        </script>
    </body>
</html>