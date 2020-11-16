<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>Assignment 1</h4>
	<form action="display" method="get">
		<input type="text" name="username"> 
		<input type="submit" value="display">
	</form><br>
	<h4>Assignment 2</h4>
	<p>Valid credentials are 1234 and bhanu</p>
	<form action="displayEmployee" method="get">
		userId:<input type="text" name="id"> 
		Password:<input type="password" name="password"> 
		<input type="submit" value="displayEmployee">
	</form><br>
	<h4>Assignment 3</h4>
	<a href="empsalary/1234/bhanu/20000/10000/5000/5000/15000">Valid User-> url: empsalary/1234/bhanu/20000/10000/5000/5000/15000</a><br>
	<a href="empsalary/1235/raj/20000/10000/5000/5000/15000">Invalid User url: empsalary/1235/raj/20000/10000/5000/5000/15000</a><br>
	<h4>Assignment 4</h4>
	<a href="add">Assignment 4</a><br>
	<h4>Assignment 5</h4>
	<a href="read">Go</a><br><br>
	<!--  <h4>Class work</h4>
	<form action="login" method="get">
		 Name: <input type="text" name="name"/><br/><br/>
		 Password: <input type="password" name="password"/>
		<input type="submit" value="login">
		</form>-->
</body>
</html>