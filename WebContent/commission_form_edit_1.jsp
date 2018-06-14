<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<table><tr>
<th>Col1</th>
<th>Col2</th>
<th>Col3</th>
<th>Col4</th>
<th>Col5</th>
<th>Col6</th>
<th>Col8</th>
<th>Col8</th>
<th>Col9</th>
<th>Col10</th>
<th>Col11</th>
<th>Col12</th>
<th>Col13</th>
<th>Col14</th>


</tr>

<%
List<Commission> commissionList= (List<Commission>)session.getAttribute("CommissionList");

for(Commission commission: commissionList) {
	%><tr><%
	%><td><%out.append(Integer.toString(commission.getId()));%></td><%
	%><td><%out.append(commission.getDateOfAcceptance().toString());%></td><%
	%><td><%out.append(commission.getPlannedDateOfRepair().toString());%></td><%
	%><td><%out.append(Integer.toString(commission.getAssignedEmployee()));%></td><%
	%><td><%out.append(commission.getProblemDescription());%></td><%
	%><td><%out.append(commission.getRepairDescription());%></td><%
	%><td><%out.append(Integer.toString(commission.getStatus_id()));%></td><%
	%><td><%out.append(Integer.toString(commission.getVehicle_id()));%></td><%
	%><td><%out.append(Double.toString(commission.getRepairCost()));%></td><%
	%><td><%out.append(Double.toString(commission.getCustomerCost()));%></td><%
	%><td><%out.append(Double.toString(commission.getComponentsCost()));%></td><%
	
}
%>

</table><br>

<form action="/JEE04_Warsztaty4/Commission_PreEdit" method="post">
<label>Podaj ID zlecenia do edycji
<input type="text" name="id"><br>

</label>
<input type="submit" name="send" value="Send">
</form>

</body>
</html>