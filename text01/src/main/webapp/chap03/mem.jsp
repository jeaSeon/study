<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/text01/chap03/memMain.jsp" method="post">
	<fieldset style="width:500px">
	<legend>회원</legend>
	<div>
	<table>
	<tr><td>
	<label for="name">이름</label>
	<input id="name" type="text" name="name" size="20"><br>
	</td></tr>
	
	
	<tr><td>
	<label>취미</label>
	<input type="checkbox" name="hobby" value="영화">
	<label>영화</label>
	<input type="checkbox" name="hobby" value="독서">
	<label>독서</label>
	<input type="checkbox" name="hobby" value="음악듣기">
	<label>음악듣기</label>
	<input type="checkbox" name="hobby" value="게임">
	<label>게임</label>
	</td></tr>
	
	
	<tr><td>
	<label>성별</label>
	<input type="radio" name="gender" value="man"> 남자
	<input type="radio" name="gender" value="woman"> 여자
	</td></tr>
	

	<tr><td>
		<label>나이</label>
	<select name="age">
	<option value=0>나이</option>
	
	<%
	for(int i=1;i<100;i++){
	%>
	<option value="<%=i %>"><%=i %></option>
	<%
	}
	%>
	</select>
	
	</td></tr>


	<tr><td>
	<input type="submit" value="전송">
	</td></tr>
	
	
	
	</table>
	
	</div>
	
	
	
	</fieldset>
	



</form>

</body>
</html>