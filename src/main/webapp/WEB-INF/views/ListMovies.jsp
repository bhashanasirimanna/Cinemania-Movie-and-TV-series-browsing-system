<%@page import="com.oop.model.Movie"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.MovieServiceImpl"%>
<%@page import="com.oop.service.IMovieService"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<title>Cinemania</title>
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
							<h5 class="modal-title" id="exampleModalLabel">Do you really
								want to sign out</h5>
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
		<h3>List of Movies</h3>

		<table class="table table-striped table-hover">
			
			<a href="addMovie.jsp">Add Movie</a>
			<tr>
				<th>Movie ID</th>
				<th>name</th>
				<th>genre</th>
				<th>year</th>
				<th>Director</th>
				<th>description</th>
				<th>rating</th>
				<th>language</th>
				<th>post</th>
				<th>select</th>
			</tr>
			<%
			IMovieService iMovieService = new MovieServiceImpl();
			ArrayList<Movie> arrayList = iMovieService.getMovies();

			for (Movie movie : arrayList) {
			%>
			<tr>
				<td><%=movie.getMovieID()%></td>
				<td><%=movie.getTitle()%></td>
				<td><%=movie.getGenre()%></td>
				<td><%=movie.getReleaseYear()%></td>
				<td><%=movie.getDirector()%></td>
				<td><%=movie.getDescription()%></td>
				<td><%=movie.getRating()%></td>
				<td><%=movie.getLanguage()%></td>
				<td><img src="movieimages/<%=movie.getPoster()%>" width=200
					height=150></td>
				<td>
					<form method="POST" action="GetMovieServlet">
						<input type="hidden" name="movieID"
							value="<%=movie.getMovieID()%>" /> <input type="submit"
							value="Select Movie" class="btn btn-outline-success" />
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