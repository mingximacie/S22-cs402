package com.cs425.web.model;

import java.sql.Date;

public class Book {
	private String D_ID;
	private String ISBN;
	private String title;
	private long publish_date;
	
	
	
	public Book() {
	
	}
	
	 public Book(String id) {
	        this.D_ID = id;
	    }
	 
    public Book(String D_ID, String ISBN, String title, long publish_date) {
        this(ISBN, title, publish_date);
        this.D_ID = D_ID;
    }
    
    public Book(String ISBN, String title, long publish_date) {
    	this.ISBN = ISBN;
    	this.title = title;
    	this.publish_date = publish_date;
    }
	
	public String get_ID() {
		return D_ID;
	}
	public void setD_ID(String id) {
		D_ID = id;
	}
	
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public long getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(long publish_date) {
		this.publish_date = publish_date;
	}
	@Override
	public String toString() {
		return "Book [ID=" + D_ID + ", ISBN=" + ISBN + ", title=" + title + ", publish_date="+publish_date+ "]";
	}

}
