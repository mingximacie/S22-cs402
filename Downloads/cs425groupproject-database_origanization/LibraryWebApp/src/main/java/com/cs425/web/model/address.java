package com.cs425.web.model;

public class address {
	
	private String ID;
	private String L_ID;
	private String M_ID;
	private String street;
	private String apt_num;
	private String city;
	private String state;
	private String zip;
	public String getL_ID() {
		return L_ID;
	}
	public void setL_ID(String l_ID) {
		L_ID = l_ID;
	}
	public String getM_ID() {
		return M_ID;
	}
	public void setM_ID(String m_ID) {
		M_ID = m_ID;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getApt_num() {
		return apt_num;
	}
	public void setApt_num(String apt_num) {
		this.apt_num = apt_num;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "adress[ID="+ID+" ,L_ID= "+ L_ID+", M_ID="+M_ID+", street="+street+", apt_num="+apt_num+", city="+city+", state"+ state +", zip="+zip+"]";
	}
}
