<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Enumeration<String> en=application.getAttributeNames();
	while(en.hasMoreElements()){
		String key=en.nextElement();
		out.print(key+" = "+application.getAttribute(key)+"<br>");
	}
%>
</body>
</html>