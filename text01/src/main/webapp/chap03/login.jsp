<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%
	String id=request.getParameter("memberid");
	if(id!=null && id.equals("madvirus")){
		response.sendRedirect("/text01/chap03/index.jsp");
	}else{
%> --%>

<%
	String id=request.getParameter("mem");
	if(id!=null && id.equals("mmm")){
		response.sendRedirect("https://www.naver.com/");
	}else{
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 실패</title>
</head>
<body>
잘못된 아이디 입니다.
</body>
</html>
<%
	}
%>
