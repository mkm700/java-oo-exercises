package blogz;

import java.util.Calendar;
import java.util.Date;

public class Post {
	private String title;
	private String body;
	private String author;
	private final Date created;
	private Date updated;
	
	public Post(String title, String body, String author) {
		this.title = title;
		this.body = body;
		this.author = author;
		this.created = Calendar.getInstance().getTime();
		this.updated = null;
	}
	
	//getters
	public String getTitle() {
		return this.title;
	}
	
	public String getBody() {
		return this.body;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public Date getCreated() {
		return this.created;
	}
	
	public Date getUpdated() {
		return this.updated;
	}
	
	//setters
	public void setTitle(String title) {
		this.title = title;
		this.setUpdated();
	}
	
	public void setBody(String body) {
		this.body = body;
		this.setUpdated();
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setUpdated() {
		this.updated = Calendar.getInstance().getTime();
	}
	
	//toString
	public String toString() {
		return title + "\n" + body + "\nBy: " + author + " on " + created + "\nLast updated on: " + updated;
	}
}
