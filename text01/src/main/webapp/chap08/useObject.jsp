<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="chap08_Member.MemberInfo" %>
<%-- <jsp:useBean id="member" scope="request" class="chap08_Member.MemberInfo"/> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
chap08_Member.MemberInfo member=(chap08_Member.MemberInfo)request.getAttribute("member");
%>

<%=member.getName() %>(<%=member.getId() %>) 회원님
안녕하세요.
</body>
</html>