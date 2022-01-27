<%@ page import="com.cs425.web.model.Citation"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Author Information</title>
</head>
<body>
  <%
  Citation ob2 = (Citation) request.getAttribute("d_id");
    out.println(ob2);
  %>
</body>
</html>