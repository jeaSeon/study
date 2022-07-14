<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 int a=3;
%>
<table width="100%" border="1" cellpadding="0" cellspacing="0">
<tr>
	<td>제품번호</td>
	<td>XXXX</td>
</tr>
	
<tr>
	<td>가격</td>
	<td>10,000원</td>
</tr>
</table>

<jsp:include

 page="infoSub.jsp" flush="false">
 <!--  infoSub.jsp로 이동해서 출력해!-->
	<jsp:param name="type" value="B"></jsp:param>
	<!-- 파라미터 이름이 type인 곳에 B를 대입해-->
	</jsp:include>
</body>
</html>