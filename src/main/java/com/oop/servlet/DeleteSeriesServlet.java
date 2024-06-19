package com.oop.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Series;
import com.oop.service.SeriesServiceImpl;
import com.oop.util.CommonConstants;
import com.oop.service.ISeriesService;

/**
 * Delete seriess servlet
 */
public class DeleteSeriesServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1871871796669342804L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteSeriesServlet() {
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

		String seriesID = request.getParameter("seriesID");
		String poster = request.getParameter("poster");
		String filePath = CommonConstants.SERIES_IMAGE_PATH+poster;
		System.out.println(filePath);
		File f = new File(filePath);
		f.delete();
//		
		ISeriesService iSeriesService = new SeriesServiceImpl();
		iSeriesService.removeSeries(seriesID);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListSeries.jsp");
		dispatcher.forward(request, response);
	}

}
