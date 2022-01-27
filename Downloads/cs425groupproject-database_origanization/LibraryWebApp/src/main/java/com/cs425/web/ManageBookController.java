package com.cs425.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cs425.web.dao.BookDao;
import com.cs425.web.dao.DocumentsDao;
import com.cs425.web.model.Book;
import com.cs425.web.model.Documents;

/**
 * Servlet implementation class ManageBookController
 */
public class ManageBookController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
            switch (action) {
            
            default:
                listBook(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
    private void listBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	BookDao od1  =  new BookDao();
  	    List< Book>  ob1 = od1.listAllBooks();
        request.setAttribute("listBook", ob1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ManageBook.jsp");
        dispatcher.forward(request, response);
    }
	
	 
}	 

