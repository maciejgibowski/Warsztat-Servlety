<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="WEB-INF/header.jsp" %>
<%
	double value = (double) session.getAttribute("value");
%>
	<table>
		<tr>
			<th>Wartość przychodu</th>
		</tr>
		<tr>
			<td><%= value%></td>
		</tr>
	</table>
<%@include file="WEB-INF/footer.jsp" %>
</body>
</html>