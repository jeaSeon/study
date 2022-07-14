<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>
	이름 = <%=request.getParameter("name") %><br>
</b>
<p>

<b>
	취미 =
	<%
		String[] values=request.getParameterValues("hobby");
		if(values!=null){
			for(int i=0;i<values.length;i++){
	%>
		<%=values[i] %>
	<%
		}
	}
	%>

</b>
<p>


<b>
<%-- 성별 =
<%
 String[] gender=request.getParameterValues("gender");
 if(values!=null){
	 for(int i=0;i<gender.length;i++){
%>
	<%=gender[i] %>
<%
	 }
 }
%> --%>

	성별 = <%=request.getParameter("gender") %>
<!-- 라디오는 값이 1개라 그냥 파라미터로 받아도 된다?? -->
 
</b>

<p>

<b>
	나이 = <%=request.getParameter("age")%>
</b>

</body>
</html>