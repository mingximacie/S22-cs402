package com.cs425.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cs425.web.dao.MagazinesDao;
import com.cs425.web.model.Magazines;

/**
 * Servlet implementation class GetInformationController
 */
public class GetMagazine extends HttpServlet {
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
		
		String author = request.getParameter("iID").toString();
		//Servlet should only fetch and accept the request and no JDBC processing
		// Use Dao the take care of JDBC processing
		MagazinesDao od1  =  new MagazinesDao();
		
		Magazines ob1 = od1.getMagazines(author);
		
		// To display the data, create a JSP file (e.g., ShowInstructor.jsp)
		
		
		// To send the Instructor object ob1 to JSP file. (e.g., ShowInstructor.jsp) 
		request.setAttribute("d_id", ob1);  // fetch this attribute in the JSP file
		
		
		
		// To call JSP page that will display the data either using dispatcher or send redirect.
		
		RequestDispatcher rd = request.getRequestDispatcher("showAuthor.jsp");
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

