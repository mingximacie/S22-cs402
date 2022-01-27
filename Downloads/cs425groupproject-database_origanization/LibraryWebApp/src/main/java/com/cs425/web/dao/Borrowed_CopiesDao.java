package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cs425.web.model.Borrowed_Copies;


public class Borrowed_CopiesDao {
	
	    final String url = "jdbc:postgresql://localhost:5432/LibraryManagement";
		final String user = "postgres";
		final String password = "1234";//"<add your password>";

		public Borrowed_Copies getBorrow(String Copy_ID) {
			
			   
			
	        String mySQL = "SELECT Copy_ID, M_ID, Borrowed_time "
	        		+ "FROM Borrowed_Copies "
	        		+ "WHERE Copy_ID = ?";
	        
	        Borrowed_Copies ob1 = new Borrowed_Copies();

			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try (Connection conn = DriverManager.getConnection(url, user, password);
		 		    PreparedStatement pStmt = conn.prepareStatement(mySQL)){
		 			
		 		pStmt.setString(1, Copy_ID.trim());
		 		
	            ResultSet rs = pStmt.executeQuery();
	            
	            while (rs.next()) {
	            	/* Retrieves the value of the designated column in the current row 
	            	   of this ResultSet object as a String in the Java programming language.
	            	*/
	            	ob1.setCopy_ID(rs.getString("Copy_ID"));
	            	ob1.setM_ID(rs.getString("M_ID")); 
	                ob1.setBorrowed_time(rs.getString("Borrowed_time"));
	                
	               
	            }
	       }catch (SQLException e) {
	    		 System.out.println(e.getMessage());
	       }
			
			return ob1;
		
		}
	}



