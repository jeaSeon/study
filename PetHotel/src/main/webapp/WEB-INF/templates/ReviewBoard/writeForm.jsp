<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
function insert() {
	var boardTypeB = $('#boardType').val()
	var titleB = $('#title').val();
	var subTitleB = $('#subTitle').val();
	var contentB = $('#content').val();	
	$.ajax({
		url: 'insertboard.do',
		type: 'GET',
		data: {
			boardType:boardTypeB,
			title:titleB,
			subTitle:subTitleB,
			content:contentB
			},
		datatype: 'JSON',
		success: function (data) {
			if(data == "no") {
				alert("로그인이 필요합니다.")
				location.href='login.do'
			} else {
				alert("게시글 등록 성공")
				location.href='list.do'
			}
		}
	})			
}

</script>
<title>Insert title here</title>
</head>
<body>
<%
	String userId = (String) session.getAttribute("SessionUserId");
	String userRole = (String) session.getAttribute("SessionRole");
	if(userRole == null) {
		userRole = "Visitor";
	}
	System.out.println(userRole);
%>
<div>

</div><br><br><br><br><br>
<div class="container">  
<div class="page-header">
	<h1>게시글 등록</h1>
</div>
<input id="boardNo" name="boardNo" type="hidden"/>
<input id="wdate" name="wdate" type="hidden"/>
<table class="table">		
		<tr>  
			<th style="padding:13px 0 0 15px" width="100">게시판 선택</th>
			<td>
			<div class="pull-left">
				<select id="boardType" id="boardType" class="form-control input-sm">
					<% if(userRole.equals("User") || userRole.equals("Visitor")) { %>					
					<option value="자유게시판" selected="${board.boardType=='자유게시판'}">자유게시판</option>
					<% } else if(userRole.equals("Admin")) {%>
					<option value="공지사항" selected="${board.boardType=='공지사항'}">공지사항</option>
					<option value="자유게시판" selected="${board.boardType=='자유게시판'}">자유게시판</option>
					<% } %>
				</select>
			</div>
			</td>
		</tr>
		<tr>
			<th style="padding:13px 0 0 15px" width="100">생성날짜</th>
			<td align="left"><input name="wdate" class="col-md-1 form-control input-sm" readonly="readonly" type="text" size="52"/></td>
		</tr>
		<tr>
			<th style="padding:13px 0 0 15px" width="100">제목</th>
			<td align="left"><input id="title" class="col-md-1 form-control input-sm" type="text" size="52"/></td>
		</tr>
		<tr>
			<th style="padding:13px 0 0 15px" width="100">부제목</th>
			<td align="left"><input id="subTitle" class="col-md-1 form-control input-sm" type="text" size="52"/></td>
		</tr>		
		<tr>
			<th style="padding:13px 0 0 15px">내용</th>
			<td align="left"><textarea id="content" class="col-md-1 form-control input-sm" cols="40" rows="5"></textarea></td>
		</tr>	
		</table>
				<br>
		<div class="pull-left">
			<a href="list.do" class="btn btn-default">목록으로</a>  
    	</div>  
    	<div class="pull-right">
    		<input type="button" onclick="insert()" class="btn btn-primary" value="저장"/>
    	</div>
</body>
</html>