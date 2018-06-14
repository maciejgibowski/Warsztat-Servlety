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

<table><tr> <th>Id</th>
			<th>Imię</th>
			<th>Nazwisko</th>
			<th>Data urodzenia</th>
   </tr>

<%
List<Customer> customerList = (List<Customer>)session.getAttribute("customerList");


for (Customer customer: customerList){
	%><tr><%
	%><td><%out.append(Integer.toString(customer.getId()));%></td><%
	%><td><%out.append(customer.getName());%></td><%
	%><td><%out.append(customer.getSurname());%></td><%
	%><td><%out.append(customer.getDateOfBirth().toString());%></td><%	
	%></tr><%
}
%>

</table>

<p>Wybierz akcję:</p>
<p><a href="<c:url value="/customer_form_add.jsp"/>">Dodaj klienta</a></p>
<p><a href="<c:url value="/customer_form_edit_1.jsp"/>">Edytuj klienta</a></p>
<p><a href="<c:url value="/customer_form_remove.jsp"/>">Usuń klienta</a></p>



<%@include file="WEB-INF/footer.jsp" %>




</body>
</html>