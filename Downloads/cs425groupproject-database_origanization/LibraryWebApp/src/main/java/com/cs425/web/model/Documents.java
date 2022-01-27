package com.cs425.web.model;

public class Documents {

	private String D_ID;
	private String location;
	private String type;
	private String category;
	
	
	
	 public Documents() {
	    }
	
	 public Documents(String D_ID, String location, String type, String category ) {
	        this.D_ID = D_ID;
	        this.location = location;
	        this.type = type;
	        this.category = category;
	    }
	
	public String getD_ID() {
		return D_ID;
	}
	public void setD_ID(String iD) {
		D_ID = iD;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Documents [ID=" + D_ID + ", location=" + location + ", type=" + type + ", category=" + category + "]";
	}
}
