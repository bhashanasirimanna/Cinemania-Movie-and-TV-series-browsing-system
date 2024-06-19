<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Review</title>
</head>
<body>
	<h1>Add Review</h1>

	<form method="POST" action="AddReviewServlet">
		Show Name: <input type="text" name="showName" /> <br>
		Description:
		<textarea name="description"></textarea>
		<br> Rating: <input type="number" name="rating" /> <br> <br>
		<input type="submit" value="Add Review" />
	</form>

	<form method="POST" action="ListReviewServlet">
		<input type="submit" value="List All Reviews" class="list-button" />
	</form>
	
</body>
</html>