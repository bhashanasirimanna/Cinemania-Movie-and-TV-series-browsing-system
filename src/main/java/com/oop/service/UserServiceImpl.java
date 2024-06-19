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

import com.oop.model.User;
import com.oop.util.CommonConstants;
import com.oop.util.CommonUtil;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;

public class UserServiceImpl implements IUserService {
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(UserServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static{
		//create table or drop if exist
		createUserTable();
	}

	private PreparedStatement preparedStatement;

	/**
	 * This method initially drop existing Users table in the database and
	 * recreate table structure to insert User entries
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
	public static void createUserTable() {
		
		//System.out.println("Im inside UserServiceImpl, and inside createUserTable()");

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			
			statement.executeUpdate(QueryUtil.userQueryByID(CommonConstants.QUERY_ID_DROP_TABLE_USER));
			// Create new Users table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.userQueryByID(CommonConstants.QUERY_ID_CREATE_TABLE_USER));
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add set of Users for as a batch from the selected User List
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
	public void addUser(User user) {

		String userID = CommonUtil.generateUserIDs(getUserIDs());
		
		//System.out.println("Im from userServiceImpl.java -> addUser() -> Outside the tryCatch");
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in UserQuery.xml file and use
			 * insert_User key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.userQueryByID(CommonConstants.QUERY_ID_INSERT_USERS));
			connection.setAutoCommit(false);
			
			//System.out.println("Inside the addUser()"); Issue inside the try catch
			
			//Generate User IDs
			user.setUserID(userID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, user.getUserID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, user.getUsername());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, user.getPassword());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, user.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, user.getDob());

			// Add User
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
	 * User details can be retrieved based on the provided User ID
	 * 
	 * @param UserID
	 *            - User details are filtered based on the ID
	 * 
	 * @see #actionOnUser()
	 */
	@Override
	public User getUserByID(String userID) {

		return actionOnUser(userID).get(0);
	}
	
	/**
	 * Get all list of Users
	 * 
	 * @return ArrayList<User> 
	 * 						- Array of User list will be return
	 * 
	 * @see #actionOnUser()
	 */
	@Override
	public ArrayList<User> getUsers() {
		
		return actionOnUser(null);
	}

	/**
	 * This method delete an User based on the provided ID
	 * 
	 * @param UserID
	 *            - Delete User according to the filtered User details
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
	public void removeUser(String userID) {

		// Before deleting check whether User ID is available
		if (userID != null && !userID.isEmpty()) {
			/*
			 * Remove User query will be retrieved from UserQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.userQueryByID(CommonConstants.QUERY_ID_REMOVE_USER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, userID);
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
	 * This performs GET User by ID and Display all Users
	 * 
	 * @param UserID
	 *            ID of the User to remove or select from the list

	 * @return ArrayList<User> Array of User list will be return
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
	 * @see #getUsers()
	 * @see #getUserByID(String)
	 */
	private ArrayList<User> actionOnUser(String userID) {

		ArrayList<User> UserList = new ArrayList<User>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching User it checks whether User ID is
			 * available
			 */
			if (userID != null && !userID.isEmpty()) {
				/*
				 * Get User by ID query will be retrieved from
				 * UserQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.userQueryByID(CommonConstants.QUERY_ID_GET_USER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, userID);
			}
			/*
			 * If User ID is not provided for get User option it display
			 * all Users
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.userQueryByID(CommonConstants.QUERY_ID_ALL_USERS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				User user = new User();
				user.setUserID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				user.setUsername(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				user.setPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				user.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				user.setDob(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				UserList.add(user);
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
		return UserList;
	}

	/**
	 * Get the updated User
	 * 
	 * @param UserID
	 *            ID of the User to remove or select from the list
	 * 
	 * @return return the User object
	 * 
	 */
	@Override
	public User updateUser(String userID, User user) {

		/*
		 * Before fetching User it checks whether User ID is available
		 */
		if (userID != null && !userID.isEmpty()) {
			/*
			 * Update User query will be retrieved from UserQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.userQueryByID(CommonConstants.QUERY_ID_UPDATE_USER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, user.getUsername());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, user.getPassword());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, user.getEmail());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, user.getDob());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, user.getUserID());
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
		// Get the updated User
		return getUserByID(userID);
	}
	
	/**
	 *
	 * @return ArrayList<String> Array of User id list will be return
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
	private ArrayList<String> getUserIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of User IDs will be retrieved from UserQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.userQueryByID(CommonConstants.QUERY_ID_GET_USER_IDS));
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
