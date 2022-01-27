package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cs425.web.model.Copies;
import com.cs425.web.model.borrow;


public class borrowDao {
	
	    final String url = "jdbc:postgresql://localhost:5432/LibraryManagement";
		final String user = "postgres";
		final String password = "postgres";//"<add your password>";

		public borrow getBorrow(String D_ID) {
			
			   
			
	        String mySQL = "SELECT * "
	        		+ "FROM borrow "
	        		+ "WHERE D_ID = ?";
	        
	        borrow ob1 = new borrow();

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
	            	ob1.setM_ID(rs.getString("M_ID")); 
	                ob1.setReserve_date(rs.getString("reserve_date"));
	                ob1.setReturn_date(rs.getString("return_date"));
	               
	            }
	       }catch (SQLException e) {
	    		 System.out.println(e.getMessage());
	       }
			
			return ob1;
		
		}
		
		
		public ArrayList<borrow> listAllBorrows() throws SQLException {
	    	ArrayList<borrow> listBorrows = new ArrayList<>();
	         
	        String sql = "SELECT * FROM borrow";
	         
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
		            String M_ID = rs.getString("M_ID");
		            String reserve_date = rs.getString("reserve_date");
		            String return_date = rs.getString("return_date");
		             
		            borrow borrow = new borrow(D_ID, M_ID, reserve_date, return_date);
		            listBorrows.add(borrow);
		        }
	        	return listBorrows;
			}
		
	    }	
		

		 public void addBorrows(String D_ID, String M_ID, String reserve_date, String return_date) throws SQLException {
		        String mySQL = "insert into borrow values (?, ?, ?, ?)";
		        
			

				try {
					Class.forName("org.postgresql.Driver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try (Connection conn = DriverManager.getConnection(url, user, password);
			 		    PreparedStatement pStmt = conn.prepareStatement(mySQL)){
			 			
					pStmt.setString(1, D_ID.trim());
			 		pStmt.setString(2, M_ID.trim());
			 		pStmt.setString(3, reserve_date.trim());
			 		pStmt.setString(4, return_date.trim());
		     
			 		 ResultSet rs = pStmt.executeQuery();
		    }	
		 }
		
		
		
		
		
		
		
		
		
		
		
	}



