<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
</head>
<body>
	<h2 class="h2">Add User Page</h2>
	<br>
	<br>

	<form method="POST" action="AddUserServlet">
		<table>

			<tr>
				<td>Username</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email" name="email" /></td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td><input type="date" name="dob" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add User"
					class="add-button" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="reset" value="Reset"
					class="reset-button" /></td>
			</tr>
		</table>
	</form>

	
</body>
</html>