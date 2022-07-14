<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	request.setAttribute("name","최범균");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

요청 URI : ${pageContext.request.requestURI}<br>
request의 name 속성 : ${requestCsope.name}<br>
code 파라미터 : ${param.code}<br>


======>${"101"+111}<br>
======>${null+111}<br>

</body>
</html>