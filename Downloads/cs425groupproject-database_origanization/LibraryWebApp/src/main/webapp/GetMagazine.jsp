<%@ page import="com.cs425.web.model.Magazines"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Magazine Information</title>
</head>
<body>
  <%
  Magazines ob2 = (Magazines) request.getAttribute("d_id");
    out.println(ob2);
  %>
</body>
</html>