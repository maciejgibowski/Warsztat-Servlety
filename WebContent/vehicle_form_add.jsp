<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<p>Wprowadź dane nowego samochodu</p><br>
<form action="/JEE04_Warsztaty4/Vehicle_Add" method="post">

<label>Marka
<input type="text" name="brand"><br>
</label>
<label>Model
<input type="text" name="model"><br>
</label>

<label>Rok produkcji
<input type="text" name="yearOfProduction"><br>
</label>

<label>Numer rejestracyjny
<input type="text" name="registrationNumber"><br>
</label>

<label>Data następnego przeglądu
<input type="date" name="dateOfNextCheckUp"><br>
</label>

<label>ID właściciela
<input type="text" name="customer_id"><br>
</label>


<input type="submit" name="send" value="Send">


</form>

</body>
</html>