package com.oop.model;

public class Series {
	private String SeriesID;

	private String Title;

	private String Genre;

	private String ReleaseYear;

	private String Director;

	private String Description;

	private String Rating;

	private String Language;

	private String Episode;

	private String Season;

	private String Poster;

	/**
	 * @return the seriesID
	 */
	public String getSeriesID() {
		return SeriesID;
	}

	/**
	 * @param seriesID the seriesID to set
	 */
	public void setSeriesID(String seriesID) {
		SeriesID = seriesID;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return Title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		Title = title;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return Genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		Genre = genre;
	}

	/**
	 * @return the releaseYear
	 */
	public String getReleaseYear() {
		return ReleaseYear;
	}

	/**
	 * @param releaseYear the releaseYear to set
	 */
	public void setReleaseYear(String releaseYear) {
		ReleaseYear = releaseYear;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return Director;
	}

	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		Director = director;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}

	/**
	 * @return the rating
	 */
	public String getRating() {
		return Rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		Rating = rating;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return Language;
	}

	/**
	 * @param language the language t4o set
	 */
	public void setLanguage(String language) {
		Language = language;
	}

	/**
	 * @return the poster
	 */
	public String getPoster() {
		return Poster;
	}

	/**
	 * @param posterData the poster to set
	 */
	public void setPoster(String posterData) {
		Poster = posterData;
	}

	/**
	 * @return the episode
	 */
	public String getEpisode() {
		return Episode;
	}

	/**
	 * @param episode the episode to set
	 */
	public void setEpisode(String episode) {
		Episode = episode;
	}

	/**
	 * @return the season
	 */
	public String getSeason() {
		return Season;
	}

	/**
	 * @param season the season to set
	 */
	public void setSeason(String season) {
		Season = season;
	}

	@Override
	public String toString() {

		return "Series title = " + Title + "\n" + "Series genre = " + Genre + "\n" + "Release year = " + ReleaseYear
				+ "\n" + "Director = " + Director + "\n" + "Description = " + Description + "\n" + "Rating = " + Rating
				+ "\n" + "Language = " + Language + "\n" + "Episodes = " + Episode + "\n" + "Seasons = " + Season + "\n"
				+ "Poster = " + Poster;
	}

}
