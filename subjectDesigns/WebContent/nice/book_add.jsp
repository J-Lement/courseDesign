<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.*,java.sql.*"%>
<%@ page import="util.*, bean.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加书籍</title>
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
					<li><a href="SchManage">学校专业课程管理</a></li>
					<li><a href="CheckBook">上传书籍审核</a></li>
					<li><a href="category_list.jsp">发送广播</a></li>
				</ul>
			</div>
		
			<div class="col-md-10">
			<div id="dataArea">
			<form action="BookAdd" class="form" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label class="form-label">书籍ID：</label>
					<input class="form-control" type="text" name="bookId" value="" />
				</div>
				<div class="form-group">
					<label class="form-label">书籍名称：</label>
					<input class="form-control" type="text" name="bookName" value="" />
				</div>
				<div class="form-group">
					<label class="form-label">书籍作者：</label>
					<input class="form-control" type="text" name="bookAuthor"  value=""/>
				</div>	
				<div class="form-group">
					<label class="form-label">书籍简介：</label>
					<input class="form-control" type="text" name="bookInfo"  value=""/>
				</div>
				<div class="form-group">
					<label class="form-label">所属课程：</label>
					<input class="form-control" type="text" name="bookSub" value="" />
				</div>
				<div class="form-group">
					<label class="form-label">书籍文件：</label>
					<input class="form-control" type="file" name="file"/>
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