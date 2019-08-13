<%@ page contentType="text/html; charset=utf-8" language="java" import="java.io.*,java.sql.*" errorPage="" %>
<%@ page import="util.*, bean.*, java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>用户管理</title>
    <link rel="stylesheet" href="./vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="./vendor/font-awesome/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="./css/styles.css">
    <script type="text/javascript">
    function turnPage(i) {
		document.frm.cur_page.value = i;   // 跳转页面时，设置i为要跳转的页面，然后提交表单
		document.frm.submit();
	}
	
	function add() {
		window.location.href='userAdd.jsp';
	}
	
	function deleteIt(str){
		if(confirm("确认删除此用户？"))
			window.location.href='UserDelete?userId=' + str;
		else
			return;
	}
</script>
</head>
<body class="sidebar-fixed header-fixed">
<div class="page-wrapper">
    <div class="page-header">
        <nav class="navbar page-header">
            <a href="#" class="btn btn-link sidebar-mobile-toggle d-md-none mr-auto">
                <i class="fa fa-bars"></i>
            </a>

            <a class="navbar-brand" href="#">
                <img src="./imgs/logo.png" alt="logo">
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
                        <img src="./imgs/avatar-1.png" class="avatar avatar-sm" alt="logo">
                        <span class="small ml-1 d-md-down-none">John Smith</span>
                    </a>

                    <div class="dropdown-menu dropdown-menu-right">
                        <a href="logout.jsp" class="dropdown-item">
                            <i class="fa fa-lock"></i> 退出系统
                        </a>
                    </div>
                </li>
            </ul>
        </nav>
    </div>

    <div class="main-container">
        <div class="sidebar">
            <nav class="sidebar-nav">
                <ul class="nav">
                    <li class="nav-title">Navigation</li>

                    <li class="nav-item">
                        <a href="AdminIndex" class="nav-link">
                            <i class="icon icon-speedometer"></i> 书籍管理
                        </a>
                    </li>
                    
                    <li class="nav-item">
                        <a href="UserList" class="nav-link">
                            <i class="icon icon-speedometer"></i> 用户管理
                        </a>
                    </li>

                    <li class="nav-item nav-dropdown">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-target"></i> 学校专业课程管理 <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a href="SchManage" class="nav-link">
                                    <i class="icon icon-target"></i> 学校管理
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="MajManage" class="nav-link">
                                    <i class="icon icon-target"></i> 专业管理
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="SubManage" class="nav-link">
                                    <i class="icon icon-target"></i> 课程管理
                                </a>
                            </li>

                        </ul>
                    </li>

                    <li class="nav-item">
                        <a href="CheckBook" class="nav-link">
                            <i class="icon icon-puzzle"></i> 上传书籍审核
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="webSocketS.jsp" class="nav-link">
                            <i class="icon icon-grid"></i> 发送广播
                        </a>
                    </li>
                    
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>

        <div class="content">
            <div class="container">
             <form name="frm" action="UserList">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body p-0">
                           <div class="card-body">
                           <div class="row">
                           <div class="col-md-3">
                                        <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">用户ID</span>
                                            </div>
                                            <input type="text" name="userId" class="form-control" value="${userId}">
                                    </div>
                                </div>
                                    <div class="col-md-3">
                                        <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">用户姓名</span>
                                            </div>
                                            <input type="text" name="userName" class="form-control" value="${userName}">
                                    </div>
                                </div>
                                <div class="col-md-3">
                                        <div class="form-group">
                                            <select id="single-select" class="form-control" name="userType">
                                                <option value="" >请选择</option>
								<option value="学生" <c:if test="${userType == '学生' }">${"selected"}</c:if>>学生</option>
								<option value="管理员" <c:if test="${userType == '管理员' }">${"selected"}</c:if>>管理员</option>
                                            </select>
                                        </div>
                                </div>
                                <div class="my-0">
                                <button type="submit" class="btn btn-primary">查询</button>
                                
                                <button type="button" class="btn btn-info" onclick="add()"> 新增用户</button>
                                <!-- <a class="btn btn-primary" href='addIllegal.jsp'>添加禁词</a> -->
                                <input type="hidden" name="cur_page" value=""> <!-- 增加隐藏变量，记录当前页码 -->
                                </div>
                                
                          </div>
                          </div>
                                <div class="row p-1">
                                    <div class="col-md-12">
                                        <table class="table">
                                            <thead>
                                            <tr>
                                                <th class="border-0 text-uppercase small font-weight-bold">用户ID</th>
                                                <th class="border-0 text-uppercase small font-weight-bold">用户姓名</th>
                                                <th class="border-0 text-uppercase small font-weight-bold">用户密码</th>
                                                <th class="border-0 text-uppercase small font-weight-bold">用户类型</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${userList }"	var="userBean">		
					<tr>
						<td>${userBean.userId }</td>	
						<td>${userBean.userName}</td>
						<td>${userBean.password}</td>
						<td class="tdsty">${userBean.userType}</td>
						<td><a class="btn btn-primary" href='UserEdit?userId=${userBean.userId}'>修改</a>
							<a class="btn btn-danger" href='javascript:deleteIt(${userBean.userId})'>删除</a></td>
					</tr>
			</c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                                <div class="d-flex flex-row-reverse bg-dark text-white p-4">
                                	<div class="py-3 px-5 text-right">
                                    <label>共${pager.totalPage }页${pager.totalRecord }条数据 ，导航至：  </label>
					<c:forEach var="i" begin="1" end="${pager.totalPage }">
						<button type="button" class='btn <c:if test="${i == pager.curPage}">btn-primary</c:if> btn-default' onclick="turnPage(${i})" > ${i } </button>
					</c:forEach>
									</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
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