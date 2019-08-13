<%@ page contentType="text/html; charset=utf-8" language="java" import="java.io.*,java.sql.*" errorPage="" %>
<%@ page import="util.*, bean.*, java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户信息</title>
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
		window.location.href='uploadBook.jsp';
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
					<a class="btn btn-info" href="" >个人信息</a>
					<a class="btn btn-warning" href="logout.jsp" >退出系统</a>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<a href="UserIndex">首页</a>
				<ul class="nav-pills nav-stacked">
					<li class="active">推荐书籍</li>
				</ul>
			</div>
		
			<div class="col-md-10">
				<div id="message" color="red"></div>
				<div>
					<form name="frm" class="form-inline" action="UserIndex">
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
					<button type="button" class="btn btn-info" onclick="add()">上传书籍</button>
				</div>
				<div id="dataArea">
					<table class="table table-hover">
					<thead>
					<tr>
						<th>书ID</th>
						<th>书名</th>
						<th>作者</th>
						<th>简介</th>
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
						<td><a href="">${bean.bookName}</a></td>
						<!-- <td><a href="upload/${bean.bookAttach }"/>${bean.bookAttach }</td> -->
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
	<script type="text/javascript">
    var websocket = null;
    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://localhost:8080/JavaWebSocket/websocket");
    }
    else {
        alert('当前浏览器 Not support websocket')
    }

    //连接发生错误的回调方法
    websocket.onerror = function () {
        setMessageInnerHTML("WebSocket连接发生错误");
    };

    //连接成功建立的回调方法
    websocket.onopen = function () {
        setMessageInnerHTML("欢迎接收广播");
    }

    //接收到消息的回调方法
    websocket.onmessage = function (event) {
        setMessageInnerHTML(event.data);
    }

    //连接关闭的回调方法
    websocket.onclose = function () {
        setMessageInnerHTML("");
    }

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        closeWebSocket();
    }

    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML) {
        document.getElementById('message').innerHTML += innerHTML + '<br/>';
    }

    //关闭WebSocket连接
    function closeWebSocket() {
    	websocket.close();
    	history.back(-1);
    }

    //发送消息
    function send() {
        var message = document.getElementById('text').value;
        websocket.send(message);
    }
</script>
</body>
</html>