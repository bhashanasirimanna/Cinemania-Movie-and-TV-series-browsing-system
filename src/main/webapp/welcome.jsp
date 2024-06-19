<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="css/loader.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="shortcut icon" href="ico.svg" type="image/svg+xml">
</head>
</head>

<body id="top" onload="myFunction()">
	<div id="loader"></div>

	<!-- 
    - #HEADER
  -->
	<div style="display:none;" id="myDiv" class="animate-bottom">
		<header class="header" data-header>
			<div class="container">

				<div class="overlay" data-overlay></div>

				<a href="./index.html" class="logo"> <img src="assets/2.png"
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

					<a href="homeView.jsp"><button class="btn btn-primary">sign
							out</button></a>

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

						<li><a href="#" class="navbar-link">Home</a></li>

						<li><a href="ListMovieCards.jsp" class="navbar-link">Movies</a></li>

						<li><a href="ListSeriesCards.jsp" class="navbar-link">Tv Series</a></li>

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
        - #HERO
      -->

				<section class="hero">
					<div class="container">

						<div class="hero-content">

							<p class="hero-subtitle">Cinemania</p>

							<h1 class="h1 hero-title">
								Unlimited <strong>Movie</strong>, TVs Shows, & More.
							</h1>



							<button class="btn btn-primary">
								<ion-icon name="play"></ion-icon>

								<span>Browse now</span>
							</button>

						</div>

					</div>
				</section>


				<section class="upcoming">
					<div class="container">

						<div class="flex-wrapper">

							<div class="title-wrapper">
								<p class="section-subtitle">Online Streaming</p>

								<h2 class="h2 section-title">Upcoming Movies</h2>
							</div>

							<ul class="filter-list">

								<li>
									<button class="filter-btn">Movies</button>
								</li>

								<li>
									<button class="filter-btn">TV Shows</button>
								</li>

								<li>
									<button class="filter-btn">Anime</button>
								</li>

							</ul>

						</div>

						<ul class="movies-list  has-scrollbar">

							<li>
								<div class="movie-card">

									<a href="./movie-details.html">
										<figure class="card-banner">
											<img src="assets/upcoming-1.png"
												alt="The Northman movie poster">
										</figure>
									</a>

									<div class="title-wrapper">
										<a href="./movie-details.html">
											<h3 class="card-title">The Northman</h3>
										</a>

										<time datetime="2022">2022</time>
									</div>

									<div class="card-meta">
										<div class="badge badge-outline">HD</div>

										<div class="duration">
											<ion-icon name="time-outline"></ion-icon>

											<time datetime="PT137M">137 min</time>
										</div>

										<div class="rating">
											<ion-icon name="star"></ion-icon>

											<data>8.5</data>
										</div>
									</div>

								</div>
							</li>

							<li>
								<div class="movie-card">

									<a href="PreviewShow.jsp">
										<figure class="card-banner">
											<img src="assets/upcoming-2.png"
												alt="Doctor Strange in the Multiverse of Madness movie poster">
										</figure>
									</a>

									<div class="title-wrapper">
										<a href="./movie-details.html">
											<h3 class="card-title">Doctor Strange in the Multiverse
												of Madness</h3>
										</a>

										<time datetime="2022">2022</time>
									</div>

									<div class="card-meta">
										<div class="badge badge-outline">4K</div>

										<div class="duration">
											<ion-icon name="time-outline"></ion-icon>

											<time datetime="PT126M">126 min</time>
										</div>

										<div class="rating">
											<ion-icon name="star"></ion-icon>

											<data>NR</data>
										</div>
									</div>

								</div>
							</li>

							<li>
								<div class="movie-card">

									<a href="./movie-details.html">
										<figure class="card-banner">
											<img src="assets/upcoming-3.png" alt="Memory movie poster">
										</figure>
									</a>

									<div class="title-wrapper">
										<a href="./movie-details.html">
											<h3 class="card-title">Memory</h3>
										</a>

										<time datetime="2022">2022</time>
									</div>

									<div class="card-meta">
										<div class="badge badge-outline">2K</div>

										<div class="duration">
											<ion-icon name="time-outline"></ion-icon>

											<time datetime="">N/A</time>
										</div>

										<div class="rating">
											<ion-icon name="star"></ion-icon>

											<data>NR</data>
										</div>
									</div>

								</div>
							</li>

							<li>
								<div class="movie-card">

									<a href="./movie-details.html">
										<figure class="card-banner">
											<img src="assets/upcoming-4.png"
												alt="The Unbearable Weight of Massive Talent movie poster">
										</figure>
									</a>

									<div class="title-wrapper">
										<a href="./movie-details.html">
											<h3 class="card-title">The Unbearable Weight of Massive
												Talent</h3>
										</a>

										<time datetime="2022">2022</time>
									</div>

									<div class="card-meta">
										<div class="badge badge-outline">HD</div>

										<div class="duration">
											<ion-icon name="time-outline"></ion-icon>

											<time datetime="PT107M">107 min</time>
										</div>

										<div class="rating">
											<ion-icon name="star"></ion-icon>

											<data>NR</data>
										</div>
									</div>

								</div>
							</li>

						</ul>

					</div>
				</section>

				<!-- 
    - #FOOTER
  -->

				<footer class="footer">

					<div class="footer-top">
						<div class="container">

							<div class="footer-brand-wrapper">

								<a href="./index.html" class="logo"> <img
									src="assets/2.png " alt="Filmlane logo" style="width: 200px;">
								</a>

								<ul class="footer-list">

									<li><a href="./index.html" class="footer-link">Home</a></li>

									<li><a href="#" class="footer-link">Movie</a></li>

									<li><a href="#" class="footer-link">Web Series</a></li>

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
								&copy; 2023 <a href="#">Pioneers</a>. All Rights Reserved
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
	</div>
	<!-- 
    - custom js link
  -->
	<script src="js/script.js"></script>

	<script>
		var myVar;

		function myFunction() {
			myVar = setTimeout(showPage, 2000);
		}

		function showPage() {
			document.getElementById("loader").style.display = "none";
			document.getElementById("myDiv").style.display = "block";
		}
	</script>

	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

	</article>
	</main>
</body>
</html>