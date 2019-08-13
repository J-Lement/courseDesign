<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2018/12/28
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.io.*,java.sql.*" errorPage="" %>
<%@ page import="util.*, bean.*, java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--<html>--%>
<%--<head>--%>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8">--%>
    <%--<title>个人信息-个人中心</title>--%>
    <%--<link rel="stylesheet" href="css/style.css?v=1" type="text/css">--%>
    <%--<link rel="stylesheet" href="css/bootstrap.css" type="text/css">--%>
    <%--<style>--%>
        <%--@import url('../css/style.css');--%>
    <%--</style>--%>
    <%--<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">--%>
    <%--<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>--%>
    <%--<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>

    <%--<script type="text/javascript">--%>
        <%--function turnPage(i) {--%>
            <%--document.frm.cur_page.value = i;   // 跳转页面时，设置i为要跳转的页面，然后提交表单--%>
            <%--document.frm.submit();--%>
        <%--}--%>

        <%--function add() {--%>
            <%--window.location.href='file_add.jsp';--%>
        <%--}--%>
    <%--</script>--%>
<%--</head>--%>

<%--<body>--%>

<%--<div id="main">--%>
    <%--<div id="topDiv">--%>
        <%--<p><b>我的信息</b></p>--%>
        <%--<div id="loginInfo">--%>
        <%--欢迎您，<%=(String)session.getAttribute("userId") %>，今天是<%=new java.util.Date() %>--%>
        <%--第 <%=100 %> 位用户--%>

        <%--<a href="logout.jsp" >退出系统</a>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div id="leftDiv">--%>
        <%--<a href="UserIndex">首页</a>--%>
        <%--<ul id="nav">--%>
            <%--<li><a href="InformList?user=${userId}">个人信息</a></li>--%>
            <%--<li><a href="FocusList?userId=${userId}">关注列表</a></li>--%>
            <%--<li><a href="CollectList?userId=${userId}">收藏列表</a></li>--%>
            <%--<li><a href="BookMarkList?userId=${userId}">书签列表</a></li>--%>
        <%--</ul>--%>
    <%--</div>--%>
    <%--<div id="rightDiv">--%>
        <%--<div id="inform">--%>
            <%--<table width="100%" border="1" style="...">--%>
                <%--<tr>--%>
                    <%--<td class="title" width="120">用户名： </td>--%>
                    <%--<td class="content" width="300">${userId}</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td class="title">已关注课程数：</td>--%>
                    <%--<td class="content">${FocusCount}</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td class="title">已收藏书籍数：</td>--%>
                    <%--<td class="content">${CollectCount}</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td class="title">已设置书签数：</td>--%>
                    <%--<td class="content"></td>--%>
                <%--</tr>--%>

            <%--</table>--%>
            <%--<input type="submit" value="修改密码" >--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div id="bottomDiv">--%>
        <%--2018 版权所有--%>
    <%--</div>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
<%--<!doctype html>--%>
<%--<html lang="en">--%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>个人信息-个人中心</title>
    <link rel="stylesheet" href="./vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="./vendor/font-awesome/css/fontawesome-all.min.css">
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
                        <a href="Recommend" class="nav-link nav-dropdown-toggle">
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
                                    <span class="h4 d-block font-weight-normal mb-2">${FocusCount}</span>
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
                                    <span class="h4 d-block font-weight-normal mb-2">${CollectCount}</span>
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
                                    <span class="h4 d-block font-weight-normal mb-2">${MarkCount}</span>
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
                                    <span class="font-weight-light">提醒时间</span>
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
                        <%--图片--%>
                        <<img src="./images/InfoBG.jpg" alt="这谁顶得住啊！">
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
