<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/1/15
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.io.*,java.sql.*" errorPage="" %>
<%@ page import="util.*, bean.*, java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>回复评论-评论页面</title>
    <link rel="stylesheet" href="./vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="./vendor/font-awesome/css/fontawesome-all.min.css">
    <script type="text/javascript">
        function turnPage(i) {
            document.frm.cur_page.value = i;   // 跳转页面时，设置i为要跳转的页面，然后提交表单
            document.frm.submit();
        }

        function add() {
            window.location.href='FollowList';
        }
    </script>
    <link rel="stylesheet" href="./css/styles.css">
</head>
<body class="sidebar-fixed header-fixed">
<div class="page-wrapper">
    <nav class="navbar page-header">
        <a href="#" class="btn btn-link sidebar-mobile-toggle d-md-none mr-auto">
            <i class="fa fa-bars"></i>
        </a>

        <a class="navbar-brand" href="UserIndex">
            <img src="./images/logo.png" alt="logo">
        </a>

        <a href="#" class="btn btn-link sidebar-toggle d-md-down-none">
            <i class="fa fa-bars"></i>
        </a>

        <ul class="navbar-nav ml-auto">
            <li class="nav-item d-md-down-none">
                <a href="#">
                    <i class="fa fa-bell"></i>
                    <span class="badge badge-pill badge-danger">5</span>
                </a>
            </li>

            <li class="nav-item d-md-down-none">
                <a href="#">
                    <i class="fa fa-envelope-open"></i>
                    <span class="badge badge-pill badge-danger">5</span>
                </a>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <img src="./images/avatar-1.png" class="avatar avatar-sm" alt="logo">
                    <span class="small ml-1 d-md-down-none">${userId}</span>
                </a>

                <div class="dropdown-menu dropdown-menu-right">
                    <div class="dropdown-header">账号</div>

                    <a href="InformList?userId=${userId}" class="dropdown-item">
                        <i class="fa fa-user"></i> 个人信息
                    </a>

                    <a href="password_edit.jsp?userId=${userId}" class="dropdown-item">
                        <i class="fa fa-user"></i> 修改密码
                    </a>

                    <a href="logout.jsp" class="dropdown-item">
                        <i class="fa fa-lock"></i> 退出系统
                    </a>
                </div>
            </li>
        </ul>
    </nav>
    <div class="main-container">

        <div class="row">


        </div>
        <div class="container-fluid">
            <div class="container-fluid">
                <br/><br/><br/><br/><br/>
            </div>

            <div class="row">
                <div class="col-md-2"></div>
            </div>

            <div class="container-fluid">
            </div>

            <div class="row ">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <div id="toolbar"  style="text-align:right;margin-right:10px;">
                                <%--<input type="button" class="btn btn-rounded btn-info" value=" 添加关注 " onclick="add()" />--%>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th width=15%>用户id</th>
                                    <th width=80%>评论内容</th>
                                    <%--<th width="15%">操作</th>--%>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list }" var="bean">

                                    <tr>
                                        <td height="40">${bean.userId}</td>
                                        <td height="40">${bean.contentNext}</td>
                                        <%--<td height="40"><a href='reply.jsp'>回复</a></td>--%>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>

                    </div>
                </div>
            </div>

            <div class="container-fluid">
                <form action="CommentSecAdd?cId=${cId}" method="post">
                    <textarea name="contentNext" id="textarea" class="form-control" rows="6"></textarea>
                    <input type="submit" value="发送" class="btn btn-rounded btn-success">
                </form>
            </div>
        </div>
    </div>
</div>
<script src="./vendor/jquery/jquery.min.js"></script>
<script src="./vendor/popper.js/popper.min.js"></script>
<script src="./vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="./vendor/chart.js/chart.min.js"></script>
<script src="./js/carbon.js"></script>
<script src="./js/demo.js"></script>
</body>
</html>