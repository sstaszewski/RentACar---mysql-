<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form action="AddCar" method="post">
    <input type="text" name="carName">Car Name<br />
    <input type="text" name="price">Price per day<br />
    <input type="submit" value="save">
</form>
<form action="OdczytZPliku" method="post">
	<label for="myfile">Select a file:</label><br />
 	<input type="file" id="myfile" name="myfile"><br />
    <input type="submit" value="Import from file">
</form>
</body>
</html>