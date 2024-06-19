package com.oop.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.oop.service.IMovieService;
import com.oop.service.ISeriesService;
import com.oop.service.IUserService;

public class CommonUtil {
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IUserService.class.getName());
	
	/** Initialize logger */
	public static final Logger logMovie = Logger.getLogger(IMovieService.class.getName());
	
	public static final Logger logSeries = Logger.getLogger(ISeriesService.class.getName());


	public static final Properties properties = new Properties();

	static {
		try {

			// Read the property only once when load the class
			properties.load(QueryUtil.class.getResourceAsStream(CommonConstants.PROPERTY_FILE));

		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add new User ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateUserIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.USER_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.USER_ID_PREFIX + next;
		}
		return id;
	}
	
	/**
	 * Add new Review ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateReviewIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.REVIEW_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.REVIEW_ID_PREFIX + next;
		}
		return id;
	}
	
	public static String generateMovieIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.MOVIE_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.MOVIE_ID_PREFIX + next;
		}
		return id;
	}
	
	public static String generateSeriesIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.SERIES_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.SERIES_ID_PREFIX + next;
		}
		return id;
	}
}
