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
초기화 파라미터 목록:
<ul>
<%
Enumeration<String> en=application.getInitParameterNames();
while(en.hasMoreElements()){
	String initParamName=en.nextElement();
%>
	<li><%=initParamName %>=
	<%=application.getInitParameter(initParamName) %>
	
<%
}
%>

</ul>
</body>
</html>