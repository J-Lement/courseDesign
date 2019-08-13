<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.*,java.sql.*"%>
<%@ page import="bean.*,util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上传书籍</title>
<link rel="stylesheet" href="css/style.css?v=1" type="text/css">
<link rel="stylesheet" href="css/bootstrap.css" type="text/css">
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
				<a href="UserIndex">首页</a>
			</div>
		
			<div class="col-md-10">
			<div id="dataArea">
			<form action="UploadBook" class="form" method="post" enctype="multipart/form-data">
				<input type="hidden" name="userId" value="${sessionScope.userId }" />
				<div class="form-group">
					<label class="form-label">书籍名称：</label>
					<input class="form-control" type="text" name="bName" value="" />
				</div>
				<div class="form-group">
					<label class="form-label">所属课程：</label>
					<input class="form-control" type="text" name="bSub" value="" />
				</div>
				<div class="form-group">
					<label class="form-label">书籍作者：</label>
					<input class="form-control" type="text" name="bAuthor"  value=""/>
				</div>	
				<div class="form-group">
					<label class="form-label">书籍简介：</label>
					<input class="form-control" type="text" name="bInfo"  value=""/>
				</div>
				<div class="form-group">
					<label class="form-label">附件：</label>
					<input class="form-control" type="file" name="bAttach"/>
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