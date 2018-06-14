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

<p>Wprowadź nowe zlecenia</p><br>
<form action="/JEE04_Warsztaty4/Commission_Edit" method="post">

<%
Commission changedCommission = (Commission) session.getAttribute("changedCommission");

%>

<label>Data przyjęcia
<input type="date" name="dateOfAcceptanceF" value="<%= changedCommission.getDateOfAcceptance()%>"><br>
</label>
<label>Planowana data naprawy
<input type="date" name="plannedDateOfRepairF" value="<%= changedCommission.getPlannedDateOfRepair()%>"><br>
</label>

<label>Data naprawy
<input type="date" name="dateOfRepairF" value="<%= changedCommission.getDateOfRepair()%>"><br>
</label>

<label>Wyznaczony pracownik
<input type="text" name="assignedEmployeeF" value="<%= changedCommission.getAssignedEmployee()%>"><br>
</label>

<label>Opis problemu
<textarea name="problemNotesF" rows="4" cols="30"><%= changedCommission.getProblemDescription()%></textarea><br>
</label>

<label>Opis naprawy
<textarea name="repairNotesF" rows="4" cols="30"><%= changedCommission.getRepairDescription()%></textarea><br>
</label>

<label>Status_id
<input type="hidden" name="status_idF" value="<%= changedCommission.getStatus_id()%>"><br>
</label>

<label>Vehicle_id
<input type="text" name="vehicle_idF" value="<%= changedCommission.getVehicle_id()%>"><br>
</label>

<label>Koszty naprawy
<input type="text" name="repairCostF" value="<%= changedCommission.getRepairCost()%>"><br>
</label>

<label>Do zapłaty
<input type="text" name="customerCostF" value="<%= changedCommission.getCustomerCost()%>"><br>
</label>

<label>Koszty części
<input type="text" name="componentsCostF" value="<%= changedCommission.getComponentsCost()%>"><br>
</label>

<label>Koszty RBH
<input type="text" name="workhour_costF" value="<%= changedCommission.getWorkhour_cost()%>"><br>
</label>

<label>Ilość godzin
<input type="text" name="amountOfWorkhoursF" value="<%= changedCommission.getAmountOfWorkhours()%>"><br>
</label>


<input type="submit" name="send" value="Send">

</form>

</body>
</html>