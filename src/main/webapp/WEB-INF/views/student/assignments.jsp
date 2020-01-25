<%@page import="org.springframework.ui.Model"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student | Assignments</title>
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
				<li class="nav-item active"><a class="nav-link"
					href="showStudentAssignmentsPage">Assignments</a></li>
				<li class="nav-item"><a class="nav-link"
					href="showStudentTeachersPage">Teachers</a></li>
				<li class="nav-item"><a class="nav-link"
					href="showNotificationsPage?studentId=${student.studentId}">Notifications</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link"
					href="showStudentAccountPage">Account</a></li>
				<li class="nav-item"><a class="nav-link" href="showIndex">Log
						Out</a></li>
			</ul>
		</div>
	</nav>

	<br />
	<div class="container">
		<c:forEach items="${assignmentsOfStudent}" var="mcAssignment">
			<div class="accordion" id="accordionExample">
				<div class="card">
					<div class="card-header" id="headingOne">
						<h2 class="mb-0">
							<button class="btn btn-link" type="button" data-toggle="collapse"
								data-target="#collapseOne" aria-expanded="true"
								aria-controls="collapseOne">
								Topic Of The Assignment: <b>${mcAssignment.topic}</b>
								<p style="font-size: 10px;">from
									${mcAssignment.teacher.firstName}${mcAssignment.teacher.lastName}</p>
							</button>
						</h2>
					</div>

					<div id="collapseOne" class="collapse" aria-labelledby="headingOne"
						data-parent="#accordionExample">
						<form action="submitAssignment">
							<div class="card-body">
								<%
									int counter = 0;
								%>
								<c:forEach items="${mcAssignment.question}" var="mcQuestion">
									<%
										counter++;
									%>
									<h6>${mcQuestion.question}</h6>
									<input type="radio" value="option1" name="selectedOption">${mcQuestion.option1}<input
										type="radio" value="option2" name="selectedOption">${mcQuestion.option2} <input
										type="radio" value="option3" name="selectedOption">${mcQuestion.option3}<input
										type="radio" value="option4" name="selectedOption">${mcQuestion.option4}
									<br>
								</c:forEach>
							</div>
							<input type="hidden" name="assignmentId" value="${mcAssignment.id}">
							<input type="submit" class="btn btn-primary"
								value="submit assignment" style="margin-left: 20px;"> <br />
						</form>
						<br /> <br /> <br />
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>