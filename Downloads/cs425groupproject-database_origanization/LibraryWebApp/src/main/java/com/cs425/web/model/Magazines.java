package com.cs425.web.model;

import java.sql.Date;

public class Magazines {
	private String Magazine_ID;
	private String ISSN;
	private String title;
	private String editor;
	private String contributors;
	private int publish_date;
	
	public String getD_ID() {
		return Magazine_ID;
	}
	public void setD_ID(String d_ID) {
		Magazine_ID = d_ID;
	}
	public String getISSN() {
		return ISSN;
	}
	public void setISSN(String iSSN) {
		ISSN = iSSN;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
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
	public String getContributors() {
		return contributors;
	}
	public void setContributors(String contributors) {
		this.contributors = contributors;
	}

	@Override
	public String toString() {
		return "Magazines [ID=" + Magazine_ID + ",ISSN="+ISSN+", title=" + title +", editor=" + editor +", contributors="+contributors+", publish_date="+publish_date+"]";
	}
	

}
