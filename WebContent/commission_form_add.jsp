<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<p>Dodaj nowe zlecenie:</p><br>
<form action="/JEE04_Warsztaty4/Commission_Add" method="post">


<label>Data Przyjęcia
<input type="date" name="dateOfAcceptance"><br>
</label>

<label>Planowana data naprawy
<input type="date" name="plannedDateOfRepair"><br>
</label>

<label>Data naprawy
<input type="date" name="dateOfRepair"><br>
</label>

<label>Pracownik obsługujący zlecenia
<input type="text" name="assignedEmployee"><br>
</label>

<label>Opis problemu
<textarea name="problemDescription"></textarea><br>
</label>

<label>Opis naprawy
<textarea name="repairDescription"></textarea><br>
</label>

<label> Podaj id samochodu
<input type="text" name="vehicle_id"><br>
</label>

<label>Wprowadź koszt naprawy
<input type="text" name="repairCost"><br>
</label>


<label>Wprowadź koszty klienta
<input type="text" name="customerCost"><br>
</label>

<label>Wprowadź koszty części
<input type="text" name="componentsCost"><br>
</label>

<label>Wprowadź ilość godzin
<input type="text" name="amountOfWorkhours"><br>
</label>

<input type="submit" name="send" value="Send">


</form>

</body>
</html>