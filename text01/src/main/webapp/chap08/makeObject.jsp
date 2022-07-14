<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" scope="request" class="chap08_Member.MemberInfo"/>

<jsp:setProperty property="id" name="member" value="mdvirus2"/>
<jsp:setProperty property="name" name="member" value="최범균2"/>



<%
/* member.setId("mdvirus");
member.setName("최범균"); */
%>
<jsp:forward page="/chap08/useObject.jsp"/>