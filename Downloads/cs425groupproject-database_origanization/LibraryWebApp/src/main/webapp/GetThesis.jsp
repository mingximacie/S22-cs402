<%@ page import="com.cs425.web.model.Thesis"%>
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
  Thesis ob2 = (Thesis) request.getAttribute("d_id");
    out.println(ob2);
  %>
</body>
</html>