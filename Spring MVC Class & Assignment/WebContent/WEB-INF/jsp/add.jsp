<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="addpolicy" method="get">
		Policy Number:<input type="number" name="policyNumber"><br><br>
		Name:<input type="text" name="name"><br><br>
		Tensure:<input type="number" name="tensure"><br><br>
		Amount:<input type="number" name="amount"><br><br>
		<input type="submit" value="addpolicy">
	</form><br><br>
	<a href="displaypolicies">View Users</a>
</body>
</html>