<%@page import="com.oop.model.Movie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Movie.css" />
<meta charset="UTF-8">
<title>Update Movie</title>
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
		<br>
		<h2 class="h2">Update Movie</h2>

		<%
		Movie movie = (Movie) request.getAttribute("movie");
		%>

		<form method="POST" action="UpdateMovieServlet"
			enctype="multipart/form-data">
			<table class="table table-striped table-hover">
				<tr>
					<td>Movie ID</td>
					<td><input type="text" name="movieID" disabled="disabled"
						value="<%=movie.getMovieID()%>" class="form-control" /></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="movieName"
						value="<%=movie.getTitle()%>" class="form-control" /></td>
				</tr>
				<tr>
					<td>genre</td>
					<td><select class="form-select" id="inputGroupSelect01"
						name="genre">
							<option selected><%=movie.getGenre()%></option>
							<option value="Action">Action</option>
							<option value="Romantic">Romantic</option>
							<option value="Sci-Fi">Sci-Fi</option>
							<option value="Thriller">Thriller</option>
							<option value="Crime">Crime</option>
							<option value="Cartoon">Cartoon</option>
					</select></td>
				</tr>
				<tr>
					<td>year</td>
					<td><input type="date" name="year"
						value="<%=movie.getReleaseYear()%>" class="form-control" /></td>
				</tr>
				<tr>
					<td>director</td>
					<td><input type="text" name="director"
						value="<%=movie.getDirector()%>" class="form-control" /></td>
				</tr>
				<tr>
					<td>description</td>
					<td><input type="text" name="description"
						value="<%=movie.getDescription()%>" class="form-control" /></td>
				</tr>
				<tr>
					<td>rating</td>
					<td><input type="text" name="rating"
						value="<%=movie.getRating()%>" class="form-control" /></td>
				</tr>
				<tr>
					<td>language</td>
					<td><input type="text" name="languageg"
						value="<%=movie.getLanguage()%>" class="form-control" /></td>
				</tr>
				<tr>
					<td>poster</td>
					<td><input type="file" name="poster"
						value="<%=movie.getPoster()%>" class="form-control" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="hidden" name="movieID"
						value="<%=movie.getMovieID()%>" /> <input type="hidden"
						name="oldposter" value="<%=movie.getPoster()%>" /> <input
						type="submit" value="Update Movie" class="btn btn-success" />
						<button type="button" class="btn btn-outline-danger"
							data-bs-toggle="modal" data-bs-target="#staticBackdrop">
							<i class="bi bi-layout-text-sidebar-reverse"
								style="font-size: 1.2rem"></i>&nbsp;&nbsp;Delete User
						</button></td>
				</tr>
			</table>
		</form>
	</div>

	<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="staticBackdropLabel">Are you sure
						about removing this user?</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<form method="POST" action="DeleteMovieServlet">
						<input type="hidden" name="movieID"
							value="<%=movie.getMovieID()%>" /> 
						<button type="submit" class="btn btn-outline-danger">
							<i class="bi bi-layout-text-sidebar-reverse"
								style="font-size: 1.2rem"></i>&nbsp;&nbsp;Delete Movie
						</button>
					</form>
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