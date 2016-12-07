package net.etfbl.movies.model;



/*
 * Stores an RSS feed
 */
public class Feed {
	
	String title;
	String link;
	String description;
	String image;
	
	public Feed () {
		
	}

	public Feed(String title, String link, String description, String image) {
				this.title = title;
				this.link = link;
				this.description = description;
				this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public String getLink() {
		return link;
	}

	public String getDescription() {
		return description;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Feed [description=" + description + ", link=" + link + ", title=" + title + "]";
	}
	
	

}