package com.cs425.web.model;

import java.sql.Date;

public class Technique_Report {
	private String D_ID;
	private String ISSN;
	private String title;
	private String author;
	private String publish_date;
	private String category;
	
	public String getD_ID() {
		return D_ID;
	}
	public void setD_ID(String id) {
		D_ID = id;
	}
	public String getISSN() {
		return ISSN;
	}
	public void setISSN(String ISSN) {
		this.ISSN = ISSN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Technique_Report [ID=" + D_ID + ", ISSN=" + ISSN + ", title=" + title + ", author=" + author +", publish_date="+publish_date+ ", category"+category+"]";
	}

}
