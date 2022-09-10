<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
보드리스트~

  <div>
        <div >
            <h2>게시글 목록</h2>
        </div>
        <br/>
        <br/>
        <br/>
        <div >
        		<!-- 테이블에 마우스를 올렸을 때 마우스 커서가 있는 행이 다른 색으로 변한다 -->
        		<table border="1" cellpadding="0" cellspacing="0" width="800">
        			<thead>
        				<tr>
        				<!-- scope="col" 해당 th가 열(column)을 위한 헤더 셀이다. -->
        					<th scope="col">글번호</th>
        					<th scope="col">게시글타입</th>
        					<th scope="col">제목</th>
        					<th scope="col">아이디</th>
        					<th scope="col">닉네임</th>
        					<th scope="col">작성일</th>
        				</tr>
        			</thead>
        			<tbody>
        			<!-- http://localhost:9090/board?id=2 -->
        				<c:forEach var="reviewBoard" items="${reviewBoardList}">
        				<tr>
        					<td align="center"><a href="reviewBoard.do?boardNo=${reviewBoard.boardNo}">${reviewBoard.boardNo}</td>
        					<td align="center">${reviewBoard.boardType}</td>
        					<td align="center"><a href="reviewBoard.do?boardNo=${reviewBoard.boardNo}">${reviewBoard.title}</td>
        					<td align="center">${reviewBoard.memberId}</td>
        					<td align="center">${reviewBoard.memberNickname}</td>
        					<td align="center">${reviewBoard.wdate}</td>
        				</tr>
        				</c:forEach>
        			</tbody>
        		</table>
        </div>
         <div align="right"><a href="/logout">LOGOUT</a></div>    
      <nav aria-label="Page navigation" style="text-align: center;">	
			<div class="pagination" style="text-align: center">
				<c:if test="${firstPage > pageList }">
					<a class="changePage" href="list.do?viewPage=${firstPage - pageList}">[이전]</a>
				</c:if>	
				<c:forEach var="i" begin="${firstPage}" end="${lastPage}">																
					<a class="changePage" href="list.do?viewPage=${i}">[ ${i} ]</a>						 						
				</c:forEach>
				<c:if test="${lastPage < totalPage}">
					<a class="changePage" href="list.do?viewPage=${firstPage + pageList}">[다음]</a>
				</c:if>
			</div>
			</nav>	
		</div>
		
		<input type="button" onclick="location.href='/PetHotel/write.do'" value="글쓰기">
</div>
</body>
</html>