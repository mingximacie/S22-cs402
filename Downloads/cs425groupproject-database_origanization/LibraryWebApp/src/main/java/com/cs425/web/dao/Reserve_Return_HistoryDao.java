package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cs425.web.model.Reserve_Return_History;


public class Reserve_Return_HistoryDao {
	
	    final String url = "jdbc:postgresql://localhost:5432/LibraryManagement";
		final String user = "postgres";
		final String password = "1234";//"<add your password>";

		public Reserve_Return_History getReserve_Return_History(String M_ID) {
			
			   
			
	        String mySQL = "SELECT M_ID, reserve_date, return_date"
	        		+ "FROM Reserve_Return_History "
	        		+ "WHERE M_ID = ?";
	        
	        Reserve_Return_History ob1 = new Reserve_Return_History();

			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try (Connection conn = DriverManager.getConnection(url, user, password);
		 		    PreparedStatement pStmt = conn.prepareStatement(mySQL)){
		 			
		 		pStmt.setString(1, M_ID.trim());
		 		
	            ResultSet rs = pStmt.executeQuery();
	            
	            while (rs.next()) {
	            	/* Retrieves the value of the designated column in the current row 
	            	   of this ResultSet object as a String in the Java programming language.
	            	*/
	            	ob1.setM_ID(rs.getString("M_ID"));
	            	ob1.setReserve_date(rs.getString("reserve_date")); 
	                ob1.setReturn_date(rs.getString("return_date"));
	               
	            }
	       }catch (SQLException e) {
	    		 System.out.println(e.getMessage());
	       }
			
			return ob1;
		
		}
	}



