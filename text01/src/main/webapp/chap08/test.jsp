<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="chap08_Member.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
MemberInfo mi=new MemberInfo();
mi.setId("madvirus");
mi.setName("최범균");
%>


<js:useBean id="mi" Class="chap08_Member.MemberInfo" scope="request"/>
이름 = <%=mi.getName()%> <br> 아이디 = <%=mi.getId() %>
</body>
</html>