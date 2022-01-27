package com.cs425.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import java.sql.Statement;




import com.cs425.web.model.Documents;

public class DocumentsDao {

    final String url = "jdbc:postgresql://localhost:5432/LibraryManagement";
	final String user = "postgres";
	final String password = "postgres";//"<add your password>";
	
	 
	 public Documents getDocuments(String D_ID) {
	        String mySQL = "SELECT D_ID, location, type, category "
	        		+ "FROM Documents "
	        		+ "WHERE D_Id = ?";
	        
			Documents ob1 = new Documents();

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
	            	ob1.setLocation(rs.getString("location")); 
	                ob1.setType(rs.getString("type"));
	                ob1.setCategory(rs.getString("category"));
	            }
	       }catch (SQLException e) {
	    		 System.out.println(e.getMessage());
	       }
			return ob1;
		}
		

    public ArrayList<Documents> listAllDocuments() throws SQLException {
    	ArrayList<Documents> listDocuments = new ArrayList<>();
         
        String sql = "SELECT * FROM documents";
         
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
            String id = rs.getString("D_ID");
            String location = rs.getString("location");
            String type = rs.getString("type");
            String category = rs.getString("category");
             
            Documents book = new Documents(id, location, type, category);
            listDocuments.add(book);
        }
         
        return listDocuments;
    	}
	
    }	
	
	
	public void InsertDocument(String D_ID, String location, String type, String category) throws SQLException {
		 String mySQL = "insert into Documents(D_ID, location, type, category) "
	        		+ "values(?, ?, ?, ?)  ";

	        try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try (Connection conn = DriverManager.getConnection(url, user, password);
		 		    PreparedStatement pStmt = conn.prepareStatement(mySQL)){
		 			
		 		pStmt.setString(1, D_ID.trim());
		 		pStmt.setString(2, location.trim());
		 		pStmt.setString(3, type.trim());
		 		pStmt.setString(4, category.trim());
		 		ResultSet rs = pStmt.executeQuery();
		 		if (!rs.next())
                JOptionPane.showMessageDialog(null, "Successfully insert");
	              else
                JOptionPane.showMessageDialog(null, "Error");
                  
	    	}
	}
	
	
}