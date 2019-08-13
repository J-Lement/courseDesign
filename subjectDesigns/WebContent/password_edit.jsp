<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2018/12/30
  Time: 0:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.io.*,java.sql.*" errorPage="" %>
<%@ page import="bean.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>个人信息-个人中心</title>
    <link rel="stylesheet" href="./vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="./vendor/font-awesome/css/fontawesome-all.min.css">
    <script type="text/javascript">
        function ret() {
        history.back(-1);
        }
    </script>
    <link rel="stylesheet" href="./css/styles.css">
</head>
<body class="sidebar-fixed header-fixed">
<div class="page-wrapper">
    <!--顶部用户信息栏nav-->
    <nav class="navbar page-header">
        <a href="#" class="btn btn-link sidebar-mobile-toggle d-md-none mr-auto">
            <i class="fa fa-bars"></i>
        </a>

        <a class="navbar-brand" href="UserIndex">
            <img src="./images/logo.png" alt="logo" >
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

                    <a href="password_edit.jsp" class="dropdown-item">
                        <i class="fa fa-user"></i> 修改密码
                    </a>

                    <a href="logout.jsp" class="dropdown-item">
                        <i class="fa fa-lock"></i> 退出系统
                    </a>
                </div>
            </li>
        </ul>
    </nav>
    <!--整体主页面-->
    <div class="main-container">
        <!--侧边栏-->
        <div class="sidebar">
            <nav class="sidebar-nav">
                <ul class="nav">
                    <li class="nav-title">Navigation</li>

                    <li class="nav-item">
                        <a href="InformList?userId=${userId}" class="nav-link active">
                            <i class="icon icon-speedometer"></i> 个人信息
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="FocusList?userId=${userId}" class="nav-link active">
                            <i class="icon icon-target"></i> 关注列表
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="CollectList?userId=${userId}" class="nav-link active">
                            <i class="icon icon-energy"></i>收藏列表
                        </a>
                    </li>

                    <li class="nav-item nav-dropdown">
                        <a href="BookMarkList?userId=${userId}" class="nav-link active">
                            <i class="icon icon-graph"></i> 书签列表
                        </a>

                    </li>

                    <li class="nav-title">More</li>

                    <li class="nav-item nav-dropdown">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-umbrella"></i> Pages <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a href="blank.html" class="nav-link">
                                    <i class="icon icon-umbrella"></i> Blank Page
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="login.html" class="nav-link">
                                    <i class="icon icon-umbrella"></i> Login
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="register.html" class="nav-link">
                                    <i class="icon icon-umbrella"></i> Register
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="invoice.html" class="nav-link">
                                    <i class="icon icon-umbrella"></i> Invoice
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="404.html" class="nav-link">
                                    <i class="icon icon-umbrella"></i> 404
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="500.html" class="nav-link">
                                    <i class="icon icon-umbrella"></i> 500
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="settings.html" class="nav-link">
                                    <i class="icon icon-umbrella"></i> Settings
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
        <!--右部主要信息显示栏-->
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-3">
                        <div class="card p-4">
                            <div class="card-body d-flex justify-content-between align-items-center">
                                <div>
                                    <span class="h4 d-block font-weight-normal mb-2"></span>
                                    <span class="font-weight-light">已关注课程数</span>
                                </div>

                                <div class="h2 text-muted">
                                    <i class="icon icon-people"></i>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="card p-4">
                            <div class="card-body d-flex justify-content-between align-items-center">
                                <div>
                                    <span class="h4 d-block font-weight-normal mb-2"></span>
                                    <span class="font-weight-light">已收藏书籍数</span>
                                </div>

                                <div class="h2 text-muted">
                                    <i class="icon icon-wallet"></i>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="card p-4">
                            <div class="card-body d-flex justify-content-between align-items-center">
                                <div>
                                    <span class="h4 d-block font-weight-normal mb-2">900</span>
                                    <span class="font-weight-light">已设置书签数</span>
                                </div>

                                <div class="h2 text-muted">
                                    <i class="icon icon-cloud-download"></i>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="card p-4">
                            <div class="card-body d-flex justify-content-between align-items-center">
                                <div>
                                    <span class="h4 d-block font-weight-normal mb-2">32s</span>
                                    <span class="font-weight-light">Time</span>
                                </div>

                                <div class="h2 text-muted">
                                    <i class="icon icon-clock"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row ">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">
                            </div>
                            <div class="table-responsive">
                                <form action="UserPasswordEdit" method="post">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="old_password" class="form-control-label">旧密码：</label>
                                        <input id="old_password" type="password" name="old_password" class="form-control" value="">
                                    </div>
                                    <div class="form-group">
                                        <label for="new_password" class="form-control-label">新密码：</label>
                                        <input id="new_password" type="password" name="new_password" class="form-control" value="">
                                    </div>
                                    <div class="form-group">
                                        <label for="check_password" class="form-control-label">确认密码：</label>
                                        <input id="check_password" type="password" name="check_password" class="form-control" value="">
                                    </div>
                                </div>
                                <input type="hidden" name="userId" value="${userId}" />
                                <input class="btn btn-info" type="submit" value=" 保存 " />
                                <input class="btn btn-danger" type="button" value=" 返回 " onclick="ret()"/>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
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
<%--<html>--%>
<%--<head>--%>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8">--%>
    <%--<title>修改密码-个人中心</title>--%>
    <%--<style>--%>

        <%--@import url('../css/style.css');--%>
    <%--</style>--%>

    <%--<style>--%>
        <%--tr {--%>
            <%--line-height:40px;--%>
        <%--}--%>
    <%--</style>--%>
    <%--<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">--%>
    <%--<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>--%>
    <%--<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>


    <%--<script type="text/javascript">--%>
        <%--function ret() {--%>
            <%--history.back(-1);--%>
        <%--}--%>
    <%--</script>--%>
