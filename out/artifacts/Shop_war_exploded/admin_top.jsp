<%@ page import="com.wh.entity.User" %>
<%@ page import="java.lang.annotation.Target" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<div id="header">
	<div class="title"></div>
	<div class="welcome">欢迎您：${user.name}</div>

</div>
<%
	// 权限验证
	if(session.getAttribute("user")==null){
		response.sendRedirect("login.jsp");
		return;
	}
%>
</body>
</html>