<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2018/12/29
  Time: 12:03
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
    <title>个人信息-个人中心</title>
    <link rel="stylesheet" href="./vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="./vendor/font-awesome/css/fontawesome-all.min.css">
    <script type="text/javascript">
        function turnPage(i) {
            document.frm.cur_page.value = i;   // 跳转页面时，设置i为要跳转的页面，然后提交表单
            document.frm.submit();
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

                <div class="row ">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">

                            </div>
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>收藏书籍</th>
                                        <th>跳转</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${list }" var="bean">

                                        <tr>
                                                <td>${bean.bookName }</td>
                                                <td>${bean.bookAttach}</td>
                                                <td><a href='CollectDel?bookId=${bean.bookId}&userId=${userId}'>删除 </a>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                            <div id="pageFooter">
                                <label>共${pager.totalPage }页${pager.totalRecord }条数据 ，导航至：  </label>
                                <c:forEach var="i" begin="1" end="${pager.totalPage }">
                                    <button type="button" class='btn <c:if test="${i == pager.curPage}">btn-outline-primary</c:if> btn-default' onclick="turnPage(${i})" > ${i } </button>
                                </c:forEach>
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
    <%--<title>收藏列表-个人中心</title>--%>
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

        <%--// function add() {--%>
        <%--//     window.location.href='file_add.jsp';--%>
        <%--// }--%>
    <%--</script>--%>
<%--</head>--%>

<%--<body>--%>

<%--<div id="main">--%>
    <%--<div id="topDiv">--%>
        <%--<p><b>我的信息</b></p>--%>
        <%--<div id="loginInfo">--%>
        <%--&lt;%&ndash;欢迎您，<%=(String)session.getAttribute("username") %>，今天是<%=new java.util.Date() %>&ndash;%&gt;--%>
        <%--&lt;%&ndash;第 <%=100 %> 位用户&ndash;%&gt;--%>
        <%--<a href="logout.jsp" >退出系统</a>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div id="leftDiv">--%>
        <%--<a href="UserIndex">首页</a>--%>
        <%--<ul id="nav">--%>
            <%--<li><a href="InformList?user=${userId}">个人信息</a></li>--%>
            <%--<li><a href="FocusList?user=${userId}">关注列表</a></li>--%>
            <%--<li><a href="CollectList?userId=${userId}">收藏列表</a></li>--%>
            <%--<li><a href="BookMarkList?userId=${userId}">书签列表</a></li>--%>
        <%--</ul>--%>
    <%--</div>--%>
    <%--<div id="rightDiv">--%>
        <%--<div id="searchBox">--%>
            <%--<form name="frm" action="BookSearch">--%>
                <%--书籍名称：<input type="text" name="book_name" value="">--%>
                <%--&lt;%&ndash;来源：<input type="text" name="source" value="${(bean.source==null?"":bean.source)}">&ndash;%&gt;--%>
                <%--&lt;%&ndash;起始时间：<input type="text" nam--%>
                <%--="create_date" value="${(bean.create_date==null?"":bean.create_date)}">&ndash;%&gt;--%>
                <%--&lt;%&ndash;所在城市：<select name="city">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<option value="">请选择</option>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<option value="南昌" <%=("南昌".equals(city)?"selected":"") %>>南昌</option>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<option value="成都" <%=("成都".equals(city)?"selected":"") %>>成都</option>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</select>&ndash;%&gt;--%>

                <%--<input type="submit" value=" 查找 " />--%>

                <%--<input type="hidden" name="cur_page" value=""> <!-- 增加隐藏变量，记录当前页码 -->--%>
                <%--<input type="hidden" name="userId" value="3">--%>
            <%--</form>--%>
        <%--</div>--%>
        <%--&lt;%&ndash;<div id="toolbar" style="text-align:right;margin-right:10px;">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<input type="button" value=" 新增员工 " onclick="add()" />&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--<div id="dataArea">--%>
            <%--<table width="100%" border="1" style="border-collapse:collapse">--%>
                <%--<tr>--%>
                    <%--<th>收藏书籍</th>--%>
                    <%--<th>跳转</th>--%>
                    <%--<th>操作</th>--%>
                <%--</tr>--%>

                <%--<c:forEach items="${list }" var="bean">--%>
                    <%--<tr>--%>
                        <%--<td>${bean.bookName }</td>--%>
                        <%--<td>${bean.bookAttach}</td>--%>
                        <%--<td><a href='CollectDel?bookId=${bean.bookId}'>删除 </a>--%>
                        <%--<td></td>--%>
                        <%--<td></td>--%>
                    <%--</tr>--%>
                <%--</c:forEach>--%>

            <%--</table>--%>
        <%--</div>--%>
        <%--<div id="pageFooter">--%>
            <%--<label>共${pager.totalPage }页${pager.totalRecord }条数据 ，导航至：  </label>--%>
            <%--<c:forEach var="i" begin="1" end="${pager.totalPage }">--%>
                <%--<button type="button" class='btn <c:if test="${i == pager.curPage}">btn-primary</c:if> btn-default' onclick="turnPage(${i})" > ${i } </button>--%>
            <%--</c:forEach>--%>

        <%--</div>--%>
    <%--</div>--%>
    <%--<div id="bottomDiv">--%>
        <%--2018 版权所有--%>
    <%--</div>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
