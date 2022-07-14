<%@page import="javax.swing.text.AbstractDocument.Content"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	HttpServletRequest httpRequest=
	(HttpServletRequest)pageContext.getRequest();
%>

<%=request == httpRequest %>


<% pageContext.getOut().println("안녕하세용"); %>
<%out.print("hello"); %>
</body>
</html>