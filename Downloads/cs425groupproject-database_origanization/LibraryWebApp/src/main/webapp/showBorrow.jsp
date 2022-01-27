<%@ page import="com.cs425.web.model.borrow"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Borrow Information</title>
</head>
<body>
  <%
    borrow ob2 = (borrow) request.getAttribute("d_id");
    out.println(ob2);
  %>
</body>
</html>