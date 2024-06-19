package com.oop.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.oop.model.Movie;
import com.oop.service.MovieServiceImpl;
import com.oop.util.CommonConstants;
import com.oop.service.IMovieService;

@MultipartConfig

/**
 * Update movies servlet
 */
public class UpdateMovieServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateMovieServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		Movie movie = new Movie();
		String movieID = request.getParameter("movieID");	
		movie.setMovieID(movieID);
		movie.setTitle(request.getParameter("movieName"));
		movie.setGenre(request.getParameter("genre"));
		movie.setReleaseYear(request.getParameter("year"));
		movie.setDirector(request.getParameter("director"));
		movie.setDescription(request.getParameter("description"));
		movie.setRating(request.getParameter("rating"));
		movie.setLanguage(request.getParameter("languageg"));
		
		Part file = request.getPart("poster");
				
		String imageFileName=file.getSubmittedFileName();
		
		movie.setPoster(imageFileName);
		String uploadPath=CommonConstants.MOVIE_IMAGE_PATH+imageFileName;
				
		try {
			FileOutputStream fos = new FileOutputStream(uploadPath);
			InputStream is = file.getInputStream();
			
			byte[] data = new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		IMovieService iMovieService = new MovieServiceImpl();
		iMovieService.updateMovie(movieID, movie);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListMovies.jsp");
		dispatcher.forward(request, response);
	}

}

