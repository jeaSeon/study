<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="chap11.Thermometer" %>
<%
Thermometer thermometer= new Thermometer();
request.setAttribute("t", thermometer);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${t.setCelsius('서울',27.3) }
	서울온도 : 섭씨${t.getCelsius('서울')}더/화씨 &{t.getFahrenhdit('서울'),)
	<br>
	
	정보: &{t.info}
</body>
</html>