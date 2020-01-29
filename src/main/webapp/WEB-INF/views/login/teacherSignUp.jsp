<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sign Up Page For Teacher</title>

<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<!-- Jquery -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>



</head>
<body>
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
				<li class="nav-item"><a class="nav-link" href="showIndex"
					role="button">Home</a></li>
			</ul>
		</div>
	</nav>

	<div style="margin-left: 30%;">
		<br>
		<div
			style="padding-top: 4px; height: 50px; background-color: skyblue; text-align: center; border-radius: 5px; width: 500px;">
			<h3 style="color: white;">Teacher Sign Up Form</h3>
		</div>
		<p style="color: green;">${message}</p>
		<p style="color: red; font-size: 20px;">${msg}</p>
		<form action="registerTeacher" method="post">
			<div class="row">
				<div class="col">
					<label>First Name</label> <input style="width: 500px;" type="text"
						class="form-control" placeholder="First name" name="firstName"
						required="required">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label>Middle Name</label> <input style="width: 500px;" type="text"
						class="form-control" placeholder="Middle Name" name="middleName">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label>Last Name</label> <input style="width: 500px;" type="text"
						class="form-control" placeholder="Last name" name="lastName"
						required="required">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label>Address Name</label> <input style="width: 500px;"
						type="text" class="form-control" placeholder="Address"
						name="address" required="required">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label>Phone Number</label> <input style="width: 500px;"
						type="text" class="form-control" placeholder="Phone Number"
						name="phoneNumber" required="required">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label>Birthday</label> <input style="width: 500px;" type="date"
						class="form-control" placeholder="Date Of Birth" name="dob"
						required="required" max="2018-00-00" min="1918-00-00">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label>User Name</label> <input style="width: 500px;" type="text"
						class="form-control" placeholder="User Name" name="userName"
						required="required">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label>Password Name</label> <input style="width: 500px;"
						type="password" class="form-control" placeholder="Password"
						name="password" required="required">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					Gender: <input type="radio" name="gender" value="male"
						required="required">Male <input type="radio" name="gender"
						value="female" required="required">Female <input
						type="radio" name="gender" value="other" required="required">Other
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<input type="submit" class="btn btn-primary" value="Sign Up">
				</div>
			</div>
			<br> <a href="showIndex">Go back to login.</a>
		</form>
		<br> <br>
	</div>
</body>
</html>