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

import com.oop.model.Series;
import com.oop.util.CommonConstants;
import com.oop.util.CommonUtil;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;

public class SeriesServiceImpl implements ISeriesService {
	

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(SeriesServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static{
		//create table or drop if exist
		createSeriesTable();
	}

	private PreparedStatement preparedStatement;

	/**
	 * This method initially drop existing Seriess table in the database and
	 * recreate table structure to insert series entries
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
	public static void createSeriesTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.seriesQueryByID(CommonConstants.QUERY_ID_DROP_SERIES_TABLE));
			// Create new series table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.seriesQueryByID(CommonConstants.QUERY_ID_CREATE_SERIES_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add set of seriess for as a batch from the selected series List
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
	public void addSeries(Series series) {

		String seriesID = CommonUtil.generateSeriesIDs(getSeriesIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in UserQuery.xml file and use
			 * insert_series key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.seriesQueryByID(CommonConstants.QUERY_ID_INSERT_SERIES));
			connection.setAutoCommit(false);
			
			//Generate series IDs
			series.setSeriesID(seriesID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, series.getSeriesID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, series.getTitle());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, series.getGenre());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, series.getReleaseYear());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, series.getDirector());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, series.getDescription());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, series.getRating());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, series.getLanguage());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, series.getEpisode());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN, series.getSeason());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ELEVEN, series.getPoster());
		
			// Add series
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
	 * Series details can be retrieved based on the provided series ID
	 * 
	 * @param seriesID
	 *            - Series details are filtered based on the ID
	 * 
	 * @see #actionOnSeries()
	 */
	@Override
	public Series getSeriesByID(String seriesID) {

		return actionOnSeries(seriesID).get(0);
	}
	
	/**
	 * Get all list of seriess
	 * 
	 * @return ArrayList<Series> 
	 * 						- Array of series list will be return
	 * 
	 * @see #actionOnSeries()
	 */
	@Override
	public ArrayList<Series> getSeriess() {
		
		return actionOnSeries(null);
	}

	/**
	 * This method delete an series based on the provided ID
	 * 
	 * @param seriesID
	 *            - Delete series according to the filtered series details
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
	public void removeSeries(String seriesID) {

		// Before deleting check whether series ID is available
		if (seriesID != null && !seriesID.isEmpty()) {
			/*
			 * Remove series query will be retrieved from UserQuery.xml
			 */
			
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.seriesQueryByID(CommonConstants.QUERY_ID_REMOVE_SERIES));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, seriesID);
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
	 * This performs GET series by ID and Display all seriess
	 * 
	 * @param seriesID
	 *            ID of the series to remove or select from the list

	 * @return ArrayList<Series> Array of series list will be return
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
	 * @see #getSeriess()
	 * @see #getSeriesByID(String)
	 */
	private ArrayList<Series> actionOnSeries(String seriesID) {

		ArrayList<Series> seriesList = new ArrayList<Series>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching series it checks whether series ID is
			 * available
			 */
			if (seriesID != null && !seriesID.isEmpty()) {
				/*
				 * Get series by ID query will be retrieved from
				 * UserQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.seriesQueryByID(CommonConstants.QUERY_ID_GET_SERIES));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, seriesID);
			}
			/*
			 * If series ID is not provided for get series option it display
			 * all seriess
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.seriesQueryByID(CommonConstants.QUERY_ID_ALL_SERIES));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Series series = new Series();
				series.setSeriesID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				series.setTitle(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				series.setGenre(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				series.setReleaseYear(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				series.setDirector(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				series.setDescription(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				series.setRating(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				series.setLanguage(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				series.setEpisode(resultSet.getString(CommonConstants.COLUMN_INDEX_NINE));
				series.setSeason(resultSet.getString(CommonConstants.COLUMN_INDEX_TEN));
				series.setPoster(resultSet.getString(CommonConstants.COLUMN_INDEX_ELEVEN));
				seriesList.add(series);
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
		return seriesList;
	}

	/**
	 * Get the updated series
	 * 
	 * @param seriesID
	 *            ID of the series to remove or select from the list
	 * 
	 * @return return the Series object
	 * 
	 */
	@Override
	public Series updateSeries(String seriesID, Series series) {
		//System.out.println(seriesID);

		/*
		 * Before fetching series it checks whether series ID is available
		 */
		if (seriesID != null && !seriesID.isEmpty()) {
			/*
			 * Update series query will be retrieved from UserQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.seriesQueryByID(CommonConstants.QUERY_ID_UPDATE_SERIES));
//				System.out.println("Hi im in try");
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, series.getTitle());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, series.getGenre());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, series.getReleaseYear());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, series.getDirector());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, series.getDescription());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, series.getRating());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, series.getLanguage());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, series.getEpisode());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, series.getSeason());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN, series.getPoster());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ELEVEN, series.getSeriesID());
				preparedStatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
				System.out.println("HI SUDDA");
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
		// Get the updated series
		return getSeriesByID(seriesID);
	}
	
	/**
	 *
	 * @return ArrayList<String> Array of series id list will be return
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
	private ArrayList<String> getSeriesIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of series IDs will be retrieved from UserQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.seriesQueryByID(CommonConstants.QUERY_ID_GET_SERIES_IDS));
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
