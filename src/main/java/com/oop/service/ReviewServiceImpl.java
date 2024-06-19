package com.oop.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.oop.model.Review;
import com.oop.util.CommonConstants;
import com.oop.util.CommonUtil;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;

public class ReviewServiceImpl implements IReviewService {
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ReviewServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static{
		//create table or drop if exist
		createReviewTable();
	}

	private PreparedStatement preparedStatement;

	/**
	 * This method initially drop existing Reviews table in the database and
	 * recreate table structure to insert Review entries
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error
	 * @throws NullPointerException
	 *             - Service is not available
	 * 
	 */
	public static void createReviewTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.reviewQueryByID(CommonConstants.QUERY_ID_DROP_TABLE_REVIEW));
			// Create new Reviews table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.reviewQueryByID(CommonConstants.QUERY_ID_CREATE_TABLE_REVIEW));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add set of Reviews for as a batch from the selected Review List
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * 
	 */
	@Override
	public void addReview(Review review) {

		String reviewID = CommonUtil.generateReviewIDs(getReviewIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in ReviewQuery.xml file and use
			 * insert_Review key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.reviewQueryByID(CommonConstants.QUERY_ID_INSERT_REVIEW));
			connection.setAutoCommit(false);
			
			//Generate Review IDs
			review.setReviewID(reviewID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, review.getReviewID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, review.getShowName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, review.getDescription());
//			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, review.getPostedDate());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, review.getRating());

			// Add Review
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	/**
	 * Review details can be retrieved based on the provided Review ID
	 * 
	 * @param ReviewID
	 *            - Review details are filtered based on the ID
	 * 
	 * @see #actionOnReview()
	 */
	@Override
	public Review getReviewByID(String reviewID) {

		return actionOnReview(reviewID).get(0);
	}
	
	/**
	 * Get all list of Reviews
	 * 
	 * @return ArrayList<Review> 
	 * 						- Array of Review list will be return
	 * 
	 * @see #actionOnReview()
	 */
	@Override
	public ArrayList<Review> getReviews() {
		
		return actionOnReview(null);
	}

	/**
	 * This method delete an Review based on the provided ID
	 * 
	 * @param ReviewID
	 *            - Delete Review according to the filtered Review details
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * @throws NullPointerException
	 *             - Service is not available
	 */
	@Override
	public void removeReview(String reviewID) {

		// Before deleting check whether Review ID is available
		if (reviewID != null && !reviewID.isEmpty()) {
			/*
			 * Remove Review query will be retrieved from ReviewQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.reviewQueryByID(CommonConstants.QUERY_ID_REMOVE_REVIEW));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, reviewID);
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}

	/**
	 * This performs GET Review by ID and Display all Reviews
	 * 
	 * @param ReviewID
	 *            ID of the Review to remove or select from the list

	 * @return ArrayList<Review> Array of Review list will be return
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * @throws NullPointerException
	 *             - Service is not available
	 * 
	 * @see #getReviews()
	 * @see #getReviewByID(String)
	 */
	private ArrayList<Review> actionOnReview(String reviewID) {

		ArrayList<Review> ReviewList = new ArrayList<Review>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching Review it checks whether Review ID is
			 * available
			 */
			if (reviewID != null && !reviewID.isEmpty()) {
				/*
				 * Get Review by ID query will be retrieved from
				 * ReviewQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.reviewQueryByID(CommonConstants.QUERY_ID_GET_REVIEW));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, reviewID);
			}
			/*
			 * If Review ID is not provided for get Review option it display
			 * all Reviews
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.reviewQueryByID(CommonConstants.QUERY_ID_ALL_REVIEW));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Review review = new Review();
				review.setReviewID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				review.setShowName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				review.setDescription(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				review.setPostedDate(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				review.setRating(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				ReviewList.add(review);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return ReviewList;
	}

	/**
	 * Get the updated Review
	 * 
	 * @param ReviewID
	 *            ID of the Review to remove or select from the list
	 * 
	 * @return return the Review object
	 * 
	 */
	@Override
	public Review updateReview(String reviewID, Review review) {

		/*
		 * Before fetching Review it checks whether Review ID is available
		 */
		if (reviewID != null && !reviewID.isEmpty()) {
			/*
			 * Update Review query will be retrieved from ReviewQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.reviewQueryByID(CommonConstants.QUERY_ID_UPDATE_REVIEW));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, review.getShowName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, review.getDescription());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, review.getPostedDate());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, review.getRating());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, review.getReviewID());
				preparedStatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		// Get the updated Review
		return getReviewByID(reviewID);
	}
	
	/**
	 *
	 * @return ArrayList<String> Array of Review id list will be return
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * @throws NullPointerException
	 *             - Service is not available
	 */
	private ArrayList<String> getReviewIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of Review IDs will be retrieved from ReviewQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.reviewQueryByID(CommonConstants.QUERY_ID_GET_REVIEW_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}
}
