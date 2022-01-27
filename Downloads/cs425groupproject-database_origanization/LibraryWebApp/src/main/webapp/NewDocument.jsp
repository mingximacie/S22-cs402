<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Document Management</title>
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
	<center>
        <h1>Document Management</h1>
        	<button type="submit" class="button button2" onclick="document.location='NewDocument.jsp'" >Add More New Document</button>
    </center>
    <div align="center">
    	<form action="AddDocument" method="get">  
       		<table border="1" cellpadding="5">
       			<tr>
       				<th>Document ID: </th>
       				<td>
       					<input type="text" name="iID1" size="45"/>	
       				</td>
       			</tr>
       			<tr>
       				<th>Location: </th>
       				<td>
       					<input type="text" name="iID2" size="45"/>
       				</td>
       			</tr>
       			<tr>
       				<th>Type: </th>
       				<td>
       					<input type="text" name="iID3" size="45"/>
       				</td>
       			</tr>
       			<tr>
       				<th>Category: </th>
       				<td>
       					<input type="text" name="iID4" size="45"/>
       				</td>
       			</tr>
			</table> 
			<input type="submit" class="button button2" align="center"/> 
		</form>
    
    </div>
</body>
</html>