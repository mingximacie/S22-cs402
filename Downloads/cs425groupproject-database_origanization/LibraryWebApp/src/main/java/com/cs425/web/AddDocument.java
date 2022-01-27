package com.cs425.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cs425.web.dao.DocumentsDao;
import com.cs425.web.model.Documents;

/**
 * Servlet implementation class GetInformationController
 */
public class AddDocument extends HttpServlet {
	/*
	 * private static final long serialVersionUID = 1L;
	 * 
	 *//**
		 * @see HttpServlet#HttpServlet()
		 *//*
			 * public GetInformationController() { super(); // TODO Auto-generated
			 * constructor stub }
			 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String author = request.getParameter("iID1").toString();
		String author2 = request.getParameter("iID2").toString();
		String author3 = request.getParameter("iID3").toString();
		String author4 = request.getParameter("iID4").toString();
		//Servlet should only fetch and accept the request and no JDBC processing
		// Use Dao the take care of JDBC processing
		 DocumentsDao ob1 = new DocumentsDao();
		 try {
			ob1.InsertDocument(author, author2, author3, author4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// To display the data, create a JSP file (e.g., ShowInstructor.jsp)
		
		
		// To send the Instructor object ob1 to JSP file. (e.g., ShowInstructor.jsp) 
		request.setAttribute("d_id", ob1);  // fetch this attribute in the JSP file
		
		
		
		// To call JSP page that will display the data either using dispatcher or send redirect.
		
		RequestDispatcher rd = request.getRequestDispatcher("NewDocument.jsp");
		rd.forward(request, response);
	
		
	}

	/*	*//**
			 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
			 *      response)
			 *//*
				 * protected void doPost(HttpServletRequest request, HttpServletResponse
				 * response) throws ServletException, IOException { // TODO Auto-generated
				 * method stub doGet(request, response); }
				 */

}

