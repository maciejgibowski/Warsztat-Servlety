<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<p>Wprowadź dane nowego pracownika</p><br>
<form action="/JEE04_Warsztaty4/Employee_Web_Add" method="post">

<label>Imię
<input type="text" name="name"><br>
</label>
<label>Nazwisko
<input type="text" name="surname"><br>
</label>

<label>Adres
<input type="text" name="address"><br>
</label>

<label>Numer kontaktowy
<input type="text" name="phoneNumber"><br>
</label>

<label>Stawka
<input type="text" name="rate"><br>
</label>

<label>Notatki
<textarea name="notes" rows="4" cols="30" placeholder="Miejsce na notatki"></textarea><br>
</label>


<input type="submit" name="send" value="Send">


</form>

</body>
</html>