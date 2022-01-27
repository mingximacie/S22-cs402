package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cs425.web.model.Documents;
import com.cs425.web.model.Members;


public class MembersDao {

    final String url = "jdbc:postgresql://localhost:5432/LibraryManagement";
	final String user = "postgres";
	final String password = "postgres";//"<add your password>";

	public Members getMembers(String mID) {
		
        String mySQL = "SELECT * "
        		+ "FROM Members "
        		+ "WHERE id = ?";
        
		Members ob1 = new Members();

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(url, user, password);
	 		    PreparedStatement pStmt = conn.prepareStatement(mySQL)){
	 			
	 		pStmt.setString(1, mID.trim());
	 		
            ResultSet rs = pStmt.executeQuery();
            
            while (rs.next()) {
            	/* Retrieves the value of the designated column in the current row 
            	   of this ResultSet object as a String in the Java programming language.
            	*/
            	ob1.setID(rs.getString("id"));
            	ob1.setEmail("email");            	
            	ob1.setName(rs.getString("name")); 
                ob1.setEmail(rs.getString("password"));
            }
       }catch (SQLException e) {
    		 System.out.println(e.getMessage());
       }
		
		return ob1;
	
	}
	
	
	
	  public ArrayList<Members> listAllMembers() throws SQLException {
	    	ArrayList<Members> listMembers = new ArrayList<>();
	         
	        String sql = "SELECT * FROM Members";
	         
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
	            String M_ID = rs.getString("M_ID");
	            String email = rs.getString("email");
	            String name = rs.getString("name");
	            String password = rs.getString("password");
	             
	            Members member = new  Members(M_ID, email, name, password);
	            listMembers.add(member);
	        }
	         
	  
	 
	         
	        return listMembers;
	    }
		
		
	    }	
	
	
	
	
	
	
	
	
	
	
	
}