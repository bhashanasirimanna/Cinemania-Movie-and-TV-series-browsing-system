package com.oop.service;

import com.oop.model.Series;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

public interface ISeriesService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ISeriesService.class.getName());


	/**
	 * Add seriess for series table
	 * @param series
	 */
	public void addSeries(Series series);

	/**
	 * Get a particular Series
	 * 
	 * @param seriesID
	 * @return Series
	 */
	public Series getSeriesByID(String seriesID);
	
	/**
	 * Get all list of seriess
	 * 
	 * @return ArrayList<Series>
	 */
	public ArrayList<Series> getSeriess();
	
	/**
	 * Update existing series
	 * @param seriesID
	 * @param series
	 * 
	 * @return
	 */
	public Series updateSeries(String seriesID, Series series);

	/**
	 * Remove existing series
	 * 
	 * @param seriesID
	 */
	public void removeSeries(String seriesID);

}
