<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="util.Cookies" %>
<%
	String id=request.getParameter("id");
	String password=request.getParameter("password");
	if(id.equals(password)){
		response.addCookie(Cookies.createCookie("AUTH",id,"/",-1));
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
로그인에 성공하였습니다.
</body>
</html>
<%
}else{
	%>
	<script type="text/javascript">
	alert("로그인에 실패하였습니다.");//")
	history.go(-1);
	</script>
	<%
}

%>