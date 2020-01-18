<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student | Teachers</title>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	
<style>
   table{
   font-size:150%;
   }
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">Grihakarya</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="showStudentHome">Home
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="showStudentAssignmentsPage">Assignments</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="showStudentTeachersPage">Teachers</a></li>
					<li class="nav-item"><a class="nav-link"
					href="showNotificationsPage">Notifications</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link"
					href="showStudentAccountPage">Account</a></li>
				<li class="nav-item"><a class="nav-link" href="showIndex">Log
						Out</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
	<div style="color:skyblue; margin-left:20%;">
	   <h2>All Teachers &nbsp &nbsp<a href="#" style="font-size:11px;">view my teachers</a></h2>
	</div>
		<table>
			<tr style="background-color:skyblue; font-size:150%;">
				<th style="width:50%;">Full Name</th>
				<th style="width:30%;">Number</th>
				<th></th>
			</tr>
			<c:forEach items="${teacher}" var="teacher">
				<tr>
					<td>${teacher.firstName}${teacher.middleName}
						${teacher.lastName}</td>
					<td>${teacher.phoneNumber}</td>
					<td style="font-size:16px;"><a href="#">Be ${teacher.firstName}'s Student</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>