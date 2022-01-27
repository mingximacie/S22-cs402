package com.cs425.web.model;

public class phone_number {
	private String ID;
	private String L_ID;
	private String M_ID;
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
	@Override
	public String toString() {
		return "phone_number[ID="+ID+" ,L_ID= "+ L_ID+", M_ID="+M_ID+"]";
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	

}
