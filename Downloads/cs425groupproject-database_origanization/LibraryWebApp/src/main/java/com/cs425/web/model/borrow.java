package com.cs425.web.model;

import java.sql.Date;

public class borrow {
	private String D_ID;
	private String M_ID;
	private String reserve_date;
	private String return_date;
	
	public borrow() {
		
	}
	
	 public borrow(String id) {
	        this.D_ID = id;
	    }
	 
    public borrow(String D_ID, String M_ID, String reserve_date, String return_date) {
    	this.D_ID = D_ID;
        this.M_ID = M_ID;
        this.reserve_date = reserve_date;
        this.return_date = return_date;
        
    }
	
	public String getD_ID() {
		return D_ID;
	}
	public void setD_ID(String d_ID) {
		D_ID = d_ID;
	}
	public String getM_ID() {
		return M_ID;
	}
	public void setM_ID(String m_ID) {
		M_ID = m_ID;
	}
	public String getReserve_date() {
		return reserve_date;
	}
	public void setReserve_date(String reserve_date) {
		this.reserve_date = reserve_date;
	}
	public String getReturn_date() {
		return return_date;
	}
	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}
	@Override
	public String toString() {
		return "borrow[D_ID= "+ D_ID+", M_ID="+M_ID+", reserve_date="+reserve_date+", return_date="+return_date+"]";
	}
	

}
