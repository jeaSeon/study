<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
request.setCharacterEncoding("utf-8");	//포스트방식에서 얘 안하면 한글 깨져.
%>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <b>request.gerParameter()메서드 사용</b><br>
 name 파라미터=<%=request.getParameter("name") %><br>
 address 파라미터 =<%=request.getParameter("address") %><br>
 <p>
 <b>request.getParameters()메서드 사용</b><br>
 <%
 	String[] values=request.getParameterValues("pet");
 	if(values!=null){
 		for(int i=0;i<values.length;i++){ 
 %>
	<%=values[i] %>

<% 			
 		}
 	}
 %>
 
 <p>
 <b>request.getParameterNames()메서드 사용</b><br>
 <%
 Enumeration<String> paramEnum=request.getParameterNames();
 while(paramEnum.hasMoreElements()){
	 String name=paramEnum.nextElement();
	 %>
	 <%=name%>
<% 
 }
 %>
 
 <p>
 <b>request.getParameterMap()매서드 사용</b><br>
 <%
 Map<String, String[]> parameterMap=request.getParameterMap();
 String[] nameParam=parameterMap.get("pet");
 if(nameParam!=null){
%>
	name=<%= nameParam[0] %>	 
<%	 
 }
 %>
 
</body>
</html>