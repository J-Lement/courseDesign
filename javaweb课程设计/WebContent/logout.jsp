<%@ page contentType="text/html; charset=utf-8" language="java" import="java.io.*,java.util.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>request对象的常见方法的应用。</title>
</head>

<body>
<%
	session.removeAttribute("username");
	//session.invalidate();
	response.sendRedirect("login.jsp");
%>
</body>
</html>