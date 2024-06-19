package com.oop.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.oop.model.Review;

public interface IReviewService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IReviewService.class.getName());

	/**
	 * Add Reviews for Review table
	 * 
	 * @param Review
	 */
	public void addReview(Review review);

	/**
	 * Get a particular Review
	 * 
	 * @param ReviewID
	 * @return Review
	 */
	public Review getReviewByID(String reviewID);

	/**
	 * Get all list of Reviews
	 * 
	 * @return ArrayList<Review>
	 */
	public ArrayList<Review> getReviews();

	/**
	 * Update existing Review
	 * 
	 * @param ReviewID
	 * @param Review
	 * 
	 * @return
	 */
	public Review updateReview(String reviewID, Review review);

	/**
	 * Remove existing Review
	 * 
	 * @param ReviewID
	 */
	public void removeReview(String reviewID);
}
