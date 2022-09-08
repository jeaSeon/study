<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>개인 정보 수정</h1>
아이디 : ${memberSelect.memberId}<br>
현재 비밀번호 : ${memberSelect.memberPassword}<br>
변경할 비밀번호 : <input id="memberPassword" name="memberPassword" value="${memberSelect.memberPassword}" type="text"/><br>

이름 : ${memberSelect.memberName}<br>

현재 닉네임 : ${memberSelect.memberNickname}<br>
변경할 닉네임 : <input id="memberNickname" name="memberNickname" value="${memberSelect.memberNickname}" type="text"/><br>

생년월일 : ${memberSelect.memberResident}<br>

변경할 주소 : <input id="memberAddress" name="memberAddress" value="${memberSelect.memberAddress}" type="text"/><br>

현재 전화번호 : ${memberSelect.memberTelNumber}<br>
변경할 전화번호 : <input id="memberTelNumber" name="memberTelNumber" value="${memberSelect.memberTelNumber}" type="text"/><br>

</body>
</html>