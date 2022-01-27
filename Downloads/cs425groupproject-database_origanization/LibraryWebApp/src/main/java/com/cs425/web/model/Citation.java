package com.cs425.web.model;

import java.sql.Date;

public class Citation {
	private String D_ID;
	private String title;
	private String author;
	private String publish_date;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getD_ID() {
		return D_ID;
	}
	public void setD_ID(String d_ID) {
		D_ID = d_ID;
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
	@Override
	public String toString() {
		return "Citation[D_ID= "+ D_ID+", title="+title+", author="+author+", publish_date="+publish_date+"]";
	}

}
