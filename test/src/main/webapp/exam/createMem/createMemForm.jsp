<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/test/exam/createMem/createMem.jsp" method="post">
<fieldset style="width: 250px">
	<legend>회원가입</legend>
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
		<td>이름</td>
		<td><input type="text" name="custName" size="10"></td>
	</tr>
	<tr>
		<td>휴대폰번호</td>
		<td><input type="text" name="phone" size="10"></td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="submit" value="등록" >
		<input type="reset" value="취소">
		<input type="button" value="back" onclick="history.back();">
		</td>
	
	</tr>
	
	</table>
</fieldset>


</form>

</body>
</html>