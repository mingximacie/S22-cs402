package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cs425.web.model.Thesis;


public class ThesisDao {
	
	    final String url = "jdbc:postgresql://localhost:5432/LibraryManagement";
		final String user = "postgres";
		final String password = "postgres";//"<add your password>";

		public Thesis getThesis(String title) {
			
			   
			
	        String mySQL = "SELECT *"
	        		+ "FROM Thesis "
	        		+ "WHERE title = ?";
	        
			Thesis ob1 = new Thesis();

			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try (Connection conn = DriverManager.getConnection(url, user, password);
		 		    PreparedStatement pStmt = conn.prepareStatement(mySQL)){
		 			
		 		pStmt.setString(1, title.trim());
		 		
	            ResultSet rs = pStmt.executeQuery();
	            
	            while (rs.next()) {
	            	/* Retrieves the value of the designated column in the current row 
	            	   of this ResultSet object as a String in the Java programming language.
	            	*/
	            	ob1.setD_ID(rs.getString("D_ID"));
	            	ob1.setDOI(rs.getString("DOI")); 
	                ob1.setTitle(rs.getString("title"));
	                
	                ob1.setPublish_date(rs.getInt("publish_date"));
	              
	            }
	       }catch (SQLException e) {
	    		 System.out.println(e.getMessage());
	       }
			
			return ob1;
		
		}
	}


