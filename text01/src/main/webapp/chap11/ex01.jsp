<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="chap08_Member.Member" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
Member m=new Member();
m.setName("이름1");
%>
<c:set var="m" value="<%=m %>"/>
<%-- <c:set var="name" value="${m.name}"/>
<% m.setName("이름2");%>
${name} --%>

${m.name}