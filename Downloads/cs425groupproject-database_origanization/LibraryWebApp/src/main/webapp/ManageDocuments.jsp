<%@ page import="com.cs425.web.model.Documents"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Documents</title>
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
  
 <% ArrayList<Documents> std = (ArrayList<Documents>)request.getAttribute("listBook");
  for(Documents s:std){
 }%>
  
  
          
</form>

<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Documents</h2>
            <h3>
            <button type="submit" class="button button2" onclick="document.location='NewDocument.jsp'" >Add New Document</button>
        	&nbsp;&nbsp;&nbsp;
        	<a href="/list" class="button button2">List All Documents</a>           
        	</h3>
            </caption>
            
            <tr>
                <th>ID</th>
                <th>Location</th>
                <th>Type</th>
                <th>Category</th>
                <th>Actions</th>
            </tr>
            <%
        	for(Documents s:std){%>
        	<%-- Arranging data in tabular form
        	--%>
            <tr>
                <td><%=s.getD_ID()%></td>
                <td><%=s.getLocation()%></td>
                <td><%=s.getType()%></td>
                <td><%=s.getCategory()%></td>
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