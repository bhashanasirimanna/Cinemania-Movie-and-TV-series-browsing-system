<%@page import="com.oop.model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.UserServiceImpl"%>
<%@page import="com.oop.service.IUserService"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
<link rel="shortcut icon" href="ico.svg" type="image/svg+xml">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
		<div class="container container-fluid">
			<a class="navbar-brand" href="AdminPanel.jsp"> <img
				src="./assets/2.png" alt="" width="200"
				class="d-inline-block align-text-top">
			</a>
			<div class="d-flex">
				<!-- Button trigger modal -->
				<button type="button" class="btn btn-outline-warning"
					data-bs-toggle="modal" data-bs-target="#exampleModal">
					<i class="bi bi-power"></i>&nbsp;&nbsp;Sign Out
				</button>

				<!-- Modal -->
				<div class="modal fade" id="exampleModal" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Do you
									really want to sign out</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-outline-secondary"
									data-bs-dismiss="modal">Close</button>
								<a href="homeView.jsp">
									<button type="button" class="btn btn-outline-danger">Sign
										Out</button>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</nav>

	<div class="container">
		<br> <br>
		<h3 class="">
			<i class="bi bi-people-fill" style="font-size: 2rem; color: #57B400;"></i>&nbsp;&nbsp;Registered
			Users
		</h3>
		<br>
		<table class="table table-striped table-hover">
			<thead style="color: #57B400">
				<tr>
					<th>User ID</th>
					<th>Username</th>
					<th>Password</th>
					<th>Email</th>
					<th>DOB</th>
					<th>Action</th>
				</tr>
			</thead>
			<%
			IUserService iUserService = new UserServiceImpl();
			ArrayList<User> arrayList = iUserService.getUsers();

			for (User user : arrayList) {
			%>
			<tr>
				<td><%=user.getUserID()%></td>
				<td><%=user.getUsername()%></td>
				<td><%=user.getPassword()%></td>
				<td><%=user.getEmail()%></td>
				<td><%=user.getDob()%></td>
				<td>
					<form method="POST" action="GetUserServlet">
						<input type="hidden" name="userID" value="<%=user.getUserID()%>" />
						<input class='btn btn-outline-success' type="submit" value="Select User"
							class="select-button" />
					</form>
				</td>
			</tr>
			<%
			}
			%>
		</table>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>