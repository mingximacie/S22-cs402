package com.cs425.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cs425.web.dao.Author_documentsDao;

import com.cs425.web.model.author_Document;

/**
 * Servlet implementation class GetInformationController
 */
public class GetidFromAuthor extends HttpServlet {
	
	
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
    	String author = request.getParameter("iID").toString();
    	Author_documentsDao od1  =  new Author_documentsDao();
  	    List< author_Document>  ob1 = od1.getIDByAuthor(author);
        request.setAttribute("listBook", ob1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ResultAuthorfromID.jsp");
        dispatcher.forward(request, response);
    }
	
	

}