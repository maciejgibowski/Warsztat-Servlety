<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="pl.coderslab.*" import="java.util.List" import="java.util.ArrayList"
     import="java.sql.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table><tr> <th>Id</th>
			<th>Marka</th>
			<th>Model</th>
			<th>Rok produkcji</th>
			<th>Numer rejestracyjny</th>
			<th>Data następnego przeglądu</th>
			<th>ID właściciela</th>
   </tr>

<%
List<Vehicle> vehicleList = (List<Vehicle>)session.getAttribute("vehicleList");


for (Vehicle vehicle: vehicleList){
	%><tr><%
	%><td><%out.append(Integer.toString(vehicle.getId()));%></td><%
	%><td><%out.append(vehicle.getBrand());%></td><%
	%><td><%out.append(vehicle.getModel());%></td><%
	%><td><%out.append(vehicle.getYearOfProduction());%></td><%
	%><td><%out.append(vehicle.getRegistrationNumber());%></td><%
	%><td><%out.append(vehicle.getDateOfNextCheckUp().toString());%></td><%
	%><td><%out.append(Integer.toString(vehicle.getCustomer_id()));%></td><%
	
	
	%></tr><%
}
%>
</table> <br>

<form action="/JEE04_Warsztaty4/Vehicle_PreEdit" method="post">

<label>Podaj ID samochodu do edycji
<input type="text" name="id"><br>
</label>
<input type="submit" name="send" value="Send">



</form>
</body>
</html>