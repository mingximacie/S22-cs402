package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cs425.web.model.Key_words;

public class Key_wordsDao {

    final String url = "jdbc:postgresql://localhost:5432/LibraryManagement";
	final String user = "postgres";
	final String password = "1234";//"<add your password>";

	public Key_words getKey_words(String D_ID) {
		
		   
		
        String mySQL = "SELECT D_ID, key_words"
        		+ "FROM Key_words "
        		+ "WHERE id = ?";
        
		Key_words ob1 = new Key_words();

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
            	ob1.setKey_words(rs.getString("key_words")); 
            }
       }catch (SQLException e) {
    		 System.out.println(e.getMessage());
       }
		
		return ob1;
	
	}
}