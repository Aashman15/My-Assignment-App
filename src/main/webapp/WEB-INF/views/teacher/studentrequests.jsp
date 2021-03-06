<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher | StudentRequests</title>
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
				<li class="nav-item active"><a class="nav-link"
					href="showTeacherStudentRequests">Student Requests</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link"
					href="showTeacherAccount">Account</a></li>
				<li class="nav-item"><a class="nav-link" href="logOutTeacher">Log Out</a></li>
			</ul>
		</div>
	</nav>

	<div class="container" style="padding: 10px;">
		<div
			style="background-color: black; color: white; border-radius: 5px; padding: 10px;">
			<h2>Your all student requests.</h2>
			<p>Please try to accept all. Share your knowledge with all!</p>
		</div>
		<p style="color: green;">${studentAddedMessage}</p>
		<c:forEach items="${allStudentRequests}" var="sr">
			<div
				style="background-color: skyblue; color: white; margin-top: 5px; border-radius: 5px; padding: 10px;">
				<h5>${sr.firstName}${sr.middleName} ${sr.lastName}</h5>
				<p>
					<b>More Details:</b><br> Student Id: ${sr.studentId}<br>
					Student UserName: ${sr.userName}
				</p>
				<a
					href="addStudentToList?studentId=${sr.studentId}&activeTeacher=${activeTeacher}"><input
					class="btn btn-primary" type="submit" value="add to list"></a>
				<hr>
			</div>
		</c:forEach>
	</div>
</body>
</html>