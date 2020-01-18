<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student | Account</title>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
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
				<li class="nav-item"><a class="nav-link"
					href="showStudentTeachersPage">Teachers</a></li>
					<li class="nav-item"><a class="nav-link"
					href="showNotificationsPage">Notifications</a></li>
					
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link active"
					href="showStudentAccountPage">Account</a></li>
				<li class="nav-item"><a class="nav-link" href="logOut">Log
						Out</a></li>
			</ul>
		</div>
	</nav>

	<div class="container" style="margin-top: 5px;">
		<div style="background-color: skyblue; color: white;">
			<h2>Your Account Details:</h2>
		</div>
		<h4>FirstName: ${student.firstName}</h4>
		<h4>MiddleName: ${student.middleName}</h4>
		<h4>LastName: ${student.lastName}</h4>
		<h4>address: ${student.address}</h4>
		<h4>PhoneNumber: ${student.phoneNumber}</h4>
		<h4>Birthday: ${student.dob}</h4>
		<h4>Gender:${student.gender}</h4>
		<h4>UserName: ${student.userName}</h4>
		<h4>Password: ${student.password}</h4>
		<a href="#">Edit Account (not available for now)</a>
	</div>
</body>
</html>