package com.cs425.web.model;

public class Borrowed_Copies {
	private String Copy_ID;
	private String M_ID;
	private String Borrowed_time;
	public String getCopy_ID() {
		return Copy_ID;
	}
	public void setCopy_ID(String copy_ID) {
		Copy_ID = copy_ID;
	}
	public String getM_ID() {
		return M_ID;
	}
	public void setM_ID(String m_ID) {
		M_ID = m_ID;
	}
	public String getBorrowed_time() {
		return Borrowed_time;
	}
	public void setBorrowed_time(String borrowed_time) {
		Borrowed_time = borrowed_time;
	}
	@Override
	public String toString() {
		return "Borrowed Copies =[Copy_ID="+Copy_ID+", M_ID="+M_ID+", borrowed_time ="+Borrowed_time+"]";
	}
	 
		
	

}
