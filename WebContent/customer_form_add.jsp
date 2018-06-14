<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>Wprowadź dane nowego klienta</p><br>
<form action="/JEE04_Warsztaty4/Customer_Add" method="post">

<label>Imię
<input type="text" name="name"><br>
</label>
<label>Nazwisko
<input type="text" name="surname"><br>
</label>

<label>Data urodzenia
<input type="date" name="dateOfBirth"><br>
</label>



<input type="submit" name="send" value="Send">
</body>
</html>