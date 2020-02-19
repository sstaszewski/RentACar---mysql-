<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="SprLogowania" method="post">
		<%
			out.print("<input type=text name=login>" + "Login" + "<br />");
			out.print("<input type=password name=password>" + "Password" + "<br />");
		%>
		<input type="submit" value="Log in">
	</form>
	<form action="rejestracja.jsp" method="post">
		<input type="submit" value="Rejestruj nowego użytkownika">
	</form>
</body>
</html>