<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="pl.coderslab.*" import="java.util.List" import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table><tr> <th>Id</th>
			<th>Data przyjęcia</th>
			<th>Planowane rozpoczęcie naprawy</th>
			<th>Data naprawy</th>
			<th>Przypisany pracownik</th>
			<th>Opis problemu</th>
			<th>Opis naprawy</th>
			<th>Status</th>
			<th>ID auta</th>
			<th>Koszt naprawy</th>
			<th>Koszt naprawy dla klienta</th>
			<th>Koszt części</th>
			<th>Koszt pracownika</th>
			<th>Ilość roboczogodzin</th>
   </tr>
<%
 List<Commission> CommissionList = (List<Commission>)session.getAttribute("CommissionList");
for(Commission commission: CommissionList) {
	%><tr><%
	%><td><%out.append(Integer.toString(commission.getId()));%></td><%
	%><td><%out.append(commission.getDateOfAcceptance().toString());%></td><%
	%><td><%out.append(commission.getPlannedDateOfRepair().toString());%></td><%
	%><td><%out.append(commission.getDateOfRepair().toString());%></td><%
	%><td><%out.append(Integer.toString(commission.getAssignedEmployee()));%></td><%
	%><td><%out.append(commission.getProblemDescription());%></td><%
	%><td><%out.append(commission.getRepairDescription());%></td><%
	%><td><%out.append(Integer.toString(commission.getStatus_id()));%></td><%
	%><td><%out.append(Integer.toString(commission.getVehicle_id()));%></td><%
	%><td><%out.append(Double.toString(commission.getRepairCost()));%></td><%
	%><td><%out.append(Double.toString(commission.getCustomerCost()));%></td><%
	%><td><%out.append(Double.toString(commission.getComponentsCost()));%></td><%
	%><td><%out.append(Double.toString(commission.getWorkhour_cost()));%></td><%
	%><td><%out.append(Double.toString(commission.getAmountOfWorkhours()));%></td></tr><%
}%>

</table><br>

<form action="/JEE04_Warsztaty4/Commission_Remove" method="post">

<label>Podaj ID zlecenia do usunięcia
<input type="text" name="id"><br>
</label>
<input type="submit" name="send" value="Send">
</form>
</body>
</html>