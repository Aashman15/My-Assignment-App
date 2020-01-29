<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit teacher account</title>
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
					href="showNotificationsPage?studentId=${student.studentId}">Notifications</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link"
					href="showStudentAccountPage">Account</a></li>
				<li class="nav-item"><a class="nav-link" href="showIndex">Log
						Out</a></li>
			</ul>
		</div>
	</nav>

	<div class="container" style="margin-left: 30%;">
		<br>
		<p style="color: green;">${msg}</p>
		<div
			style="background-color: skyblue; text-align: center; border-radius: 5px; width: 500px;">
			<h3 style="color: white; height: 50px; padding-top: 5px;">Edit
				your account here.</h3>
		</div>
		<form action="editTeacher" method="post">
			<div class="row">
				<div class="col">
					<label>First Name</label> <input style="width: 500px;" type="text"
						class="form-control" placeholder="First name" name="firstName"
						value="${teacherForUpdate.firstName}">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label>Middle Name</label> <input style="width: 500px;" type="text"
						class="form-control" placeholder="Middle Name" name="middleName"
						value="${teacherForUpdate.middleName}">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label>Last Name</label> <input style="width: 500px;" type="text"
						class="form-control" placeholder="Last name" name="lastName"
						value="${teacherForUpdate.lastName}">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label>Address</label> <input style="width: 500px;" type="text"
						class="form-control" placeholder="Address" name="address"
						value="${teacherForUpdate.address}">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label>Phone Number</label> <input style="width: 500px;"
						type="text" class="form-control" placeholder="Phone Number"
						name="phoneNumber" value="${teacherForUpdate.phoneNumber}">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label>Birthday</label> <input style="width: 500px;" type="date"
						class="form-control" placeholder="Date Of Birth" name="dob"
						value="${teacherForUpdate.dob}" max="2018-00-00" min="1918-00-00">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label>User Name</label> <input style="width: 500px;" type="text"
						class="form-control" placeholder="User Name" name="userName"
						value="${teacherForUpdate.userName}" readonly="readonly">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label>Password</label> <input style="width: 500px;"
						type="password" class="form-control" placeholder="Password"
						name="password" value="${teacherForUpdate.password}">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					Gender: <input type="radio" name="gender" value="male">Male
					<input type="radio" name="gender" value="female">Female <input
						type="radio" name="gender" value="other">Other
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<input type="submit" class="btn btn-primary" value="Update">
				</div>
			</div>
		</form>
	</div>
</body>
</html>