<%--</head>--%>

<%--<body>--%>


<%--&lt;%&ndash;&lt;%&ndash;%>--%>
<%--&lt;%&ndash;String id;&ndash;%&gt;--%>

<%--&lt;%&ndash;id = request.getParameter("id");&ndash;%&gt;--%>
<%--&lt;%&ndash;if (id == null || "".equals(id))&ndash;%&gt;--%>
<%--&lt;%&ndash;{&ndash;%&gt;--%>
<%--&lt;%&ndash;out.println("出错了！！！");&ndash;%&gt;--%>
<%--&lt;%&ndash;return;&ndash;%&gt;--%>
<%--&lt;%&ndash;}&ndash;%&gt;--%>
<%--&lt;%&ndash;FileBean bean = new FileBean();&ndash;%&gt;--%>
<%--&lt;%&ndash;FileDao dao = new FileDao();&ndash;%&gt;--%>
<%--&lt;%&ndash;bean = dao.loadFile(Integer.parseInt(id));&ndash;%&gt;--%>
<%--&lt;%&ndash;%>&ndash;%&gt;--%>

<%--<div id="main">--%>
    <%--<div id="topDiv">--%>
        <%--<p><b>我的信息</b></p>--%>
        <%--<div id="loginInfo">--%>
            <%--欢迎您，<%=(String)session.getAttribute("username") %>，今天是<%=new java.util.Date() %>--%>
            <%--第 <%=100 %> 位用户--%>
            <%--<a href="logout.jsp" >退出系统</a>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div id="leftDiv">--%>
        <%--<a href="UserIndex">首页</a>--%>
        <%--<ul id="nav">--%>
            <%--<li><a href="InformList">个人信息</a></li>--%>
            <%--<li><a href="FocusList">关注列表</a></li>--%>
            <%--<li><a href="CollectList.jsp">收藏列表</a></li>--%>
            <%--<li><a href="BookmarkList.jsp">书签列表</a></li>--%>
        <%--</ul>--%>
    <%--</div>--%>
    <%--<div id="rightDiv">--%>
        <%--<div id="dataArea">--%>
            <%--<form action="FileEditDo" method="post">--%>
                <%--<table border="0">--%>
                    <%--<caption>修改密码</caption>--%>
                    <%--<tr>--%>
                        <%--<td class="title" width="120">旧密码：</td>--%>
                        <%--<td class="content" width="300"><input type="text" name="title" value="${bean.title}" /></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td class="title">新密码：</td>--%>
                        <%--<td class="content"><input type="text" name="content"  value="${bean.content}"/></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td class="title">确认密码：</td>--%>
                        <%--<td class="content"><input type="text" name="content"  value="${bean.content}"/></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td colspan="2" align="center">--%>
                            <%--<input type="hidden" name="id" value="${bean.id}" />--%>
                            <%--<input type="submit" value=" 保存 " />--%>
                            <%--<input type="button" value=" 返回 " onclick="ret()"/>--%>
                        <%--</td>--%>
                    <%--</tr>--%>

                <%--</table>--%>
            <%--</form>--%>
        <%--</div>--%>

    <%--</div>--%>
    <%--<div id="bottomDiv">--%>
        <%--2018 版权所有--%>
    <%--</div>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>