<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<%
			out.print("Car added! ");
		%>
	</form>
	<form action="logowanie.jsp" method="post">
		<input type="submit" value="Log out">
	</form>
	<form action="wybor.jsp" method="post">
		<input type="submit" value="Back">
	</form>
</body>
</html>