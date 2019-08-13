<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Cache-Control" content="no-cache">
	<meta http-equiv="Expires" content="0">
	<title>参考书推荐系统登录</title>
	<link href="css/login.css" type="text/css" rel="stylesheet">
</head>
<body>

<div class="login">
	<div class="message">登录界面</div>
	<div id="darkbannerwrap"></div>

	<form method="post" action="Check">
		<input name="action" value="login" type="hidden">
		<input name="userId" placeholder="用户名" required="" type="text" value="${userId}">
		<hr class="hr15">
		<input name="password" placeholder="密码" required="" type="password" value="${password}">
		<hr class="hr15">
		<table>
			<tr>
			<td><label class="form-label">用户类型：</label></td>
			<td>
				<select name="userType" class="form-control" class="select" >
			<option value="">请选择</option>
			<option value="学生">学生</option>
			<option value="管理员">管理员</option>
			</select></td>
			</tr>
		</table>
		<hr class="hr15">
		<input value="登录" style="width:100%;" type="submit">
		<hr class="hr20">
		<!-- 帮助 <a onClick="alert('请联系管理员')">忘记密码</a> -->
	</form>


</div>



</body>
</html>