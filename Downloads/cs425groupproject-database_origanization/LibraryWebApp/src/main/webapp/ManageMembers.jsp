<%@ page import="com.cs425.web.model.Members"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Members</title>
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
	  
	 <% ArrayList<Members> std = (ArrayList<Members>)request.getAttribute("listBook");
	  for(Members s:std){
	 }%>
	          
</form>

<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Members</h2>
            <h3>
        	<a href="/new" class="button button2">Add New Member</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="/list" class="button button2">List All Members</a>           
        	</h3>
            </caption>
            
            <tr>
                <th>ID</th>
                <th>Email</th>
                <th>Name</th>
                <th>Password</th>
                <th>Actions</th>
            </tr>
            <%
        	for(Members s:std){%>
        	
            <tr>
                <td><%=s.getID()%></td>
                <td><%=s.getEmail()%></td>
                <td><%=s.getName()%></td>
                <td><%=s.getPassword()%></td>
                <td>
                        <a href="/edit?id=<%=s.getID()%>" class="button button2">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<%=s.getID()%>" class="button button4">Delete</a>                
                    </td>
                
            </tr>
            <%}%>
        </table>
    </div> 
</body>
</html>