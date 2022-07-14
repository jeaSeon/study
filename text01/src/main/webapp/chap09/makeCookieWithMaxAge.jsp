<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie cookie=new Cookie("oneh","ltime");
	cookie.setMaxAge(60*60);
	response.addCookie(cookie);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
유효시간이 1시간인 쿠키 생성
</body>
</html>