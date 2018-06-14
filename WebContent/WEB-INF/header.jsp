<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
		<th><a href="<c:url value="/Home"/>">| Home || </a></th>
		<th><a href="<c:url value="/Employee_Home"/>">Pracownicy || </a></th>
		<th><a href="<c:url value="/Commission_Home"/>">Zlecenia || </a></th>
		<th><a href="<c:url value="/Customer_Home"/>">Klienci || </a></th>
		<th><a href="<c:url value="/Vehicle_Home"/>">Samochody || </a></th>
		<th><a href="<c:url value="/report_1_pre.jsp"/>">Raport roboczogodzin pracowników || </a></th>
		<th><a href="<c:url value="/report_2_pre.jsp"/>">Raport przychodów |</a></th>
</tr>
</table>
</body>
</html>