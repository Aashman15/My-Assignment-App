<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LogIn Page For Student</title>
</head>
<body>
	<h1>Student LogIn Form:</h1>
	<p style="color:red;">${msg}</p>
	<form action="enterStudentHome" method="post">
		User name: <input type="text" name="userName" /><br /> Password: <input
			type="password" name="password"/> <br /> <input type="submit" value="LogIn" />
	</form>
	<p>If you don't have account! click here to signup</p>
	<a href="signUpStudent">Sign Up</a>
</body>
</html>