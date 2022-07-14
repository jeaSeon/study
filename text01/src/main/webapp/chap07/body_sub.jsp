<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
body_sub에서 name 파라미터 값 = <%=request.getParameter("name") %>
<br>

name 파라미터 값 목록:

<ul>
	<%
	String[] names=request.getParameterValues("name");
	/* 밸류 값들이 많으니까 values로, + 리턴값이 string 배열 */
	for(String name:names){
		%>
		<li> <%=name %></li>
		
	<%
	}
	%>
</ul>
</body>
</html>