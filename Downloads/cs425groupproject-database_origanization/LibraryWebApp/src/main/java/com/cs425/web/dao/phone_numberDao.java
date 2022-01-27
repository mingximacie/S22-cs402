package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cs425.web.model.phone_number;


public class phone_numberDao {
	
	    final String url = "jdbc:postgresql://localhost:5432/LibraryManagement";
		final String user = "postgres";
		final String password = "1234";//"<add your password>";

		public phone_number getphone_number(String ID) {
			
			   
			
	        String mySQL = "SELECT ID, L_ID, M_ID"
	        		+ "FROM phone_number "
	        		+ "WHERE ID = ?";
	        
	        phone_number ob1 = new phone_number();

			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try (Connection conn = DriverManager.getConnection(url, user, password);
		 		    PreparedStatement pStmt = conn.prepareStatement(mySQL)){
		 			
		 		pStmt.setString(1,ID.trim());
		 		
	            ResultSet rs = pStmt.executeQuery();
	            
	            while (rs.next()) {
	            	/* Retrieves the value of the designated column in the current row 
	            	   of this ResultSet object as a String in the Java programming language.
	            	*/
	            	ob1.setID(rs.getString("ID"));
	            	ob1.setL_ID(rs.getString("L_ID"));
	            	ob1.setM_ID(rs.getString("M_ID")); 
	                
	               
	            }
	       }catch (SQLException e) {
	    		 System.out.println(e.getMessage());
	       }
			
			return ob1;
		
		}
	}



