<%@ page import="com.cs425.web.model.author_Document"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Instructor Information</title>
</head>
<body>
  
 <% ArrayList<author_Document> std = (ArrayList<author_Document>)request.getAttribute("listBook");
  for(author_Document s:std){
      
    out.println(s);
    out.println("<html><body><pre>");
  }%>
          
</form>
</body>
</html>