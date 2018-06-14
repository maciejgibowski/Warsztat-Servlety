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

<%@include file="WEB-INF/header.jsp" %>

<table><tr> <th>col</th>
			<th>col</th>
			<th>col</th>
			<th>col</th>
			<th>col</th>
			<th>col</th>
			<th>col</th>
			<th>col</th>
			<th>col</th>
			<th>col</th>
			<th>col</th>
			<th>col</th>
			<th>col</th>
			<th>col</th>
			<th>col</th>
			<th>col</th>
			<th>col</th>
			<th>Link do zlecenia</th>
			<th>Link do statusu</th>
   </tr>

<%
List<Commission> commissionList = (List<Commission>)session.getAttribute("CommissionList");

for (Commission commission: commissionList){
	String id = Integer.toString(commission.getId());
	String sID = Integer.toString(commission.getStatus_id());
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
	%><td><%out.append(Double.toString(commission.getAmountOfWorkhours()));%></td><%
	%><td> <a href="<c:url value="/Commission_Single"><c:param name="id" value="<%= id%>"/></c:url>">Wyświetl zlecenie</a></td><%
	%><td> <a href="<c:url value="/Status"><c:param name="id" value="<%= sID%>"/></c:url>">Wyświetl status</a></td><%
	
	
	
	%></tr><%
}
%>

</table>

<p>Wybierz akcję:</p>
<p><a href="<c:url value="/commission_form_add.jsp"/>">Dodaj zlecenie</a></p>
<p><a href="<c:url value="/commission_form_edit_1.jsp"/>">Edytuj zlecenie</a></p>
<p><a href="<c:url value="/commission_form_remove.jsp"/>">Usuń zlecenie</a></p>



<%@include file="WEB-INF/footer.jsp" %>




</body>
</html>