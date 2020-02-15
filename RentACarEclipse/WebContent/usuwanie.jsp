<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form action="Usun" method="post">
    <input type="text" name="lastName">Last Name<br />
    <%
        out.println("or");

    %>
    <br /><input type="text" name="numerek">Customer ID<br />
    <input type="submit" value="Delete">
</form>
</body>
</html>