package com.oop.model;

public class User {
	private String userID;
	private String username;
	private String password;
	private String email;
	private String dob;
	
	
	//Return userID
	public String getUserID() {
		return userID;
	}

	//Set userID
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	//Return username
	public String getUsername() {
		return username;
	}

	//Set username
	public void setUsername(String username) {
		this.username = username;
	}

	//Return password
	public String getPassword() {
		return password;
	}

	//Set password
	public void setPassword(String password) {
		this.password = password;
	}

	//Return email
	public String getEmail() {
		return email;
	}
	
	//Set email
	public void setEmail(String email) {
		this.email = email;
	}

	//Return dob
	public String getDob() {
		return dob;
	}

	//Set dob
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	@Override
	public String toString() {
		
		return "UserID = " + userID + "\n" + "Username = " + username + "\n" + "Password = " + password + "\n"
				+ "Date of Birth = " + dob + "\n" + "Email = " + email;
	}
}
