package net.etfbl.movies.model;

public class User {
	
	private int id;
	private String name;
	private String surname;
	private String ucn;
	private String email;
	private String userType;
	private String imagePath;
	private String username;
	private String passwordHash;
	private boolean logedIn;
	
	public User () {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getUcn() {
		return ucn;
	}
	public void setUcn(String ucn) {
		this.ucn = ucn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	public boolean isLogedIn() {
		return logedIn;
	}
	public void setLogedIn(boolean logedIn) {
		this.logedIn = logedIn;
	}

}
