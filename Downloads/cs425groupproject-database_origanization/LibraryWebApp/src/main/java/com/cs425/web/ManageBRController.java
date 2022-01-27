package com.cs425.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cs425.web.dao.borrowDao;
import com.cs425.web.model.borrow;

/**
 * Servlet implementation class ManageBRController
 */
public class ManageBRController extends HttpServlet {
	
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
    	borrowDao od1  =  new borrowDao();
  	    List< borrow>  ob1 = od1.listAllBorrows();
        request.setAttribute("listBook", ob1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ManageBR.jsp");
        dispatcher.forward(request, response);
    }

}
