<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/test/exam/log.jsp" method="get">
<fieldset style="width: 250px">
	<legend>로그인</legend>
	<table  border="1" cellpadding="0" cellspacing="0">
	<tr >
		<td>아이디</td>
		<td><input type="text" name="custId" size="10"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="pw" size="10"></td>
	</tr>

	<tr>
		<td colspan="2">
		<input type="submit" value="로그인" >
		<input type="reset" value="취소">
		<input type="button" value="back" onclick="history.back();">
		</td>
	
	</tr>
	
	</table>
</fieldset>


</form>

</body>
</html>