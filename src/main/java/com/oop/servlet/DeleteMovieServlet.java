package com.oop.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Movie;
import com.oop.service.MovieServiceImpl;
import com.oop.util.CommonConstants;
import com.oop.service.IMovieService;

/**
 * Delete movies servlet
 */
public class DeleteMovieServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1871871796669342804L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteMovieServlet() {
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

		String movieID = request.getParameter("movieID");
		String poster = request.getParameter("poster");
		String filePath = CommonConstants.MOVIE_IMAGE_PATH+poster;
		System.out.println(filePath);
		File f = new File(filePath);
		f.delete();
		
		IMovieService iMovieService = new MovieServiceImpl();
		iMovieService.removeMovie(movieID);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListMovies.jsp");
		dispatcher.forward(request, response);
	}

}
