package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cs425.web.model.Journal_Articles;


public class Journal_ArticlesDao {
	
	    final String url = "jdbc:postgresql://localhost:5432/LibraryManagement";
		final String user = "postgres";
		final String password = "1234";//"<add your password>";

		public Journal_Articles getJournal_Articles(String D_ID) {
			
			   
			
	        String mySQL = "SELECT D_ID, ISSN, DOI, title, publish_date, category"
	        		+ "FROM Journal_Articles "
	        		+ "WHERE D_ID = ?";
	        
	        Journal_Articles ob1 = new Journal_Articles();

			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try (Connection conn = DriverManager.getConnection(url, user, password);
		 		    PreparedStatement pStmt = conn.prepareStatement(mySQL)){
		 			
		 		pStmt.setString(1, D_ID.trim());
		 		
	            ResultSet rs = pStmt.executeQuery();
	            
	            while (rs.next()) {
	            	/* Retrieves the value of the designated column in the current row 
	            	   of this ResultSet object as a String in the Java programming language.
	            	*/
	            	ob1.setD_ID(rs.getString("D_ID"));
	            	ob1.setDOI(rs.getString("DOI")); 
	                ob1.setTitle(rs.getString("title"));
	                ob1.setISSN(rs.getString("ISSN"));
	                ob1.setPublish_date(rs.getString("publish_date"));
	                ob1.setCategory(rs.getString("category"));
	               
	            }
	       }catch (SQLException e) {
	    		 System.out.println(e.getMessage());
	       }
			
			return ob1;
		
		}
	}



