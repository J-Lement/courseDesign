<%@ page contentType="text/html; charset=utf-8" language="java" import="java.io.*,java.sql.*" errorPage="" %>
<%@ page import="util.*, bean.*, java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>审核上传书籍</title>
<link rel="stylesheet" href="css/style.css?v=1" type="text/css">
<link rel="stylesheet" href="css/bootstrap.css" type="text/css">
<style>
	
</style>

<script type="text/javascript">
	function turnPage(i) {
		document.frm.cur_page.value = i;   // 跳转页面时，设置i为要跳转的页面，然后提交表单
		document.frm.submit();
	}
	
	function saveIt(str){
		if(confirm("确认通过审核？"))
			window.location.href='SaveUpBook?tempId=' + str;
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
					<li><a href="SubManage">学校专业课程管理</a></li>
					<li><a href="CheckBook">上传书籍审核</a></li>
					<li><a href="webSocketS.jsp">发送广播</a></li>
				</ul>
			</div>
		
			<div class="col-md-10">
				<div>
					<form name="frm" class="form-inline" action="CheckBook">
						<div class="form-group">
						<label class="form-label">书名：</label>
							<input type="text" class="form-control" name="bName" value="${bName }"/>
						</div>
						<div class="form-group">
						<label class="form-label">所属课程：</label>
							<input type="text" class="form-control" name="bSub" value="${bSub }" />
						</div>
						<div class="form-group">
						<label class="form-label">是否审核：</label><select class="form-control" name="ifCheck" >
							<option value = "">全部</option>
							<option value="是" <c:if test="${ifCheck == '是'}">${"selected" }</c:if>>是</option>
							<option value="否" <c:if test="${ifCheck == '否'}">${"selected" }</c:if>>否</option>
						</select>
						</div>
						<button type="submit" class="btn btn-info"> 查找 </button>
						
						<input type="hidden" name="cur_page" value=""> <!-- 增加隐藏变量，记录当前页码 -->
					</form>
				</div>
				<div id="dataArea">
					<table class="table table-hover">
					<thead>
					<tr>
						<th>书ID</th>
						<th>上传者ID</th>
						<th>书名</th>
						<th>作者</th>
						<th>简介</th>
						<th>书籍内容</th>
						<th>所属课程</th>
						<th>是否审核</th>
					</tr>	
					</thead>
					<tbody>

			<c:forEach items="${upList }"	var="bean">		
					<tr>
						<td>${bean.tempId }</td>
						<td>${bean.userId }</td>
						<td>${bean.bName}</td>
						<td>${bean.bAuthor}</td>
						<td class="tdsty">${bean.bInfo}</td>
						<td><a href="temp/${bean.bAttach }"/>${bean.bAttach }</td>
						<td>${bean.bSub }</td>
						<td>${bean.ifCheck}</td>
						<td><a class="btn btn-info" href='javascript:saveIt(${bean.tempId})'>通过审核</a></td>
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