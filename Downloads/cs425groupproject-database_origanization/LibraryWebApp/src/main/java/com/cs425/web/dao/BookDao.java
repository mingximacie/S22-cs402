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




import com.cs425.web.model.Book;

public class BookDao {

    final String url = "jdbc:postgresql://localhost:5432/LibraryManagement";
	final String user = "postgres";
	final String password = "postgres";//"<add your password>";
	
	 
	public Book getBook(String D_ID) {
	       String mySQL = "SELECT D_ID, ISBN, title, publish_date "
	       				+ "FROM Book "
	       				+ "WHERE D_Id = ?";
			Book ob1 = new Book();

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
	            	ob1.setISBN(rs.getString("ISBN")); 
	                ob1.setTitle(rs.getString("title"));
	                ob1.setPublish_date(rs.getLong("publish_date"));
	            }
	       }catch (SQLException e) {
	    		 System.out.println(e.getMessage());
	       }
			return ob1;
		}


    public ArrayList<Book> listAllBooks() throws SQLException {
    	ArrayList<Book> listBooks = new ArrayList<>();
         
        String sql = "SELECT * FROM Book";
         
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
	            String ISBN = rs.getString("ISBN");
	            String title = rs.getString("title");
	            long publish_date = rs.getLong("publish_date");
	             
	            Book book = new Book(D_ID, ISBN, title, publish_date);
	            listBooks.add(book);
	        }
        	return listBooks;
		}
	
    }	
	

	 public void addBook(String D_ID, String ISBN, String title, long publish_date) throws SQLException {
	        String mySQL = "insert into Book values (?, ?, ?, ?)";

			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try (Connection conn = DriverManager.getConnection(url, user, password);
		 		    PreparedStatement pStmt = conn.prepareStatement(mySQL)){
		 			
				pStmt.setString(1, D_ID.trim());
		 		pStmt.setString(2, ISBN.trim());
		 		pStmt.setString(3, title.trim());
		 		pStmt.setString(4, Long.toString(publish_date).trim());
	     
		 		 ResultSet rs = pStmt.executeQuery();
	    }	
	 }


	 public Book DeleteBook(String D_ID) throws SQLException {

         String mySQL = "Delete "
         		+ "FROM book "
         		+ "WHERE D_Id = ?";
  	        
  	      Book b1 = new Book() ;
           b1 = null;
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
		 		if (!rs.next())
                JOptionPane.showMessageDialog(null, "Successfully Delete");
	else
                JOptionPane.showMessageDialog(null, "Error");
                    
  	    }
  			
  	       return b1; 
  	 }

}