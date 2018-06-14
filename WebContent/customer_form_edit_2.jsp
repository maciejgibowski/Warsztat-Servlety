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

<p>Wprowadź nowe dane klienta</p><br>
<form action="/JEE04_Warsztaty4/Customer_Edit" method="post">

<%
Customer changedCustomer = (Customer) session.getAttribute("changedCustomer");

%>

<label>Imię
<input type="text" name="name" value="<%= changedCustomer.getName()%>"><br>
</label>
<label>Nazwisko
<input type="text" name="surname" value="<%= changedCustomer.getSurname()%>"><br>
</label>

<label>Data urodzenia
<input type="date" name="dateOfBirth" value="<%= changedCustomer.getDateOfBirth()%>"><br>
</label>

<input type="submit" name="send" value="Send">

</form>




</body>
</html>