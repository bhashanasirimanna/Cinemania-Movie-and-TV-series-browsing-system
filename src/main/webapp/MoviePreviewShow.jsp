<%@page import="com.oop.model.Movie"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.MovieServiceImpl"%>
<%@page import="com.oop.service.IMovieService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Name</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="shortcut icon" href="ico.svg" type="image/svg+xml">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap"
	rel="stylesheet">

</head>
<body>
	<header class="header" data-header>
		<div class="container">

			<div class="overlay" data-overlay></div>

			<a href="./index.html" class="logo"> <img src="./assets/2.png"
				alt="Cinemania logo" style="width: 200px;">
			</a>

			<div class="header-actions">

				<!-- <button class="search-btn">
          <ion-icon name="search-outline"></ion-icon>
        </button> -->

				<div class="lang-wrapper">
					<label for="language"> <ion-icon name="globe-outline"></ion-icon>
					</label> <select name="language" id="language">
						<option value="en">EN</option>
						<option value="au">AU</option>
						<option value="ar">AR</option>
						<option value="tu">TU</option>
					</select>
				</div>

				<a href="homeView.jsp">
					<button class="btn btn-primary">SiGN out</button>
				</a>

			</div>

			<button class="menu-open-btn" data-menu-open-btn>
				<ion-icon name="reorder-two"></ion-icon>
			</button>

			<nav class="navbar" data-navbar>

				<div class="navbar-top">

					<a href="welcome.jsp" class="logo"> <img
						src="./assets/images/logo.svg" alt="Filmlane logo">
					</a>

					<button class="menu-close-btn" data-menu-close-btn>
						<ion-icon name="close-outline"></ion-icon>
					</button>

				</div>

				<ul class="navbar-list">

					<li><a href="welcome.jsp" class="navbar-link">Home</a></li>

					<li><a href="ListMovieCards.jsp" class="navbar-link">Movies</a></li>

					<li><a href="#" class="navbar-link">Tv Series</a></li>

					<li><a href="#" class="navbar-link">Contact Us</a></li>

				</ul>

				<ul class="navbar-social-list">

					<li><a href="#" class="navbar-social-link"> <ion-icon
								name="logo-twitter"></ion-icon>
					</a></li>

					<li><a href="#" class="navbar-social-link"> <ion-icon
								name="logo-facebook"></ion-icon>
					</a></li>

					<li><a href="#" class="navbar-social-link"> <ion-icon
								name="logo-pinterest"></ion-icon>
					</a></li>

					<li><a href="#" class="navbar-social-link"> <ion-icon
								name="logo-instagram"></ion-icon>
					</a></li>

					<li><a href="#" class="navbar-social-link"> <ion-icon
								name="logo-youtube"></ion-icon>
					</a></li>

				</ul>

			</nav>

		</div>
	</header>

	<main>
		<article>

			<!-- 
        - #MOVIE DETAIL
      -->
			<%
				Movie movie = (Movie) request.getAttribute("movie");
			%>
			
			<section class="movie-detail">
				<div class="container">

					<figure class="movie-detail-banner">

						<img src="movieimages/<%=movie.getPoster()%>" alt="Free guy movie poster">

						<button class="play-btn">
							<ion-icon name="play-circle-outline"></ion-icon>
						</button>

					</figure>

					<div class="movie-detail-content">

						<p class="detail-subtitle">New Movie</p>

						<h1 class="h1 detail-title">
							<%=movie.getTitle()%>
						</h1>
						<p class="detail-subtitle" style="font-size: 15px;">Director: <font style="color: white;"><%=movie.getDirector()%></font></p>

						<div class="meta-wrapper">

							<div class="badge-wrapper">
								<div class="badge badge-fill">PG 13</div>

								<div class="badge badge-outline">HD</div>
							</div>

							<div class="ganre-wrapper">
								<a href="#"><%=movie.getGenre()%></a>

								
							</div>

							<div class="date-time">

								<div>
									<ion-icon name="calendar-outline"></ion-icon>

									<time datetime="2021"><%=movie.getReleaseYear()%></time>
								</div>

								<div>
									<ion-icon name="time-outline"></ion-icon>

									<time datetime="PT115M"><%=movie.getRating()%> min</time>
								</div>

							</div>

						</div>

						<p class="storyline"><%=movie.getDescription()%></p>

						<div class="details-actions">

							<button class="share">
								<ion-icon name="share-social"></ion-icon>

								<span>Share</span>
							</button>

							<div class="title-wrapper">
								<p class="title">Prime Video</p>

								<p class="text">Streaming Channels</p>
							</div>

							<button class="btn btn-primary">
								<ion-icon name="play"></ion-icon>

								<span>Watch Now</span>
							</button>

						</div>
					</div>

				</div>
			</section>
		</article>
	</main>

	<script src="./js/script.js"></script>
	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>