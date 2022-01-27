<%@ page import="com.cs425.web.model.Copies"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Copies</title>
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
	  
	 <% ArrayList<Copies> std = (ArrayList<Copies>)request.getAttribute("listBook");
	  for(Copies s:std){
	 }%>
	          
</form>

<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Copies</h2>
            <h3>
        	<a href="/new" class="button button2">Add New Copies</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="/list" class="button button2">List All Copies</a>           
        	</h3>
            </caption>
            
            <tr>
                <th>ID</th>
                <th>Copy ID</th>
                <th>Location</th>
                <th>Borrowed</th>
                <th>Actions</th>
            </tr>
            <%
        	for(Copies s:std){%>
        	
            <tr>
                <td><%=s.getD_ID()%></td>
                <td><%=s.getCopy_ID()%></td>
                <td><%=s.getLocation()%></td>
                <td><%=s.getBorrowed()%></td>
                <td>
                        <a href="/edit?id=<%=s.getD_ID()%>" class="button button2">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<%=s.getD_ID()%>" class="button button4">Delete</a>                     
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