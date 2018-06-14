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
	<p>Podaj daty od-do<p>
	<form action="/JEE04_Warsztaty4/Report1" method="post">
		<label>Data początkowa
			<input type="date" name="fromDate">
		</label><br>
		<label>Data końcowa
			<input type="date" name="toDate">
		</label><br>
		<input type="submit" name="send" value="Send">
	</form>
	<%@include file="WEB-INF/footer.jsp" %>
</body>
</html>