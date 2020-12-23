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
		<form action="editBook">
			<div class="form-group">
				<label for="id">Give Book-Id to edit :</label> <input type="number"
					class="form-control" placeholder="Enter Book Id" name="id" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
			<div class="form-group">
				<label for="name">Edit Title:</label> <input type="text"
					class="form-control" placeholder="Enter Title" name="title">
				<div class="form-group">
					<label for="uname">Edit Book Year:</label> <input type="number"
						max="2020" class="form-control" placeholder="Enter Year"
						name="bookyear">
				</div>
				<div class="form-group">
					<label for="uname">Edit Book ISBN No:</label> <input type="number"
						class="form-control" placeholder="Enter ISBN No" name="isbnno">
				</div>
				<div class="form-group">
					<label for="uname">Edit Books Available:</label> <input
						type="number" class="form-control"
						placeholder="Enter Books Available" name="bookavailable">
				</div>
				<div class="form-group">
					<label for="uname">Edit Author Name:</label> <input type="text"
						class="form-control" placeholder="Enter Author Name"
						name="authorname">
				</div>
				<div class="form-group">
					<label for="uname">Edit Publisher Name:</label> <input type="text"
						class="form-control" placeholder="Enter Publisher Name"
						name="publishername">
				</div>

				<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>


</body>
</html>