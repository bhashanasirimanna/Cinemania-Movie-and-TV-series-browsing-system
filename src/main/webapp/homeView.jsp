<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cinemania - Best Movie Browser</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="shortcut icon" href="ico.svg" type="image/svg+xml">
</head>
<body id="top">

	<!-- 
    - #HEADER
  -->

	<header class="header2" data-header>
		<div class="container">

			<div class="overlay" data-overlay></div>

			<a href="#" class="logo"> <img
				src="./assets/2.png" alt="Cinemania logo" style="width: 200px;">
			</a>

			<div class="header-actions">

				<!-- <button class="search-btn">
          <ion-icon name="search-outline"></ion-icon>
        </button> -->


				<a href ="loginRegister.jsp"><button class="btn btn-primary">register</button></a>
				<a href ="loginRegister.jsp"><button class="btn btn-primary">sign in</button></a>

			</div>

			<button class="menu-open-btn" data-menu-open-btn>
				<ion-icon name="reorder-two"></ion-icon>
			</button>

		</div>
	</header>





	<main>
		<article>

			<!-- 
        - #HERO
      -->

			<section class="hero2">
				<div class="container">

					<div class="hero-content">

						<p class="hero-subtitle">Cinemania</p>

						<h1 class="h1 hero-title">
							Unlimited <strong>Movie</strong>, TVs Shows, & More.
						</h1>
						<h3 class="tell-to-register">"Signing up is quick and easy.
							It only takes a few moments to create your account, and you'll be
							ready to explore all that Cinemania has to offer."</h3>

					</div>

				</div>
			</section>



			<script type="module"
				src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
			<script nomodule
				src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
		</article>
	</main>
</body>
</html>