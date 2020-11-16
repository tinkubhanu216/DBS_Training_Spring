<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1px">
<tr>
<th>Policy Number</th>
<th>Name</th>
<th>Tensure</th>
<th>Amount</th>
</tr>

	<c:forEach items="${policies}" var="item">
	<tr>
	<td>${item.getPolicyNumber() }</td>
	<td>${item.getName() }</td>
	<td>${item.getTensure() }</td>
	<td>${item.getAmount() }</td>
    	</tr>
	</c:forEach>
	</table>
</body>
</html>