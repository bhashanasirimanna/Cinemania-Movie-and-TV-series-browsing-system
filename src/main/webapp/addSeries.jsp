<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Series</title>
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
            <a class="navbar-brand" href="AdminPanel.jsp">
                <img src="./assets/2.png" alt="" width="200" class="d-inline-block align-text-top">
            </a>
            <div class="d-flex">
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-outline-warning" data-bs-toggle="modal"
                    data-bs-target="#exampleModal">
                    <i class="bi bi-power"></i>&nbsp;&nbsp;Sign Out
                </button>

                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                    aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Do you really want to sign out</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-outline-secondary"
                                    data-bs-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-outline-danger">Sign Out</button>
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
				<h3 class="fw-bo">
					<i class="bi bi-camera-reels" style="color: #57B400;"></i>&nbsp;&nbsp;Add
					New Series
				</h3>
				<br>

				<form class="row g-3" method="post" action="AddSeriesServlet" enctype="multipart/form-data">
					<div class="col-md-3">
						<label for="movieTitle" class="form-label">Title</label> <input
							type="text" name="title" class="form-control" id="mTitle">
					</div>
					<div class="col-md-3">
						<label for="movieTitle" class="form-label">Seasons</label> <input
							type="number" name="season" class="form-control" id="mTitle">
					</div>
					<div class="col-md-3">
						<label for="movieTitle" class="form-label">Episodes</label> <input
							type="Number" name="episode" class="form-control" id="mTitle">
					</div>
					<div class="col-md-3">
						<label for="inputGenre" class="form-label">Genre</label>
						<div class="input-group mb-3">
							<select class="form-select" id="inputGroupSelect01" name="genre">
								<option selected>Choose...</option>
								<option value="1">Action</option>
								<option value="2">Romantic</option>
								<option value="3">Sci-Fi</option>
								<option value="4">Thriller</option>
								<option value="5">Crime</option>
								<option value="6">Cartoon</option>
							</select>
						</div>
					</div>
					<div class="col-md-3">
						<label for="inputRelease" class="form-label">Release Year</label>
						<input type="date" class="form-control" id="inputPassword4"
							name="releaseyear">
					</div>
					<div class="col-md-3">
						<label for="inputDirector" class="form-label">Director</label> <input
							type="text" class="form-control" id="inputAddress"
							name="director">
					</div>
					<div class="col-md-3">
						<label for="inputLanguage" class="form-label">Language</label> <input
							type="text" class="form-control" id="inputAddress2"
							name="language">
					</div>
					<div class="col-md-3">
						<label for="inputDuration" class="form-label">Duration</label> <input
							type="number" class="form-control" id="inputCity" name="rating">
					</div>
					<div class="col-md-8">
						<div class="mb-3">
							<label for="exampleFormControlTextarea1" class="form-label">Description</label>
							<textarea class="form-control" id="exampleFormControlTextarea1"
								rows="3" name="description"></textarea>
						</div>
					</div>
					<div class="col-md-4">
						<div class="mb-3">
							<label for="formFile" class="form-label">Poster</label> <input
								class="form-control" type="file" id="formFile" name="poster">
						</div>
					</div>

					<div class="col-12">
						<button type="submit" class="btn btn-success">
							<i class="bi bi bi-check-circle-fill" style="font-size: 1.2rem"></i>&nbsp;&nbsp;Add
							Series
						</button>
						<button type="reset" class="btn btn-warning">
							<i class="bi bi-arrow-repeat" style="font-size: 1.2rem"></i>&nbsp;&nbsp;Reset
						</button>
						<a href="AdminPanel.jsp">
							<button type="button" class="btn btn-danger">
								<i class="bi bi-x-circle" style="font-size: 1.2rem"></i>&nbsp;&nbsp;Close
							</button>
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>