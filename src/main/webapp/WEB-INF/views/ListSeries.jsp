<%@page import="com.oop.model.Series"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.SeriesServiceImpl"%>
<%@page import="com.oop.service.ISeriesService"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cinemania</title>

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
		<h3>List of Seriess</h3>

		<table class="table table-striped table-hover">
			<a href="addSeries.jsp">Add Series</a>
			<tr>
				<th>Series ID</th>
				<th>name</th>
				<th>genre</th>
				<th>year</th>
				<th>Director</th>
				<th>description</th>
				<th>rating</th>
				<th>language</th>
				<th>episode</th>
				<th>season</th>
				<th>post</th>
				<th>select</th>
			</tr>
			<%
			ISeriesService iSeriesService = new SeriesServiceImpl();
			ArrayList<Series> arrayList = iSeriesService.getSeriess();

			for (Series series : arrayList) {
			%>
			<tr>
				<td><%=series.getSeriesID()%></td>
				<td><%=series.getTitle()%></td>
				<td><%=series.getGenre()%></td>
				<td><%=series.getReleaseYear()%></td>
				<td><%=series.getDirector()%></td>
				<td><%=series.getDescription()%></td>
				<td><%=series.getRating()%></td>
				<td><%=series.getLanguage()%></td>
				<td><%=series.getEpisode()%></td>
				<td><%=series.getSeason()%></td>
				<td><img src="seriesimages/<%=series.getPoster()%>" width=200
					height=150></td>
				<td>
					<form method="POST" action="GetSeriesServlet">
						<input type="hidden" name="seriesID"
							value="<%=series.getSeriesID()%>" /> <input type="submit"
							value="Select Series" class="select-button" />
					</form>
				</td>
			</tr>
			<%
			}
			%>
		</table>
	</div>

</body>
</html>