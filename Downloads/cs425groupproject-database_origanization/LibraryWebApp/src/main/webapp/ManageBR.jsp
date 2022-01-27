<%@ page import="com.cs425.web.model.borrow"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Borrow/Return</title>
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
	  
	 <% ArrayList<borrow> std = (ArrayList<borrow>)request.getAttribute("listBook");
	  for(borrow b:std){
	 }%>
	          
</form>

<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Borrow/Return</h2>
            <h3>
        	<a href="/new" class="button button2">Add New Borrow/Return</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="/list" class="button button2">List All Borrow/Return</a>           
        	</h3>
            </caption>
            
            <tr>
                <th>Document ID</th>
                <th>Member ID</th>
                <th>Reserve Date</th>
                <th>Return Date</th>
                <th>Actions</th>
            </tr>
            <%
        	for(borrow b:std){%>
        	
            <tr>
                <td><%=b.getD_ID()%></td>
                <td><%=b.getM_ID()%></td>
                <td><%=b.getReserve_date()%></td>
                <td><%=b.getReturn_date()%></td>
                <td>
                        <a href="/edit?id=<%=b.getD_ID()%>" class="button button2">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<%=b.getD_ID()%>" class="button button4">Delete</a>                     
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