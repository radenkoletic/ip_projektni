package net.etfbl.movies.model;

public class Actor {
	
	private int id;
	private String name;
	private String surname;
	private String restUrl;
	private String restThumbnail;
	
	public Actor () {
		
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

	public String getRestUrl() {
		return restUrl;
	}

	public void setRestUrl(String restUrl) {
		this.restUrl = restUrl;
	}

	public String getRestThumbnail() {
		return restThumbnail;
	}

	public void setRestThumbnail(String restThumbnail) {
		this.restThumbnail = restThumbnail;
	}

}
