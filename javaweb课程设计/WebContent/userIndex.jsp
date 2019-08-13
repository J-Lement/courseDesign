<%@ page contentType="text/html; charset=utf-8" language="java" import="java.io.*,java.sql.*" errorPage="" %>
<%@ page import="util.*, bean.*, java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>用户界面</title>
    <link rel="stylesheet" href="./vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="./vendor/font-awesome/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="./css/styles.css">
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
<body class="sidebar-fixed header-fixed">
<marquee><div id="message" ></div></marquee>
<div class="page-wrapper">
    <div class="page-header">
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
    </div>

    <div class="main-container">
        <div class="sidebar">
            <nav class="sidebar-nav">
                <ul class="nav">


                    <div class="card text-white border-0">

                        <li class="nav-title"></li>
                        <li class="nav-item">

                            <table class="table bg-info">
                                <thead>
                                <tr>
                                    <th class="border-0 text-uppercase small font-weight-bold">书名</th>
                                    <th class="border-0 text-uppercase small font-weight-bold">书籍详情</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${BKlist }"	var="bean">
                                    <tr>
                                        <td>${bean.bookName}</td>
                                        <td><a href="CollectAdd?bookId=${bean.bookId }&userId=${sessionScope.userId}">收藏</a></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </li>

                    </div>


                    
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>

        <div class="content">
            <div class="container">
             <form name="frm" action="UserIndex">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body p-0">
                           <div class="card-body">
                           
                           <div class="row">
                                <div class="col-md-3">
                                        <div class="form-group">
                                            <select id="single-select" class="form-control" name="schName">
                                                <option selected disabled style="display: none;" value="">学校</option>
                                                <option value = "">请选择</option>
							<c:forEach items="${listSch }"	var="item">	
								<option value="${item }" <c:if test="${item == schName}">${"selected" }</c:if>>${item }</option>
							</c:forEach>
                                            </select>
                                        </div>
                                </div>
                                <div class="col-md-3">
                                        <div class="form-group">
                                            <select id="single-select" class="form-control" name="majName">
                                                <option selected disabled style="display: none;" value="">专业</option>
                                                <option value = "">请选择</option>
							<c:forEach items="${listMaj }"	var="item">	
								<option value="${item }" <c:if test="${item == majName}">${"selected" }</c:if>>${item }</option>
							</c:forEach>
                                            </select>
                                        </div>
                                </div>
                                <div class="col-md-3">
                                        <div class="form-group">
                                            <select id="single-select" class="form-control" name="subName">
                                                <option selected disabled style="display: none;" value="">课程</option>
                                                <option value = "">请选择</option>
						<c:forEach items="${listSub }"	var="item">	
							<option value="${item }" <c:if test="${item == subName}">${"selected" }</c:if>>${item }</option>
						</c:forEach>
                                            </select>
                                        </div>
                                </div>
                                <div class="my-0">
                                <button type="submit" class="btn btn-primary">查询</button>
                                
                                <button type="button" class="btn btn-info" onclick="add()"> 上传书籍</button>
                                <input type="hidden" name="cur_page" value=""> <!-- 增加隐藏变量，记录当前页码 -->
                                </div>
                                
                          </div>
                          </div>
                                <div class="row p-1">
                                    <div class="col-md-12">
                                        <table class="table">
                                            <thead>
                                            <tr>
                                                <th class="border-0 text-uppercase small font-weight-bold">书名</th>
                                                <th class="border-0 text-uppercase small font-weight-bold">作者</th>
                                                <th class="border-0 text-uppercase small font-weight-bold">简介</th>
                                                <th class="border-0 text-uppercase small font-weight-bold">所属课程</th>
                                                <th class="border-0 text-uppercase small font-weight-bold">书籍详情</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${list }"	var="bean">		
					<tr>	
						<td>${bean.bookName}</td>
						<td>${bean.bookAuthor}</td>
						<td class="tdsty">${bean.bookInfo}</td>
						<td>${bean.bookSub }</td>
						<td><a href="BookInfo?bookId=${bean.bookId }&userId=${sessionScope.userId}">${bean.bookName}</a></td>
						<td><a href="CollectAdd?bookId=${bean.bookId }&userId=${sessionScope.userId}">收藏</a></td>
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
    	document.getElementById('message').innerHTML = "";
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