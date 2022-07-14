<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name=request.getParameter("name");
	String value=request.getParameter("value");
	if(name!=null && value!=null){
		application.setAttribute(name, value);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(name!=null && value!=null){
		%>
		<%=name%>=<%=value %>
<%
	}else{
		out.print("application 속성 없음.");
	
	}
%>
</body>
</html>