<%@ page import="com.cs425.web.model.Documents"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Instructor Information</title>
</head>
<body>
  <%
    Documents ob2 = (Documents) request.getAttribute("Documents");
    out.println(ob2);
  %>
</body>
</html>