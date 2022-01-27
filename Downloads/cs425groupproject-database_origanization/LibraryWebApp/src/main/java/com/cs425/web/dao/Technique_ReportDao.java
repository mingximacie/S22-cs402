package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cs425.web.model.Technique_Report;


public class Technique_ReportDao {
	
	    final String url = "jdbc:postgresql://localhost:5432/LibraryManagement";
		final String user = "postgres";
		final String password = "1234";//"<add your password>";

		public Technique_Report getTechnique_Report(String D_ID) {
			
			   
			
	        String mySQL = "SELECT D_ID, ISSN, title, author, publish_date, category"
	        		+ "FROM Technique_Report "
	        		+ "WHERE D_ID = ?";
	        
			Technique_Report ob1 = new Technique_Report();

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
	            	ob1.setISSN(rs.getString("ISSN")); 
	                ob1.setTitle(rs.getString("title"));
	                ob1.setAuthor(rs.getString("author"));
	                ob1.setPublish_date(rs.getString("publish_date"));
	                ob1.setCategory(rs.getString("category"));
	               
	            }
	       }catch (SQLException e) {
	    		 System.out.println(e.getMessage());
	       }
			
			return ob1;
		
		}
	}



