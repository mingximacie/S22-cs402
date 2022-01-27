<%@ page import="com.cs425.web.model.Documents"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Documents Information</title>
</head>
<body>
  
 <% ArrayList<Documents> std = (ArrayList<Documents>)request.getAttribute("listBook");
  for(Documents s:std){
      
    out.println(s);
    out.println("<html><body><pre>");
  }%>
          
</form>
</body>
</html>