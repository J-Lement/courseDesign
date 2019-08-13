<%@ page contentType="text/html; charset=utf-8" language="java" import="java.io.*,java.sql.*" errorPage="" %>
<%@ page import="util.*, bean.*, java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员信息</title>
<link rel="stylesheet" href="css/style.css?v=1" type="text/css">
<link rel="stylesheet" href="css/bootstrap.css" type="text/css">
<style>
	
</style>

<script type="text/javascript">
	function turnPage(i) {
		document.frm.cur_page.value = i;   // 跳转页面时，设置i为要跳转的页面，然后提交表单
		document.frm.submit();
	}
	
	function add() {
		window.location.href='book_add.jsp';
	}
	
	function deleteIt(str){
		if(confirm("确认删除此书？"))
			window.location.href='BookDelete?bookId=' + str;
		else
			return;
	}
</script>
</head>
<body>
	
	<div class="container">
		<div class="row" style="height:120px; padding:20px 2px;">
			<div class="col-md-4">
				<h3>欢迎使用图书推荐系统 </h3>
			</div>
			
			<div class="col-md-8" id="loginInfo">
					欢迎您，<%=(String)session.getAttribute("userId") %>，今天是<%=DateUtil.GetTodayStr() %>， 
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
					<li><a href="webSocketS.jsp">发送广播</a></li>
				</ul>
			</div>
		
			<div class="col-md-10">
				<div>
					<form name="frm" class="form-inline" action="AdminIndex">
						<div class="form-group">
						<label class="form-label">学校：</label><select class="form-control" name="schName" >
							<option value = "">请选择</option>
							<c:forEach items="${listSch }"	var="item">	
								<option value="${item }" <c:if test="${item == schName}">${"selected" }</c:if>>${item }</option>
							</c:forEach>
							</select>
						</div>
						<div class="form-group">
						<label class="form-label">专业：</label><select class="form-control" name="majName" >
							<option value = "">请选择</option>
							<c:forEach items="${listMaj }"	var="item">	
								<option value="${item }" <c:if test="${item == majName}">${"selected" }</c:if>>${item }</option>
							</c:forEach>
							</select>
						</div>
						<div class="form-group">
						<label class="form-label">课程：</label><select class="form-control" name="subName" >
						<option value = "">请选择</option>
						<c:forEach items="${listSub }"	var="item">	
							<option value="${item }" <c:if test="${item == subName}">${"selected" }</c:if>>${item }</option>
						</c:forEach>
						</select>
						</div>
						<button type="submit" class="btn btn-info"> 查找 </button>
						
						<input type="hidden" name="cur_page" value=""> <!-- 增加隐藏变量，记录当前页码 -->
					</form>
				</div>
				<div id="toolbar" style="text-align:right;margin-right:10px;">
					<button type="button" class="btn btn-info" onclick="add()"> 新增书籍</button>
				</div>
				<div id="dataArea">
					<table class="table table-hover">
					<thead>
					<tr>
						<th>书ID</th>
						<th>书名</th>
						<th>作者</th>
						<th>简介</th>
						<th>所属课程</th>
						<th>书籍详情</th>
					</tr>	
					</thead>
					<tbody>

			<c:forEach items="${list }"	var="bean">		
					<tr>
						<td>${bean.bookId }</td>	
						<td>${bean.bookName}</td>
						<td>${bean.bookAuthor}</td>
						<td class="tdsty">${bean.bookInfo}</td>
						<td>${bean.bookSub }</td>
						<td><a href="upload/${bean.bookAttach }"/>${bean.bookAttach }</td>
						<td><a class="btn btn-primary" href='BookEdit?bookId=${bean.bookId}'>修改</a>
							<a class="btn btn-danger" href='javascript:deleteIt(${bean.bookId})'>删除</a></td>
					</tr>
			</c:forEach>
					</tbody>
				</table>	
				</div>
				
				<div id="pageFooter" class="btn-group">
					<label>共${pager.totalPage }页${pager.totalRecord }条数据 ，导航至：  </label>
					<c:forEach var="i" begin="1" end="${pager.totalPage }">
						<button type="button" class='btn <c:if test="${i == pager.curPage}">btn-primary</c:if> btn-default' onclick="turnPage(${i})" > ${i } </button>
					</c:forEach>
					
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