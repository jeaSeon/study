<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="util.Cookies" %>
<%
response.addCookie(Cookies.createCookie("name","최범균"));
response.addCookie(Cookies.createCookie("id","madvirus","text01/chap09",-1));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 Cookies를 사용하여 쿠키 생성
</body>
</html>