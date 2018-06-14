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
			<th>Imię</th>
			<th>Nazwisko</th>
			<th>Adres</th>
			<th>Nr kontaktowy</th>
			<th>Notatki</th>
			<th>Stawka za godzinę</th>
   </tr>

<%
List<Employee> employeeList = (List<Employee>)session.getAttribute("activeEmployeeList");


for (Employee employee: employeeList){
	%><tr><%
	%><td><%out.append(Integer.toString(employee.getId()));%></td><%
	%><td><%out.append(employee.getName());%></td><%
	%><td><%out.append(employee.getSurname());%></td><%
	%><td><%out.append(employee.getAddress());%></td><%
	%><td><%out.append(employee.getPhoneNumber());%></td><%
	%><td><%out.append(employee.getNotes());%></td><%
	%><td><%out.append(Double.toString(employee.getWorkhourCost()));%></td><%
	
	
	%></tr><%
}
%>

</table><br>

<form action="http://localhost:8080/JEE04_Warsztaty4/Employee_PreEdit" method="post">

<label>Podaj ID pracownika do edycji
<input type="text" name="id"><br>
</label>
<input type="submit" name="send" value="Send">



</form>

</body>
</html>