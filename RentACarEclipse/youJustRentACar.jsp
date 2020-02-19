<%@ page import="model.RentedCar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%
%>
<p>Congratulations! </p><br />
<p>You just have rent: <%= request.getParameter("carName2") %></p><br />
<p>for <%= request.getParameter("rentLength") %> days.</p><br />
<p>and it will cost you: <%= request.getParameter("rentPrice") %>.</p><br />
	<form action="logowanie.jsp" method="post">
		<input type="submit" value="Log out">
	</form>
</body>
</html>