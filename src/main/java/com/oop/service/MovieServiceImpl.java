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

import com.oop.model.Movie;
import com.oop.util.CommonConstants;
import com.oop.util.CommonUtil;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;

public class MovieServiceImpl implements IMovieService {
	

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(MovieServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static{
		//create table or drop if exist
		createMovieTable();
	}

	private PreparedStatement preparedStatement;

	/**
	 * This method initially drop existing Movies table in the database and
	 * recreate table structure to insert movie entries
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
	public static void createMovieTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.movieQueryByID(CommonConstants.QUERY_ID_DROP_MOVIE_TABLE));
			// Create new movies table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.movieQueryByID(CommonConstants.QUERY_ID_CREATE_MOVIE_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add set of movies for as a batch from the selected movie List
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
	public void addMovie(Movie movie) {

		String movieID = CommonUtil.generateMovieIDs(getMovieIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in MovieQuery.xml file and use
			 * insert_movie key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.movieQueryByID(CommonConstants.QUERY_ID_INSERT_MOVIES));
			connection.setAutoCommit(false);
			
			//Generate movie IDs
			movie.setMovieID(movieID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, movie.getMovieID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, movie.getTitle());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, movie.getGenre());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, movie.getReleaseYear());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, movie.getDirector());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, movie.getDescription());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, movie.getRating());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, movie.getLanguage());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, movie.getPoster());
			// Add movie
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
	 * Movie details can be retrieved based on the provided movie ID
	 * 
	 * @param movieID
	 *            - Movie details are filtered based on the ID
	 * 
	 * @see #actionOnMovie()
	 */
	@Override
	public Movie getMovieByID(String movieID) {

		return actionOnMovie(movieID).get(0);
	}
	
	/**
	 * Get all list of movies
	 * 
	 * @return ArrayList<Movie> 
	 * 						- Array of movie list will be return
	 * 
	 * @see #actionOnMovie()
	 */
	@Override
	public ArrayList<Movie> getMovies() {
		
		return actionOnMovie(null);
	}

	/**
	 * This method delete an movie based on the provided ID
	 * 
	 * @param movieID
	 *            - Delete movie according to the filtered movie details
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
	public void removeMovie(String movieID) {

		// Before deleting check whether movie ID is available
		if (movieID != null && !movieID.isEmpty()) {
			/*
			 * Remove movie query will be retrieved from MovieQuery.xml
			 */
			
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.movieQueryByID(CommonConstants.QUERY_ID_REMOVE_MOVIE));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, movieID);
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
	 * This performs GET movie by ID and Display all movies
	 * 
	 * @param movieID
	 *            ID of the movie to remove or select from the list

	 * @return ArrayList<Movie> Array of movie list will be return
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
	 * @see #getMovies()
	 * @see #getMovieByID(String)
	 */
	private ArrayList<Movie> actionOnMovie(String movieID) {

		ArrayList<Movie> movieList = new ArrayList<Movie>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching movie it checks whether movie ID is
			 * available
			 */
			if (movieID != null && !movieID.isEmpty()) {
				/*
				 * Get movie by ID query will be retrieved from
				 * MovieQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.movieQueryByID(CommonConstants.QUERY_ID_GET_MOVIE));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, movieID);
			}
			/*
			 * If movie ID is not provided for get movie option it display
			 * all movies
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.movieQueryByID(CommonConstants.QUERY_ID_ALL_MOVIES));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Movie movie = new Movie();
				movie.setMovieID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				movie.setTitle(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				movie.setGenre(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				movie.setReleaseYear(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				movie.setDirector(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				movie.setDescription(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				movie.setRating(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				movie.setLanguage(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				movie.setPoster(resultSet.getString(CommonConstants.COLUMN_INDEX_NINE));//new
				movieList.add(movie);
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
		return movieList;
	}

	/**
	 * Get the updated movie
	 * 
	 * @param movieID
	 *            ID of the movie to remove or select from the list
	 * 
	 * @return return the Movie object
	 * 
	 */
	@Override
	public Movie updateMovie(String movieID, Movie movie) {
		//System.out.println(movieID);

		/*
		 * Before fetching movie it checks whether movie ID is available
		 */
		if (movieID != null && !movieID.isEmpty()) {
			/*
			 * Update movie query will be retrieved from MovieQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.movieQueryByID(CommonConstants.QUERY_ID_UPDATE_MOVIE));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, movie.getTitle());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, movie.getGenre());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, movie.getReleaseYear());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, movie.getDirector());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, movie.getDescription());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, movie.getRating());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, movie.getLanguage());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, movie.getPoster());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, movie.getMovieID());
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
		// Get the updated movie
		return getMovieByID(movieID);
	}
	
	/**
	 *
	 * @return ArrayList<String> Array of movie id list will be return
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
	private ArrayList<String> getMovieIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of movie IDs will be retrieved from MovieQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.movieQueryByID(CommonConstants.QUERY_ID_GET_MOVIE_IDS));
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
