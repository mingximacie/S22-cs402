package com.cs425.web.model;

import java.sql.Date;

public class Reserve_Return_History {
	private String M_ID;
	private String reserve_date;
	private String return_date;
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
		return "Reserve_Return_History[M_ID= "+ M_ID+", reserve_date="+reserve_date+", return_date="+return_date+"]";
	}
	
	

}
