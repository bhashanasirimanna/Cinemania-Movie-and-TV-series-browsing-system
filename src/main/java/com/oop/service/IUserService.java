package com.oop.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.oop.model.User;

public interface IUserService {
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IUserService.class.getName());

	/**
	 * Add users for user table
	 * 
	 * @param user
	 */
	public void addUser(User user);

	/**
	 * Get a particular User
	 * 
	 * @param userID
	 * @return User
	 */
	public User getUserByID(String userID);

	/**
	 * Get all list of users
	 * 
	 * @return ArrayList<User>
	 */
	public ArrayList<User> getUsers();

	/**
	 * Update existing User
	 * 
	 * @param userID
	 * @param user
	 * 
	 * @return
	 */
	public User updateUser(String userID, User user);

	/**
	 * Remove existing user
	 * 
	 * @param userID
	 */
	public void removeUser(String userID);
}
