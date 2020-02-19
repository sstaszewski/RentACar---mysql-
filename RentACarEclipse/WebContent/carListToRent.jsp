<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="OdczytZBazysdf" method="post">
		<label for=orderBy>Sort by price:</label> 
		<select name="orderBy">
			<option value="ascending">ascending</option>
			<option value="descending">descending</option>
		</select> 
		<input type="submit" value="Show list">
	</form>
</body>
</html>