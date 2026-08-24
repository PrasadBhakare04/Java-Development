<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP WEB APP</title>
</head>
<body>
<h1>Jsp web app to generate Dynamic Response</h1>
<%@
	page import="java.util.Date"
%>

<% 
	String name = request.getParameter("username");
	String city = request.getParameter("city");
%>
<h1>Your city is </h1>
<%= 
	city
%>
</body>
</html>