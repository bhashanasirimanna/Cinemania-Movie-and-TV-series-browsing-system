package com.oop.servlet;

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
 * Servlet implementation class LoginServlet
 */
public class AddMovieServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddMovieServlet() {
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
		
		movie.setTitle(request.getParameter("title"));
		movie.setGenre(request.getParameter("genre"));
		movie.setReleaseYear(request.getParameter("releaseyear"));
		movie.setDirector(request.getParameter("director"));
		movie.setDescription(request.getParameter("description"));
		movie.setRating(request.getParameter("rating"));
		movie.setLanguage(request.getParameter("language"));
	
		//add image
		Part file=request.getPart("poster");
		
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
	        // Call the service to add the movie to the database
		
		IMovieService iMovieService = new MovieServiceImpl();
		iMovieService.addMovie(movie);

		request.setAttribute("movie", movie);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListMovies.jsp");
		dispatcher.forward(request, response);
	}

}
