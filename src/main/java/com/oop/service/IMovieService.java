package com.oop.service;

import com.oop.model.Movie;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

public interface IMovieService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IMovieService.class.getName());


	/**
	 * Add movies for movie table
	 * @param movie
	 */
	public void addMovie(Movie movie);

	/**
	 * Get a particular Movie
	 * 
	 * @param movieID
	 * @return Movie
	 */
	public Movie getMovieByID(String movieID);
	
	/**
	 * Get all list of movies
	 * 
	 * @return ArrayList<Movie>
	 */
	public ArrayList<Movie> getMovies();
	
	/**
	 * Update existing movie
	 * @param movieID
	 * @param movie
	 * 
	 * @return
	 */
	public Movie updateMovie(String movieID, Movie movie);

	/**
	 * Remove existing movie
	 * 
	 * @param movieID
	 */
	public void removeMovie(String movieID);

}
