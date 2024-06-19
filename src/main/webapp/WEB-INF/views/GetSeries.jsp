<%@page import="com.oop.model.Series"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Series</title>
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
		<h2 class="h2">Update Series</h2>
		<br>
		<%
		Series series = (Series) request.getAttribute("series");
		%>

		<form method="POST" action="UpdateSeriesServlet"
			enctype="multipart/form-data">
			<table class="table table-striped table-hover">
				<tr>
					<td>Series ID</td>
					<td><input type="text" name="seriesID" disabled="disabled"
						value="<%=series.getSeriesID()%>" class="form-control" /></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="seriesName"
						value="<%=series.getTitle()%>" class="form-control" /></td>
				</tr>
				<tr>
					<td>genre</td>
					<td><input type="text" name="genre"
						value="<%=series.getGenre()%>" class="form-control" /></td>
				</tr>
				<tr>
					<td>year</td>
					<td><input type="text" name="year"
						value="<%=series.getReleaseYear()%>" class="form-control" /></td>
				</tr>
				<tr>
					<td>director</td>
					<td><input type="text" name="director"
						value="<%=series.getDirector()%>" class="form-control" /></td>
				</tr>
				<tr>
					<td>description</td>
					<td><input type="text" name="description"
						value="<%=series.getDescription()%>" class="form-control" /></td>
				</tr>
				<tr>
					<td>rating</td>
					<td><input type="text" name="rating"
						value="<%=series.getRating()%>" class="form-control" /></td>
				</tr>
				<tr>
					<td>language</td>
					<td><input type="text" name="language"
						value="<%=series.getLanguage()%>" class="form-control" /></td>
				</tr>
				<tr>
					<td>episode</td>
					<td><input type="text" name="episode"
						value="<%=series.getEpisode()%>" class="form-control" /></td>
				</tr>
				<tr>
					<td>season</td>
					<td><input type="text" name="season"
						value="<%=series.getSeason()%>" class="form-control" /></td>
				</tr>
				<tr>
					<td>poster</td>
					<td><input type="file" name="poster"
						value="<%=series.getPoster()%>" class="form-control" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="hidden" name="seriesID"
						value="<%=series.getSeriesID()%>" /> <input type="hidden"
						name="oldposter" value="<%=series.getPoster()%>" /> <input
						type="submit" value="Update Series"
						class="btn btn-outline-success" />
					<button type="button" class="btn btn-outline-danger"
							data-bs-toggle="modal" data-bs-target="#staticBackdrop">
							<i class="bi bi-layout-text-sidebar-reverse"
								style="font-size: 1.2rem"></i>&nbsp;&nbsp;Delete Series
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
					<form method="POST" action="DeleteSeriesServlet">
						<input type="hidden" name="seriesID"
							value="<%=series.getSeriesID()%>" /> <input type="hidden"
							name="poster" value="<%=series.getPoster()%>" />
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