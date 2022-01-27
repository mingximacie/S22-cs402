package com.cs425.web.model;

import java.sql.Date;

public class Thesis {
	private String D_ID;
	private String DOI;
	private String title;
	private int publish_date;
	
	public String getD_ID() {
		return D_ID;
	}
	public void setD_ID(String id) {
		D_ID = id;
	}
	public String getDOI() {
		return DOI;
	}
	public void setDOI(String doi) {
		DOI = doi;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(int publish_date) {
		this.publish_date = publish_date;
	}
	
	@Override
	public String toString(){
		return "Thesis [ID=" + D_ID + ", DOI=" + DOI + ", title=" + title + ",  publish_date="+publish_date+"]";
	}
}
	
