<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher|assignments</title>
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
				<li class="nav-item active"><a class="nav-link"
					href="showTeacherAssignments">Assignments</a></li>
				<li class="nav-item"><a class="nav-link"
					href="showTeacherStudents">Students</a></li>
				<li class="nav-item"><a class="nav-link"
					href="showTeacherNotifications">Notifications</a></li>
				<li class="nav-item"><a class="nav-link"
					href="showTeacherStudentRequests">Student Requests</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link"
					href="showTeacherAccount">Account</a></li>
				<li class="nav-item"><a class="nav-link" href="logOutTeacher">Log
						Out</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
	
		<p style="color: green;">${assignmentcreatedmessage}</p>
		<p style="color: red;">${notBelong}</p>
		<p style="color: red;">${doesNotExist}</p>
		<p style="color: green;">${questionAdded}</p>
		<p style="color: red;">${maximumNumberError}</p>
		
		<div id="accordion">
			<div class="card">
				<div class="card-header" id="headingOne">
					<h5 class="mb-0">
						<button class="btn btn-link" data-toggle="collapse"
							data-target="#collapseOne" aria-expanded="false"
							aria-controls="collapseOne">Create assignment of type
							multiple choice question.</button>
					</h5>
				</div>
				<div id="collapseOne" class="collapse" aria-labelledby="headingOne"
					data-parent="#accordion">
					<div class="card-body">
						<form action="addMcAssignment" method="post">
							<h5>Enter the topic:</h5>
							<h5>
								<input type="text" name="topic" style="width: 627px">
							</h5>
							<input type="submit" class="btn btn-success"
								value="Create Assignment">
						</form>
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header" id="headingTwo">
					<h5 class="mb-0">
						<button class="btn btn-link collapsed" data-toggle="collapse"
							data-target="#collapseTwo" aria-expanded="true"
							aria-controls="collapseTwo">Insert questions to
							assignment of type multiple choice question.</button>
					</h5>
				</div>
				<div id="collapseTwo" class="collapse show"
					aria-labelledby="headingTwo" data-parent="#accordion">
					<div class="card-body">
						<form action="insertQuestionsToMc">
							<h5>
								Enter Assignment Id: <input type="text" name="assignmentId">
							</h5>
							<hr>

							<h5>Enter the question:</h5>
							<h5>
								<input type="text" name="question" style="width: 627px">
							</h5>
							<h5>
								Option1: <input type="text" name="option1"> Option2: <input
									type="text" name="option2" style="width: 228px">
							</h5>
							<h5>
								Option3: <input type="text" name="option3"> Option4: <input
									type="text" name="option4">
							</h5>
							<h5>
								Correct Option:&nbsp &nbsp <input type="radio" value="Option1"
									name="correctOption">Option1 &nbsp &nbsp<input
									type="radio" value="Option2" name="correctOption">Option2
								&nbsp &nbsp<input type="radio" value="Option3"
									name="correctOption">Option3 &nbsp &nbsp<input
									type="radio" value="Option4" name="correctOption">Option4
							</h5>
							<input type="submit" class="btn btn-primary" value="Add Question">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>