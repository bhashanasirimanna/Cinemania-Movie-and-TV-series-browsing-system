<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cinemania - Admin Panel</title>
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
		<br> <br> <br>
		<h3 class="fw-bold">
			<i class="bi bi-person-workspace " style="color: #57B400;"></i>&nbsp;&nbsp;Admin
			Dashboard
		</h3>
		<br>
		<div class="row">
			<div class="col-sm-3">
				<div class="card">
					<div class="card-body d-grid">
						<a href="addMovie.jsp" class="btn btn-success"><i
							class="bi bi-plus-square" style="font-size: 1.2rem;"></i>&nbsp;&nbsp;Add
							New Movie</a>
					</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="card">
					<div class="card-body d-grid">
						<form method="POST" action="ListMovieServlet">
							<button type="submit" class="btn btn-success w-100"><i
							class="bi bi-film" style="font-size: 1.2rem"></i>&nbsp;&nbsp;Manage
							Movies</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="card">
					<div class="card-body d-grid">
						<a href="addSeries.jsp" class="btn btn-success"><i
							class="bi bi-plus-square" style="font-size: 1.2rem"
							style="font-size: 1.2rem"></i>&nbsp;&nbsp;Add New TV Series</a>
					</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="card">
					<div class="card-body d-grid">
						<form method="POST" action="ListSeriesServlet">
							<button type="submit" class="btn btn-success w-100"><i
							class="bi bi-camera-reels" style="font-size: 1.2rem"></i>&nbsp;&nbsp;Manage
							TV Series</button>
						</form>
						
					</div>
				</div>
			</div>
		</div>

		<br>

		<div class="row">
			<div class="col-sm-6">
				<div class="card">
					<div class="card-body">
						<i class="bi bi-people-fill"
							style="font-size: 2.5rem; color: #57B400;"></i>
						<h5 class="card-title fw-bold" style="color: #57B400;">Manage
							Users</h5>
						<p class="card-text">Pivotal admin panel feature for
							overseeing, editing, and monitoring user accounts, enhancing
							security and efficiency. content.</p>
						<form method="POST" action="ListUserServlet">
							<button type="submit" class="btn btn-outline-success"><i
							class="bi bi-people-fill" style="font-size: 1.2rem"></i>&nbsp;&nbsp;Manage
							Users</button>
						</form>
						</a>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="card">
					<div class="card-body">
						<i class="bi bi-layout-text-sidebar-reverse"
							style="font-size: 2.5rem; color: #57B400;"></i>
						<h5 class="card-title fw-bold" style="color: #57B400;">Manage
							Reviews</h5>
						<p class="card-text">Moderating and maintaining user-generated
							reviews, ensuring quality and compliance with content guidelines.</p>
						<form method="POST" action="ListSeriesServlet">
							<button type="submit" class="btn btn-outline-success"><i
							class="bi bi-layout-text-sidebar-reverse" style="font-size: 1.2rem"></i>&nbsp;&nbsp;Manage
							Reviews</button>
						</form>
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