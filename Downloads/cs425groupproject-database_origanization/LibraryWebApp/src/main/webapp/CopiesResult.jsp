<%@ page import="com.cs425.web.model.Copies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Copies Results</title>
</head>
<body>
  <%
    Copies ob2 = (Copies) request.getAttribute("d_id");
    out.println(ob2);
  %>
</body>
</html>