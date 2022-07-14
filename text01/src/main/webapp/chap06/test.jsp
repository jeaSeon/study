<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=request.getParameter("dfd").toUpperCase()%>
<!-- null(없는것)을 대문자로 바꾸라 하니까 말이 안되는것. -> 500에러! -->
</body>


</html>