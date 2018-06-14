<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="pl.coderslab.*" import="pl.coderslab.dao.*" import="java.util.List" import="java.util.ArrayList"
     import="java.sql.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<p> Wprowadź zmiany </p>

<% 
	Status status = (Status) session.getAttribute("status");
%>


<form action="/JEE04_Warsztaty4/Status_Edit" method="post">
	<label>Acceptance
		<%
		if (status.getIsAccepted()==true){
		%><input type="checkbox" name="isAcceptedF" value="true" checked><%	
		} else {
		%><input type="checkbox" name="isAcceptedF" value="true"><%	
		}
		%>
	</label><br>
	<label>Accepted repair cost
		<input type="text" name="acceptedRepairCostF" value="<%= status.getAcceptedRepairCost()%>">
	</label><br>
	<label>In repair
		<%
		if (status.getIsRepaired()==true){
		%><input type="checkbox" name="isRepairedF" value="true" checked><%	
		} else {
		%><input type="checkbox" name="isRepairedF" value="true"><%	
		}
		%>
	</label><br>
	<label>Readiness
		<%
		if (status.getIsReady()==true){
		%><input type="checkbox" name="isReadyF" value="true" checked><%	
		} else {
		%><input type="checkbox" name="isReadyF" value="true"><%	
		}
		%>
	</label><br>
	<label>Resignation
		<%
		if (status.getResignation()==true){
		%><input type="checkbox" name="resignationF" value="true" checked><%	
		} else {
		%><input type="checkbox" name="resignationF" value="true"><%	
		}
		%>
	</label><br>
	
	<input type="submit" name="send" value="Send">
</form>

</body>
</html>