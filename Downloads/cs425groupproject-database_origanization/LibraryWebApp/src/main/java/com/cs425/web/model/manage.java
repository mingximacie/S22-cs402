package com.cs425.web.model;

public class manage {
	private String L_ID;
	private String D_ID;
	public String getL_ID() {
		return L_ID;
	}
	public void setL_ID(String l_ID) {
		L_ID = l_ID;
	}
	public String getD_ID() {
		return D_ID;
	}
	public void setD_ID(String d_ID) {
		D_ID = d_ID;
	}
	@Override
	public String toString() {
		return "manage[L_ID= "+ L_ID+", D_ID="+D_ID+"]";
	}
	

}
