<%@page import="com.oop.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User</title>
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
			<a class="navbar-brand" href="./card.html"> <img
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
								<button type="button" class="btn btn-outline-danger">Sign
									Out</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</nav>

	<div class="container">
		<br> <br> <br>
		<div class="card">
			<div class="card-body">
				<h3 class="">
					<i class="bi bi-person-circle" style="color: #57B400;"></i>&nbsp;&nbsp;Update
					User
				</h3>
				<br>
				<%
				User user = (User) request.getAttribute("user");
				%>
				<form class="row g-3" method="POST" action="UpdateUserServlet">
					<div class="col-md-4">
						<label for="movieTitle" class="form-label">User ID</label> <input
							type="text" name="userID" class="form-control" id="mTitle"
							value="<%=user.getUserID()%>" disabled>
					</div>

					<div class="col-md-4">
						<label for="inputRelease" class="form-label">Userame</label> <input
							type="text" class="form-control" id="inputPassword4"
							value="<%=user.getUsername()%>" name="username">
					</div>
					<div class="col-md-4">
						<label for="inputDirector" class="form-label">Password</label> <input
							type="text" class="form-control" id="inputAddress"
							value="<%=user.getPassword()%>" name="password">
					</div>
					<div class="col-md-4">
						<label for="inputLanguage" class="form-label">Email</label> <input
							type="email" class="form-control" id="inputAddress2"
							value="<%=user.getEmail()%>" name="email">
					</div>
					<div class="col-md-4">
						<label for="inputDuration" class="form-label">Date of
							Birth</label> <input type="date" class="form-control" id="inputCity"
							name="dob" value="<%=user.getDob()%>" />
					</div>

					<div class="col-12">
						<input type="hidden" name="userID" value="<%=user.getUserID()%>" />
						<button type="submit" class="btn btn-success">
							<i class="bi bi bi-check-circle-fill" style="font-size: 1.2rem"></i>&nbsp;&nbsp;Update
							User
						</button>
						<button type="reset" class="btn btn-warning">
							<i class="bi bi-arrow-repeat" style="font-size: 1.2rem"></i>&nbsp;&nbsp;Reset
						</button>
					</div>
				</form>
				<br>

				<!-- Button trigger modal -->
				<button type="button" class="btn btn-outline-danger" data-bs-toggle="modal"
					data-bs-target="#staticBackdrop"><i class="bi bi-layout-text-sidebar-reverse"
											style="font-size: 1.2rem"></i>&nbsp;&nbsp;Delete User</button>

				<!-- Modal -->
				<div class="modal fade" id="staticBackdrop"
					data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
					aria-labelledby="staticBackdropLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="staticBackdropLabel">Are you sure about removing this user?</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">Close</button>
								<form method="POST" action="DeleteUserServlet">
									<input type="hidden" name="userID"
										value="<%=user.getUserID()%>" />
									<button type="submit" class="btn btn-outline-danger">
										<i class="bi bi-layout-text-sidebar-reverse"
											style="font-size: 1.2rem"></i>&nbsp;&nbsp;Delete User
									</button>
								</form>
							</div>
						</div>
					</div>
				</div>




			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>



</body>
</html>