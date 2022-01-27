package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cs425.web.model.address;


public class addressDao {
	
	    final String url = "jdbc:postgresql://localhost:5432/LibraryManagement";
		final String user = "postgres";
		final String password = "1234";//"<add your password>";

		public address getAddress(String ID) {
			
			   
			
	        String mySQL = "SELECT ID, L_ID, M_ID, street, apt_num, city, state,zip"
	        		+ "FROM address "
	        		+ "WHERE ID = ?";
	        
	        address ob1 = new address();

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
	            	ob1.setStreet(rs.getString("street"));
	            	ob1.setApt_num(rs.getString("apt_num"));
	            	ob1.setCity(rs.getString("city")); 
	            	ob1.setState(rs.getString("state"));
	            	ob1.setZip(rs.getString("zip"));
	            
	               
	            }
	       }catch (SQLException e) {
	    		 System.out.println(e.getMessage());
	       }
			
			return ob1;
		
		}
	}



