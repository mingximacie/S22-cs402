package com.cs425.web.model;

public class Members {

	private String ID;
	private String email;
	private String name;
	private String password;
	
	
	 public Members() {
	    }
	
	 public Members(String ID, String email, String name, String password ) {
	        this.ID = ID;
	        this.email = email;
	        this.name = name;
	        this.password = password;
	    }
	
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "Members [ID=" + ID + ", name=" + name + ", email=" + email + "]";
	}
}
