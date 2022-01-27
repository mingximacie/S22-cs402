package com.cs425.web.model;



public class Copies {
	
	
	
	private String D_ID;
	private String Copy_ID;
	private String location;
	private String borrowed;
	
	public Copies() {
		
	}
	
	 public Copies(String id) {
	        this.D_ID = id;
	    }
	 
    public Copies(String D_ID, String Copy_ID, String location, String borrowed) {
    	this.D_ID = D_ID;
        this.Copy_ID = Copy_ID;
        this.location = location;
        this.borrowed = borrowed;
        
    }
	
	public String getD_ID() {
		return D_ID;
	}
	
	
	public void setD_ID(String D_ID) {
		this.D_ID = D_ID;
	}
	
	
	public String getCopy_ID() {
		return Copy_ID;
	}
	public void setCopy_ID(String Copy_ID) {
		this.Copy_ID = Copy_ID;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getBorrowed() {
		return borrowed;
	}
	public void SetBorrowed(String Borrowed) {
		this.borrowed = Borrowed;
	}
	
	@Override
	public String toString() {
		return "Copies [ID=" + D_ID + ",Copy_ID="+ Copy_ID +", location="+location+", borrowed="+ borrowed+ "]";
	}
	

}
