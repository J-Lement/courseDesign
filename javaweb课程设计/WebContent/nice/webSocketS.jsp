<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Java后端WebSocket的Tomcat实现</title>
<link rel="stylesheet" href="css/style.css?v=1" type="text/css">
<link rel="stylesheet" href="css/bootstrap.css" type="text/css">
</head>
<body>
    Welcome<br/><input class="form-control" id="text" type="text"/>
    <button class="btn btn-info" onclick="send()">发送广播</button>
    <button class="btn btn-info" onclick="closeWebSocket()">关闭广播</button>
    <hr/>
    <marquee>使用marquee标签实现信息滚动</marquee>
    <div id="message"></div>
</body>

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
        setMessageInnerHTML("连接成功");
    }

    //接收到消息的回调方法
    websocket.onmessage = function (event) {
        setMessageInnerHTML(event.data);
    }

    //连接关闭的回调方法
    websocket.onclose = function () {
        setMessageInnerHTML("WebSocket连接关闭");
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
</html>