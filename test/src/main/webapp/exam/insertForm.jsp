<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/test/exam/insert.jsp" method="post">
<fieldset style="width: 250px">
	<legend>구매등록</legend>
	<table  border="1" cellpadding="0" cellspacing="0">
	<tr >
		<td>상품명</td>
		<td><input type="text" name="name" size="10"></td>
	</tr>
	<tr>
		<td>가격</td>
		<td><input type="text" name="price" size="10"></td>
	</tr>
	<tr>
		<td>등급</td>
		<td>
		<input type="radio" name="grade" size="10" value="A">A
		<input type="radio" name="grade" size="10" value="B">B
		<input type="radio" name="grade" size="10" value="C">C
		</td>
	</tr>
	<tr>
		<td>수량</td>
		<td><input type="text" name="count" size="10"></td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="submit" value="등록" >
		<input type="reset" value="취소">
		</td>
	
	</tr>
	
	</table>
</fieldset>


</form>

</body>
</html>