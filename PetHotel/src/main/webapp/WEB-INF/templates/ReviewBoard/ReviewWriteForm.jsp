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

 <div >
        <div >
            <h1>게시글 등록</h1>
        </div>
        <br/>
        <input id="board_idx" type="hidden" />
        <input id="board_create_date" type="hidden" />
        <table class="table">
            <tr>
                <th style="padding:13px 0 0 15px">게시판 선택</th>
                <td>
                    <div >
                        <select  id="board_type">
                            
                        </select>
                    </div>
                </td>
            </tr>
            <tr>
           		 <!-- ?의 의미는, 있으면 찍고 없으면 안찍고. -->
                <th style="padding:13px 0 0 15px;">생성날짜</th>
                <td><input type="text"readonly="readonly" /></td>
            </tr>
            <tr>
                <th style="padding:13px 0 0 15px;">제목</th>
                <td><input id="board_title" type="text" /></td>
            </tr>
            <tr>
                <th style="padding:13px 0 0 15px;">부제목</th>
                <td><input id="board_sub_title" type="text" /></td>
            </tr>
            <tr>
                <th style="padding:13px 0 0 15px;">내용</th>
                <td><textarea id="board_content" maxlength="140" rows="7" style="height: 200px;"
                ></textarea>
                </td>
            </tr>

        </table>
        <div >
            <a href="/list" >목록으로</a>
        </div>
        <div >
            <button  type="button" id="insertReview.do">저장</button>
            <button  type="button" id="update">수정</button>
            <button  type="button" id="delete">삭제</button>
        </div>
    </div>
</body>
</html>