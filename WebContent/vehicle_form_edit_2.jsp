<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="pl.coderslab.*" import="pl.coderslab.dao.*" import="java.util.List" import="java.util.ArrayList"
     import="java.sql.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<p>Wprowadź nowe dane samochodu</p><br>
<form action="/JEE04_Warsztaty4/Vehicle_Edit" method="post">

<% 
	Vehicle changedVehicle = (Vehicle) session.getAttribute("changedVehicle");
%>

<label>Marka
<input type="text" name="brand" value="<%= changedVehicle.getBrand()%>"><br>
</label>
<label>Model
<input type="text" name="model" value="<%= changedVehicle.getModel()%>"><br>
</label>

<label>Rok produkcji
<input type="text" name="yearOfProduction" value="<%= changedVehicle.getYearOfProduction()%>"><br>
</label>

<label>Numer rejestracyjny
<input type="text" name="registrationNumber" value="<%= changedVehicle.getRegistrationNumber()%>"><br>
</label>

<label>Data następnego przeglądu
<input type="date" name="dateOfNextCheckUp" value="<%= changedVehicle.getDateOfNextCheckUp()%>"><br>
</label>

<label>ID właściciela
<input type="text" name="customer_id" value="<%= changedVehicle.getCustomer_id()%>"><br>
</label>


<input type="submit" name="send" value="Send">


</form>

</body>
</html>