<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.*,java.sql.*"%>
<%@ page import="util.*, bean.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加用户</title>
<link rel="stylesheet" href="css/style.css?v=1" type="text/css">
<link rel="stylesheet" href="css/bootstrap.css" type="text/css">
<style>
	
</style>


<script type="text/javascript">
	function ret() {
		history.back(-1);
	}
</script>
</head>
<body>
<div class="container">
		<div class="row" style="height:120px; padding:20px 2px;">
			<div class="col-md-3">
				<h3>欢迎使用图书推荐系统</h3>
			</div>
			
			<div class="col-md-9" id="loginInfo">
					欢迎您，<%=(String)session.getAttribute("username") %>，今天是<%=DateUtil.GetTodayStr() %>， 
					第 <%=100 %> 位用户  
					<a class="btn btn-warning" href="logout.jsp" >退出系统</a>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<a href="AdminIndex">首页</a>
				<ul class="nav-pills nav-stacked">
					<li class="active"><a href="AdminIndex">书籍管理</a></li>
					<li><a href="UserList">用户管理</a></li>
					<li><a href="SubManage">学校专业课程管理</a></li>
					<li><a href="CheckBook">上传书籍审核</a></li>
					<li><a href="category_list.jsp">发送广播</a></li>
				</ul>
			</div>
		
			<div class="col-md-10">
			<div id="dataArea">
			<form action="UserAdd" class="form" method="post" >
				<div class="form-group">
					<label class="form-label">用户ID：</label>
					<input class="form-control" type="text" name="userId" value="" />
				</div>
				<div class="form-group">
					<label class="form-label">用户姓名：</label>
					<input class="form-control" type="text" name="userName" value="" />
				</div>
				<div class="form-group">
					<label class="form-label">用户密码：</label>
					<input class="form-control" type="text" name="password"  value=""/>
				</div>	
				<div class="form-group">
					<label class="form-label">用户类型：</label><select class="form-control" name="userType">
						<option value="">请选择</option>
						<option value="学生">学生</option>
						<option value="管理员">管理员</option>
					</select>
				</div>
				<div class="form-group">
						
						<button type="submit" class="btn btn-primary"> 保存 </button>
						<button type="button" class="btn btn-default" onclick="ret()"> 返回 </button>
					
				</div>
			
			</form>	
			</div>
			
			</div>
		</div>
		<div class="row">
			<div class="col-md-12" style="text-align:center">
				2018 版权所有  
			</div> 
		</div>
	</div>
</body>
</html>