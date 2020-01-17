<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>My Assignment Application</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<style>
img.image {
	height: 100%;
	width: 100%;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
	
</script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body background="images/onlineHomework.png">

	<!-- navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">Grihakarya</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> I am a </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#" data-toggle="modal"
							data-target="#modalForStudentLogIn">student.</a> <a
							class="dropdown-item" href="#" data-toggle="modal"
							data-target="#modalForTeacherLogIn">teacher.</a>
					</div></li>
			</ul>
		</div>
	</nav>

	<p style="color: red;">${msg}</p>

	<!-- modal for student login -->
	<div class="modal fade" id="modalForStudentLogIn">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" style="background-color: skyblue;">
					<h1>Log In</h1>
				</div>
				<div class="modal-body">
					<form action="enterStudentHome" method="post">
						<div class="form-group">
							<label>User Name</label> <input type="text" class="form-control"
								placeholder="Enter User Name" name="userName"> <small
								id="emailHelp" class="form-text text-muted">We'll never
								share your user name with anyone else.</small>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Password</label> <input
								type="password" class="form-control" id="exampleInputPassword1"
								placeholder="Password" name="password">
						</div>
						<button type="submit" class="btn btn-primary">LogIn</button>
					</form>
					<p>If you don't have account! click here to signup</p>
					<a href="signUpStudent">Sign Up</a>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
				</div>
			</div>
		</div>
	</div>

	<!-- modal for teacher login -->
	<div class="modal fade" id="modalForTeacherLogIn">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" style="background-color: skyblue;">
					<h1>Log In</h1>
				</div>
				<div class="modal-body">
					<form action="enterTeacherHome" method="post">
						<div class="form-group">
							<label>User Name</label> <input type="text" class="form-control"
								placeholder="Enter User Name" name="username"> <small
								id="emailHelp" class="form-text text-muted">We'll never
								share your user name with anyone else.</small>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Password</label> <input
								type="password" class="form-control" id="exampleInputPassword1"
								placeholder="Password" name="password">
						</div>
						<button type="submit" class="btn btn-primary">LogIn</button>
					</form>
					<p>If you don't have account! please sign up</p>
					<a href="signUpTeacher">Sign Up</a>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>