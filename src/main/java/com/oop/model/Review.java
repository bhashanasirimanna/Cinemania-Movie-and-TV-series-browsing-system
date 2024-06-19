package com.oop.model;

//import javax.management.Descriptor;

public class Review {
	
	private String reviewID;
	private String showName;
	private String description;
	private String postedDate;
	private String rating;
	
	//Return reviewID
	public String getReviewID() {
		return reviewID;
	}
	
	//Set reviewID
	public void setReviewID(String reviewID) {
		this.reviewID = reviewID;
	}
	
	//Return showName
	public String getShowName() {
		return showName;
	}
	
	//Set showName
	public void setShowName(String showName) {
		this.showName = showName;
	}
	
	//Return description
	public String getDescription() {
		return description;
	}
	
	//Set description
	public void setDescription(String description) {
		this.description = description;
	}
	
	//Return postedDate
	public String getPostedDate() {
		return postedDate;
	}
	
	//Set postedDate
	public void setPostedDate(String postedDate) {
		this.postedDate = postedDate;
	}
	
	//Return rating
	public String getRating() {
		return rating;
	}
	
	//Set rating
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		
		return "Review ID = " + reviewID + "\n" + "Show Name = " + showName + "\n" + "Description = " + description + "\n"
				+ "Posted Date = " + postedDate + "\n" + "Rating = " + rating;
	}

}
