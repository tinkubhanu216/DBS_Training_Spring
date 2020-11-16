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
	
	<h4>All Records</h4>
	<table border="1px">
		<tr>
			<th>Student Id</th>
			<th>Name</th>
			<th>Branch</th>
			<th>Address</th>
		</tr>
		<c:forEach items="${students}" var="item">
			<tr>
				<td>${item.getId() }</td>
				<td>${item.getName() }</td>
				<td>${item.getBranch() }</td>
				<td>${item.getAddress() }</td>
			</tr>
		</c:forEach>
	</table><br>
	<h4>Create</h4>
	<form action="create" method="get">
		Student Id:<input type="number" name="id"><br><br>
		Name:<input type="text" name="name"><br><br>
		Branch:<input type="text" name="branch"><br><br>
		Address:<input type="text" name="address"><br><br>
		<input type="submit" value="create">
	</form><br>
	<h4>Update</h4>
	<form action="update" method="get">
		Student Id:<input type="number" name="id"><br><br>
		Name:<input type="text" name="name"><br><br>
		Branch:<input type="text" name="branch"><br><br>
		Address:<input type="text" name="address"><br><br>
		<input type="submit" value="update">
	</form><br>
	<h4>Delete</h4>
	<form action="delete" method="get">
		Student Id:<input type="number" name="id"><br><br>
		<input type="submit" value="delete">
	</form><br>
</body>
</html>