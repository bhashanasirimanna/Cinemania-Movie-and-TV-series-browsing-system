<%@page import="com.oop.model.Series"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.SeriesServiceImpl"%>
<%@page import="com.oop.service.ISeriesService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TV Series</title>
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

					<a href="./index.html" class="logo"> <img
						src="./assets/images/logo.svg" alt="Filmlane logo">
					</a>

					<button class="menu-close-btn" data-menu-close-btn>
						<ion-icon name="close-outline"></ion-icon>
					</button>

				</div>

				<ul class="navbar-list">

					<li><a href="welcome.jsp" class="navbar-link">Home</a></li>

					<li><a href="ListMovieCards.jsp" class="navbar-link">Movies</a></li>

					<li><a href="#" class="navbar-link">Tv
							Series</a></li>

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

	<section class="top-rated">
		<div class="container">
			<br> <br>
			<p class="section-subtitle">Online Streaming</p>

			<h2 class="h2 section-title">Top Rated Series</h2>

			<ul class="movies-list">
            

           <%
				ISeriesService iSeriesService = new SeriesServiceImpl();
				ArrayList<Series> arrayList = iSeriesService.getSeriess();

				for (Series series : arrayList) {
				%>

				<li>
					<div class="movie-card">

						<a href="#">
							<figure class="card-banner">
								<img src="seriesimages/<%=series.getPoster()%>"
									alt="Sonic the Hedgehog 2 movie poster">
							</figure>
						</a>

						<div class="title-wrapper">
							<form method="POST" action="GetSeriesDetailsServlet">
								<input type="hidden" name="seriesID"
									value="<%=series.getSeriesID()%>" />
								<button type="submit">
									<h3 class="card-title"><%=series.getTitle()%></h3>
								</button>
							</form>

							<time datetime="2022">2022</time>
						</div>

						<div class="card-meta">
							<div class="badge badge-outline">2K</div>

							<div class="duration">
								<ion-icon name="time-outline"></ion-icon>

								<time datetime="PT122M"><%=series.getRating()%> min</time>
							</div>

							<div class="rating">
								<ion-icon name="star"></ion-icon>

								<data>7.8</data>
							</div>
						</div>

					</div>
				</li>
				<%
				}
				%>

            <li>
              <div class="movie-card">

                <a href="./movie-details.html">
                  <figure class="card-banner">
                    <img src="./assets/series-2.png" alt="Halo movie poster">
                  </figure>
                </a>

                <div class="title-wrapper">
                  <a href="./movie-details.html">
                    <h3 class="card-title">Halo</h3>
                  </a>

                  <time datetime="2022">2022</time>
                </div>

                <div class="card-meta">
                  <div class="badge badge-outline">2K</div>

                  <div class="duration">
                    <ion-icon name="time-outline"></ion-icon>

                    <time datetime="PT59M">59 min</time>
                  </div>

                  <div class="rating">
                    <ion-icon name="star"></ion-icon>

                    <data>8.8</data>
                  </div>
                </div>

              </div>
            </li>

            <li>
              <div class="movie-card">

                <a href="./movie-details.html">
                  <figure class="card-banner">
                    <img src="./assets/series-3.png" alt="Vikings: Valhalla movie poster">
                  </figure>
                </a>

                <div class="title-wrapper">
                  <a href="./movie-details.html">
                    <h3 class="card-title">Vikings: Valhalla</h3>
                  </a>

                  <time datetime="2022">2022</time>
                </div>

                <div class="card-meta">
                  <div class="badge badge-outline">2K</div>

                  <div class="duration">
                    <ion-icon name="time-outline"></ion-icon>

                    <time datetime="PT51M">51 min</time>
                  </div>

                  <div class="rating">
                    <ion-icon name="star"></ion-icon>

                    <data>8.3</data>
                  </div>
                </div>

              </div>
            </li>

            <li>
              <div class="movie-card">

                <a href="./movie-details.html">
                  <figure class="card-banner">
                    <img src="./assets/series-4.png" alt="Money Heist movie poster">
                  </figure>
                </a>

                <div class="title-wrapper">
                  <a href="./movie-details.html">
                    <h3 class="card-title">Money Heist</h3>
                  </a>

                  <time datetime="2017">2017</time>
                </div>

                <div class="card-meta">
                  <div class="badge badge-outline">4K</div>

                  <div class="duration">
                    <ion-icon name="time-outline"></ion-icon>

                    <time datetime="PT70M">70 min</time>
                  </div>

                  <div class="rating">
                    <ion-icon name="star"></ion-icon>

                    <data>8.3</data>
                  </div>
                </div>

              </div>
            </li>

          </ul>
		</div>
	</section>

	</article>
	</main>

	<footer class="footer">

		<div class="footer-top">
			<div class="container">

				<div class="footer-brand-wrapper">

					<a href="./index.html" class="logo"> <img src="./assets/2.png"
						alt="Filmlane logo" style="width: 200px;">
					</a>

					<ul class="footer-list">

						<li><a href="./index.html" class="footer-link">Home</a></li>

						<li><a href="#" class="footer-link">Movies</a></li>

						<li><a href="#" class="footer-link">TV Series</a></li>

						<li><a href="#" class="footer-link">Contact Us</a></li>

					</ul>

				</div>

				<div class="divider"></div>

				<div class="quicklink-wrapper">

					<ul class="quicklink-list">

						<li><a href="#" class="quicklink-link">Faq</a></li>

						<li><a href="#" class="quicklink-link">Help center</a></li>

						<li><a href="#" class="quicklink-link">Terms of use</a></li>

						<li><a href="#" class="quicklink-link">Privacy</a></li>

					</ul>

					<ul class="social-list">

						<li><a href="#" class="social-link"> <ion-icon
									name="logo-facebook"></ion-icon>
						</a></li>

						<li><a href="#" class="social-link"> <ion-icon
									name="logo-twitter"></ion-icon>
						</a></li>

						<li><a href="#" class="social-link"> <ion-icon
									name="logo-pinterest"></ion-icon>
						</a></li>

						<li><a href="#" class="social-link"> <ion-icon
									name="logo-linkedin"></ion-icon>
						</a></li>

					</ul>

				</div>

			</div>
		</div>

		<div class="footer-bottom">
			<div class="container">

				<p class="copyright">
					&copy; 2023 <a href="#">PIONEERS</a>. All Rights Reserved
				</p>

			</div>
		</div>

	</footer>
	<!-- 
    - #GO TO TOP
  -->

	<a href="#top" class="go-top" data-go-top> <ion-icon
			name="chevron-up"></ion-icon>
	</a>
	<!-- 
    - custom js link
  -->
	<script src="./js/script.js"></script>

	<!-- 
    - ionicon link
  -->
	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>