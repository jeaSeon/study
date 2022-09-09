<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String userId = (String) session.getAttribute("SessionMemberId");
	String userRole = (String) session.getAttribute("SessionRole");
	String memberNickname = (String) session.getAttribute("SessionMemberNickname");
	if(userRole == null) {
		userRole = "Visitor";
	}
	System.out.println(userRole);
%>

 ${SessionMemberId}
 
            <h2>후기게시판</h2>
        </div>
        <br/>
        <input id="boardNo" name="boardNo" type="hidden" />
        <input id="wdate" name="wdate" type="hidden" />
        <table border="1" cellpadding="0" cellspacing="0" width="800">
            <tr>
                <th style="width: 300px">게시글 타입</th>
                 <td style="padding:13px 0 0 15px;"> ${reviewBoard.boardType}</td>
            </tr>
            <tr>
                <th style="width: 300px">작성날짜</th>
                <td style="padding:13px 0 0 15px;"> ${reviewBoard.wdate}</td>
            </tr>
            <tr>
                <th style="width: 300px">아이디</th>
                <td style="padding:13px 0 0 15px;"> ${reviewBoard.memberId}<br/></td>
            </tr>
            <tr>
                <th style="width: 300px">닉네임</th>
                <td style="padding:13px 0 0 15px;">${reviewBoard.memberNickname}<br/></td>
            </tr>
            <tr>
                <th style="width: 300px">제목</th>
                <td style="padding:13px 0 0 15px;">${reviewBoard.title}<br/></td>
            </tr>
            <tr>
                <th style="width: 300px">내용</th>
                <td style="padding:13px 0 0 15px;">${reviewBoard.content}</td>

            </tr>
        </table>
        
        <div><a href="reviewBoardlist.do" >목록으로</a></div>
</body>
</html>