<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Edit User Details</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<form action="editUser" >
			<div class="form-group">
				<label for="id">Give User-Id to edit :</label> <input type="number"
					class="form-control" placeholder="Enter Id" name="id" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
			<div class="form-group">
				<label for="name">Edit Name:</label> <input type="text"
					class="form-control" placeholder="Enter Name" name="name">
			</div>
			<div class="form-group">
				<label for="username">Edit User Name:</label> <input type="text"
					class="form-control" placeholder="Enter User Name" name="username">
			</div>
			<div class="form-group">
				<label for="email">Edit Email:</label> <input type="email"
					class="form-control" placeholder="Enter email" name="email">
			</div>
			<div class="form-group">
				<label for="password">Edit Password:</label> <input type="password"
					class="form-control" placeholder="Enter password" name="password">
			</div>
			<div class="form-group">
				<label for="uname">Edit Expiry Date:</label> <input type="date"
					class="form-control" name="expirydate" >
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>


</body>
</html>