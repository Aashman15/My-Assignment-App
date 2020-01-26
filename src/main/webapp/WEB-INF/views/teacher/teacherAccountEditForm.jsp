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

	<div class="container" style="margin-left: 30%;">
		<div
			style="background-color: skyblue; text-align: center; border-radius: 5px; width: 500px;">
			<h3 style="color: white;">Edit your account here.</h3>
		</div>
		<form>
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
		</form>
	</div>

</body>
</html>