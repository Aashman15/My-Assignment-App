<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher | Account</title>
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
				<li class="nav-item"><a class="nav-link" href="showTeacherHome">Home
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="showTeacherAssignments">Assignments</a></li>
				<li class="nav-item"><a class="nav-link"
					href="showTeacherStudents">Students</a></li>
				<li class="nav-item"><a class="nav-link"
					href="showTeacherNotifications">Notifications</a></li>
				<li class="nav-item"><a class="nav-link"
					href="showTeacherStudentRequests">Student Requests</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link"
					href="showTeacherAccount">Account</a></li>
				<li class="nav-item"><a class="nav-link" href="logOutTeacher">Log
						Out</a></li>
			</ul>
		</div>
	</nav>
	<div class="container" style="margin-top: 5px;">
		<div
			style="background-color: skyblue; color: white; margin-top: 10px; padding: 10px; height: 120%;">
			<h2>Account Details:</h2>
		</div>
		<h4>FirstName: ${LoggedInTeacher.firstName}</h4>
		<h4>MiddleName: ${LoggedInTeacher.middleName}</h4>
		<h4>LastName: ${LoggedInTeacher.lastName}</h4>
		<h4>address: ${LoggedInTeacher.address}</h4>
		<h4>PhoneNumber: ${LoggedInTeacher.phoneNumber}</h4>
		<h4>Birthday: ${LoggedInTeacher.dob}</h4>
		<h4>Gender:${LoggedInTeacher.gender}</h4>
		<h4>UserName: ${LoggedInTeacher.userName}</h4>
		<h4>Password: ${LoggedInTeacher.password}</h4>
		<a href="editTeacher">
			<button class="btn btn-primary">Edit Account</button>
		</a>
	</div>

</body>
</html>