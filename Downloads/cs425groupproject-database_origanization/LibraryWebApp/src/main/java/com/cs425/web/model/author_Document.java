package com.cs425.web.model;

import java.sql.Date;

public class author_Document {
	private String D_ID;
	private String author;
	
	public author_Document() {
    }

	public author_Document(String id, String author) {
		this.D_ID  = id;
		this.author = author;
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
	@Override
	public String toString() {
		return "Author_Document [ID=" + D_ID + ",  author=" + author + "]";
	}
	

}
