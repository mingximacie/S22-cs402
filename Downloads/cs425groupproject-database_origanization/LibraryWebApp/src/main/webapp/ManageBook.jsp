<%@ page import="com.cs425.web.model.Book"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Books</title>
	<style>
	.button {
	  border: none;
	  color: white;
	  padding: 15px 32px;
	  text-align: center;
	  text-decoration: none;
	  display: inline-block;
	  font-size: 16px;
	  margin: 4px 2px;
	  cursor: pointer;
	}
	
	.button1 {background-color: #A3D2CA;} /* light green */
	.button2 {background-color: #5EAAA8;} /* green */
	.button3 {background-color: #056676;} /* dark green */
	.button4 {background-color: #DA7F8F;} /* vintage red */ 
	
	</style>
	</head>
	<body>
	  
	 <% ArrayList<Book> std = (ArrayList<Book>)request.getAttribute("listBook");
	  for(Book s:std){
	 }%>
	          
</form>

<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Books</h2>
            <h3>
        	<a href="/new" class="button button2">Add New Book</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="/list" class="button button2">List All Books</a>           
        	</h3>
            </caption>
            
            <tr>
                <th>ID</th>
                <th>ISBN</th>
                <th>Title</th>
                <th>Publish Date</th>
                <th>Actions</th>
            </tr>
            <%
        	for(Book s:std){%>
            <tr>
                <td><%=s.get_ID()%></td>
                <td><%=s.getISBN()%></td>
                <td><%=s.getTitle()%></td>
                <td><%=s.getPublish_date()%></td>
                <td>
                        <a href="/edit?id=<%=s.get_ID()%>" class="button button2">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                       <button type="submit" class="button button4" onclick="document.location='DeleteBook.jsp'" >Delete</button>
                    </td>
                
            </tr>
            <%}%>
        </table>
    </div> 
    <center>
    <br/><br/> 
    <button type="submit" class="button button4" onclick="document.location='librarianhome.jsp'" >Back</button>
    </center>
    
</body>
</html>