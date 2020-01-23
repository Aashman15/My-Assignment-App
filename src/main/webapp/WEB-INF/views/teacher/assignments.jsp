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
		<div
			style="background-color: skyblue; color: white; margin-top: 10px; padding: 10px; height: 120%;">
			<h3>Create assignment of type multiple choice question:</h3>
		</div>
		<br>
		
		
		<form action="addMcAssignment" method="post">
			<h5>Enter the topic:</h5>
			<h5>
				<input type="text" name="topic" style="width: 627px">
			</h5>
			<hr>
			<div>
				<h5>Enter the question:</h5>
				<h5>
					<input type="text" name="question" style="width: 627px">
				</h5>
				<h5>
					Option1: <input type="text" name="question.option1">
					Option2: <input type="text" name="question.option2"
						style="width: 228px">
				</h5>
				<h5>
					Option3: <input type="text" name="question.option3">
					Option4: <input type="text" name="question.option4">
				</h5>
				<h5>
					Correct Option:&nbsp &nbsp <input type="radio" value="Option1"
						name="correctOption">Option1 &nbsp &nbsp<input type="radio"
						value="Option2" name="correctOption">Option2 &nbsp &nbsp<input
						type="radio" value="Option3" name="correctOption">Option3 &nbsp &nbsp<input
						type="radio" value="Option4" name="correctOption">Option4
				</h5>
			</div>
			<h5>
				Add Next?
				<button class="btn btn-primary">Yes</button>
				<button class="btn btn-danger">No</button>
			</h5>
			
			
			<input type="submit" class="btn btn-success" value="Submit">
		</form>
	</div>
</body>
</html>