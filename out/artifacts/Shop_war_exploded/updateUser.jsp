<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
</head>
<h1 align="center">修改会员信息</h1>
<form action="UpDateUser?action=updateUserById" method="post">
	<table align="center" border="0" cellspacing="0" width="300px" height="300px">
		<input type="hidden" name="id" value="${Admin.id }"/>
		<tr>
			<td>用户名称</td>
			<td><input type="text" name="name" value="${Admin.name }"/></td>
		</tr>
		<tr>
			<td>性别</td>
			<c:if test="${Admin.sex=='男' }">
				<td>
					<input type="radio" name="sex" value="男"  checked="checked"/>男
					<input type="radio" name="sex" value="女" />女
				</td>
			</c:if>
			<c:if test="${Admin.sex=='女' }">
				<td>
					<input type="radio" name="sex" value="男"  />男
					<input type="radio" name="sex" value="女"  checked="checked"/>女
				</td>
			</c:if>

		</tr>
		<tr>
			<td>年龄</td>
			<td><input type="text" name="age" value="${Admin.age }"/></td>
		</tr>
		<tr>
			<td>电话</td>
			<td><input type="text" name="tel" value="${Admin.tel }"/></td>
		</tr>
		<tr>
			<td>地址</td>
			<td><input type="text" name="address" value="${Admin.address }"/></td>
		</tr>
		<tr>
			<td>权限</td>
			<c:if test="${Admin.role=='普通用户' }">
				<td>
					<input type="radio" name="role" value="普通用户"  checked="checked"/>普通用户
					<input type="radio" name="role" value="经理" />经理
				</td>
			</c:if>
			<c:if test="${Admin.role=='经理' }">
				<td>
					<input type="radio" name="role" value="普通用户"  />普通用户
					<input type="radio" name="role" value="经理"  checked="checked"/>经理
				</td>
			</c:if>
		</tr>

		<tr>
			<td colspan="2">
				<input type="submit" class="sub" value="修改" />
				<input type="reset" class="sub" value="重置" />
			</td>
		</tr>
	</table>
</form>
<%
	// 权限验证
	if(session.getAttribute("user")==null){
		response.sendRedirect("login.jsp");
		return;
	}
%>
<%
    String errorInfo = (String)request.getAttribute("msg");
    if(errorInfo != null) {
%>
<script type="text/javascript" language="javascript">
    alert("<%=errorInfo%>");
</script>
<%
    }
%>
</body>
</html>