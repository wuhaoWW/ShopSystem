<%@ page import="java.lang.annotation.Target" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>超市账单管理系统</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<frameset rows="100,*" cols="*" frameborder="no" border="0" framespacing="0" name="Touble">
	<frame src="admin_top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" />
	<frameset cols="200,*" frameborder="no" border="0" framespacing="0">
		<frame src="admin_left.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" />
		<frame src="admin_bill_list.jsp" name="mainFrame" id="mainFrame" />
	</frameset>
</frameset>
<body>
<%
	String errorInfo = (String)request.getAttribute("information");
	if(errorInfo != null) {
%>
<script type="text/javascript" language="javascript">
	alert("<%=errorInfo%>");
</script>
<%
	}
%>
<%
	// 权限验证
	if(session.getAttribute("user")==null){

		response.sendRedirect("login.jsp");
		return;
	}
%>
</body>
</html>