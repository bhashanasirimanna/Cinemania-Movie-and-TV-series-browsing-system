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

import com.oop.model.Series;
import com.oop.service.SeriesServiceImpl;
import com.oop.util.CommonConstants;
import com.oop.service.ISeriesService;

@MultipartConfig
/**
 * Servlet implementation class LoginServlet
 */
public class AddSeriesServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddSeriesServlet() {
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
		
		Series series = new Series();
		
		series.setTitle(request.getParameter("title"));
		series.setGenre(request.getParameter("genre"));
		series.setReleaseYear(request.getParameter("releaseyear"));
		series.setDirector(request.getParameter("director"));
		series.setDescription(request.getParameter("description"));
		series.setRating(request.getParameter("rating"));
		series.setLanguage(request.getParameter("language"));
		series.setEpisode(request.getParameter("episode"));
		series.setSeason(request.getParameter("season"));
	
		//add image
		Part file=request.getPart("poster");
		
		String imageFileName=file.getSubmittedFileName();
		
		series.setPoster(imageFileName);
		String uploadPath=CommonConstants.SERIES_IMAGE_PATH+imageFileName;
				
		try {
			System.out.println("he he");
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
	        // Call the service to add the series to the database
		
		ISeriesService iSeriesService = new SeriesServiceImpl();
		iSeriesService.addSeries(series);

		request.setAttribute("series", series);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListSeries.jsp");
		dispatcher.forward(request, response);
	}

}
