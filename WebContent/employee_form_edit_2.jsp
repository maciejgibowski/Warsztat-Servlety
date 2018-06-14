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

<p>Wprowadź nowe dane pracownika</p><br>
<form action="/JEE04_Warsztaty4/Employee_Edit" method="post">

<%
Employee changedEmployee = (Employee) session.getAttribute("changedEmployee");

%>

<label>Imię
<input type="text" name="name" value="<%= changedEmployee.getName()%>"><br>
</label>
<label>Nazwisko
<input type="text" name="surname" value="<%= changedEmployee.getSurname()%>"><br>
</label>

<label>Adres
<input type="text" name="address" value="<%= changedEmployee.getAddress()%>"><br>
</label>

<label>Numer kontaktowy
<input type="text" name="phoneNumber" value="<%= changedEmployee.getPhoneNumber()%>"><br>
</label>

<label>Stawka
<input type="text" name="rate" value="<%= changedEmployee.getWorkhourCost()%>"><br>
</label>

<label>Notatki
<textarea name="notes" rows="4" cols="30"><%= changedEmployee.getNotes()%></textarea><br>
</label>


<input type="submit" name="send" value="Send">




</form>




</body>
</html>