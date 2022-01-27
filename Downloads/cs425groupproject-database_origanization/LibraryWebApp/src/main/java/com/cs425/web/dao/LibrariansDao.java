package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cs425.web.model.Librarians;

public class LibrariansDao {

    final String url = "jdbc:postgresql://localhost:5432/LibraryManagement";
	final String user = "postgres";
	final String password = "1234";//"<add your password>";

	public Librarians getLibrarians(String lID) {
		
		   
		
        String mySQL = "SELECT id, name, password, zip "
        		+ "FROM Librarians "
        		+ "WHERE id = ?";
        
		Librarians ob1 = new Librarians();

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(url, user, password);
	 		    PreparedStatement pStmt = conn.prepareStatement(mySQL)){
	 			
	 		pStmt.setString(1, lID.trim());
	 		
            ResultSet rs = pStmt.executeQuery();
            
            while (rs.next()) {
            	/* Retrieves the value of the designated column in the current row 
            	   of this ResultSet object as a String in the Java programming language.
            	*/
            	ob1.setID(rs.getString("id"));
            	ob1.setName(rs.getString("name")); 
                ob1.setPassword(rs.getString("password"));
            }
       }catch (SQLException e) {
    		 System.out.println(e.getMessage());
       }
		
		return ob1;
	
	}
}