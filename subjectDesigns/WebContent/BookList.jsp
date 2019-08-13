<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2018/12/26
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.io.*,java.sql.*" errorPage="" %>
<%@ page import="util.*, bean.*, java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>个人信息-个人中心</title>
    <link rel="stylesheet" href="css/style.css?v=1" type="text/css">
    <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
    <style>
        @import url('../css/style.css');
    </style>
    <link rel="stylesheet" href="https://cdn.staticfile.org/t1rap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
y
    <script type="text/javascript">
        function turnPage(i) {
            document.frm.cur_page.value = i;   // 跳转页面时，设置i为要跳转的页面，然后提交表单
            document.frm.submit();
        }

    </script>
</head>

<body>

<div id="main">
    <div id="topDiv">
        <p><b>我的信息</b></p>
        <%--<div id="loginInfo">--%>
            <%--欢迎您，<%=(String)session.getAttribute("username") %>，今天是<%=new java.util.Date() %>--%>
            <%--第 <%=100 %> 位用户--%>
            <%--<a href="logout.jsp" >退出系统</a>--%>
        <%--</div>--%>
    </div>
    <div id="leftDiv">
        <a href="index.jsp">首页</a>
        <ul id="nav">
            <li><a href="InformList?user=${userId}">个人信息</a></li>
            <li><a href="BookList?user=${userId}">关注列表</a></li>
            <li><a href="CollectList?userId=${userId}">收藏列表</a></li>
            <li><a href="page3.jsp">书签列表</a></li>
        </ul>
    </div>
    <div id="rightDiv">
        <div id="searchBox">
            <form name="frm" action="FileList">
                文件标题：<input type="text" name="title" value="<c:out value="${title}"></c:out>">
                来源：<input type="text" name="source" value="${(bean.source==null?'':bean.source)}">
                起始时间：<input type="text" name="create_date" value="${(bean.create_date==null?'':bean.create_date)}">
                <%--所在城市：<select name="city">--%>
                <%--<option value="">请选择</option>--%>
                <%--<option value="南昌" <%=("南昌".equals(city)?"selected":"") %>>南昌</option>--%>
                <%--<option value="成都" <%=("成都".equals(city)?"selected":"") %>>成都</option>--%>
                <%--</select>--%>

                <input type="submit" value=" 查找 " />

                <input type="hidden" name="cur_page" value=""> <!-- 增加隐藏变量，记录当前页码 -->
            </form>
        </div>
        <%--<div id="toolbar" style="text-align:right;margin-right:10px;">--%>
            <%--<input type="button" value=" 新增员工 " onclick="add()" />--%>
        <%--</div>--%>
        <div id="dataArea">
            <table width="100%" border="1" style="border-collapse:collapse">
                <tr>
                    <th>序号</th>
                    <th>跳转</th>
                    <th>修改</th>
                </tr>

                <c:forEach items="${list }" var="bean">

                    <tr>
                        <td>${bean.id }</td>
                        <td><img src="${bean.attach}" ></td>
                        <td><a href='FileEdit?id=${bean.id}'>修改</a>
                        <td><a href='FileDelete?id=${bean.id}'>删除 </a>
                    </tr>
                </c:forEach>

            </table>
        </div>
        <div id="pageFooter">
            <label>共${pager.totalPage }页${pager.totalRecord }条数据 ，导航至：  </label>
            <c:forEach var="i" begin="1" end="${pager.totalPage }">
                <button type="button" class='btn <c:if test="${i == pager.curPage}">btn-primary</c:if> btn-default' onclick="turnPage(${i})" > ${i } </button>
            </c:forEach>

        </div>
    </div>
    <div id="bottomDiv">
        2018 版权所有
    </div>
</div>
</body>
</html>
