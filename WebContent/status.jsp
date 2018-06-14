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
<table>
<tr>
	<th>col</th>
	<th>col</th>
	<th>col</th>
	<th>col</th>
	<th>col</th>
	<th>col</th>
</tr>

<% 
	Status status = (Status) session.getAttribute("status");

 	%><tr>
 	<td><%out.append(Integer.toString(status.getId()));%></td>
 	<td><%out.append(Boolean.toString(status.getIsAccepted()));%></td>
 	<td><%out.append(Double.toString(status.getAcceptedRepairCost()));%></td>
 	<td><%out.append(Boolean.toString(status.getIsRepaired()));%></td>
 	<td><%out.append(Boolean.toString(status.getIsReady()));%></td>
 	<td><%out.append(Boolean.toString(status.getResignation()));%></td>
 	</tr>

</table>

<p>Wybierz akcję:</p>
<p><a href="<c:url value="/Status_PreEdit?id=${status.getId()}"/>">Edytuj status</a></p>

<%@include file="WEB-INF/footer.jsp" %>
</body>
</html>