package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Review;
import com.oop.service.IReviewService;
import com.oop.service.ReviewServiceImpl;

public class UpdateReviewServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateReviewServlet() {
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

		Review review = new Review();
		String reviewID = request.getParameter("reviewID");
		review.setReviewID(reviewID);
		review.setShowName(request.getParameter("showname"));
		review.setDescription(request.getParameter("description"));
		review.setPostedDate(request.getParameter("postedDate"));
		review.setRating(request.getParameter("rating"));

		IReviewService iReviewService = new ReviewServiceImpl();
		iReviewService.updateReview(reviewID, review);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListReviews.jsp");
		dispatcher.forward(request, response);
	}

}
