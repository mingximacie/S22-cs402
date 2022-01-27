package com.cs425.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cs425.web.dao.MembersDao;
import com.cs425.web.model.Members;
import java.util.ArrayList;
import java.util.List;
/**
 * Servlet implementation class GetInformationController
 */
public class AllMembers extends HttpServlet {
	
	
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
    	MembersDao od1  =  new MembersDao();
  	    List< Members>  ob1 = od1.listAllMembers();
        request.setAttribute("listBook", ob1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ManageMembers.jsp");
        dispatcher.forward(request, response);
    }
	
		
		
}
		