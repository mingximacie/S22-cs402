package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cs425.web.model.Book;
import com.cs425.web.model.Copies;


public class CopiesDao {
	
	    final String url = "jdbc:postgresql://localhost:5432/LibraryManagement";
		final String user = "postgres";
		final String password = "postgres";//"<add your password>";

		public Copies getCopies(String Copy_ID) {
			
			   
			
	        String mySQL = "SELECT *"
	        		+ "FROM Copies "
	        		+ "WHERE Copy_ID = ?";
	        
	        Copies ob1 = new Copies();

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
	            	ob1.setD_ID(rs.getString("D_ID"));
	            	ob1.setCopy_ID(rs.getString("Copy_ID")); 
	                ob1.setLocation(rs.getString("location"));
	                ob1.SetBorrowed(rs.getString("borrowed"));
	               
	               
	            }
	       }catch (SQLException e) {
	    		 System.out.println(e.getMessage());
	       }
			
			return ob1;
		
		}
		
		public ArrayList<Copies> listAllCopies() throws SQLException {
	    	ArrayList<Copies> listCopies = new ArrayList<>();
	         
	        String sql = "SELECT * FROM Copies";
	         
	        try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try (Connection conn = DriverManager.getConnection(url, user, password);
		 		    PreparedStatement pStmt = conn.prepareStatement(sql)){
		 			
		 		
	     
		 		 ResultSet rs = pStmt.executeQuery();
	           
	         
		        while (rs.next()) {
		            String D_ID = rs.getString("D_ID");
		            String Copy_ID = rs.getString("Copy_ID");
		            String location = rs.getString("location");
		            String borrowed = rs.getString("borrowed");
		             
		            Copies copy = new Copies(D_ID, Copy_ID, location, borrowed);
		            listCopies.add(copy);
		        }
	        	return listCopies;
			}
		
	    }	
		

		 public void addCopies(String D_ID, String Copy_ID, String location, String borrowed) throws SQLException {
		        String mySQL = "insert into Copies values (?, ?, ?, ?)";
		        
			

				try {
					Class.forName("org.postgresql.Driver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try (Connection conn = DriverManager.getConnection(url, user, password);
			 		    PreparedStatement pStmt = conn.prepareStatement(mySQL)){
			 			
					pStmt.setString(1, D_ID.trim());
			 		pStmt.setString(2, Copy_ID.trim());
			 		pStmt.setString(3, location.trim());
			 		pStmt.setString(4, borrowed.trim());
		     
			 		 ResultSet rs = pStmt.executeQuery();
		    }	
		 }
	}



