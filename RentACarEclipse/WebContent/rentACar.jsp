<%@page import="model.Car"%> 
<%@page import="java.util.ArrayList"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     <form action="CalculateRentCost" method="post">
	 <h1>Available cars</h1> 
	 <label for=chooseACar>Choose a car:</label>
	 	<select name="chooseACar">
		<%ArrayList<Car> cars = (ArrayList<Car>)request.getAttribute("carsNprice"); 
		for(Car s:cars){%>
		<option value="<%=s.getCarName()%>"><p><%=s.getCarName()%> - <%=s.getPrice()%></p></option>
		<%}%> 
		</select> 
		<input type="text" name="rentLength" size="1" maxlength="4">How many days?<br />
		<input type="submit" value="Rent">
	</form>
      
   
</body>
</html>