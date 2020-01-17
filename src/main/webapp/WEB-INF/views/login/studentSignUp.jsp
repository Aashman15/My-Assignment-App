<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sign Up Page For Student</title>

<!-- Bootstrap -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="bootstrap/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
	
</script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
</head>
<body>
	<div style="margin-left: 30%;">
		<div
			style="background-color: skyblue; text-align: center; border-radius: 5px; width: 500px;">
			<h3 style="color: white;">Student SignUp Form</h3>
		</div>
		<p style="color: green;">${message}</p>
		<p style="color: red; font-size: 20px;">${msg}</p>
		<form action="registerStudent" method="post">
			<div class="row">
				<div class="col">
					<input style="width: 500px;" type="text" class="form-control"
						placeholder="First name" name="firstName">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<input style="width: 500px;" type="text" class="form-control"
						placeholder="Middle Name" name="middleName">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<input style="width: 500px;" type="text" class="form-control"
						placeholder="Last name" name="lastName">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<input style="width: 500px;" type="text" class="form-control"
						placeholder="Address" name="address">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<input style="width: 500px;" type="text" class="form-control"
						placeholder="Phone Number" name="phoneNumber">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<input style="width: 500px;" type="text" class="form-control"
						placeholder="Date Of Birth" name="dob">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<input style="width: 500px;" type="text" class="form-control"
						placeholder="User Name" name="userName">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<input style="width: 500px;" type="password" class="form-control"
						placeholder="Password" name="password">
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
					<input type="submit" class="btn btn-primary" value="Sign Up">
				</div>
			</div>
			<a href="showIndex">Go back to login.</a>
		</form>
	</div>
</body>
</html>