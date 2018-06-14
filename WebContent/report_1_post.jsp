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
			<th>Imię</th>
			<th>Nazwisko</th>
			<th>Ilość roboczogodzin</th>
		</tr>
		<% 
			List <Report1> reportList = (List <Report1>) session.getAttribute("reportList");
		
			for (Report1 report : reportList) {
				%><tr><%
				%><td><%out.append(report.getName());%></td><%
				%><td><%out.append(report.getSurname());%></td><%
				%><td><%out.append(Integer.toString(report.getWorkhours()));%></td><%
				%></tr><%
			}
		%>
	</table>
<%@include file="WEB-INF/footer.jsp" %>
</body>
</html>