<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.SQLException"%>
<%
	request.setCharacterEncoding("utf-8");
	String num=request.getParameter("num");
	String name=request.getParameter("name");
	String price=request.getParameter("price");
	String grade=request.getParameter("grade");
	String count=request.getParameter("count");
	int updateCount=0;
	Connection conn=null;
	PreparedStatement pstmt=null;
	try{
		String url="jdbc:mariadb://localhost:3306/chap14";
		String user="jspur";
		String password="qwe1234";
		String query="update product set name=?, price=?, grade=?, cnt=? where num=?";
		conn=DriverManager.getConnection(url, user, password);
		pstmt=conn.prepareStatement(query);
		pstmt.setString(1, name);
		pstmt.setString(2, price);
		pstmt.setString(3, grade);
		pstmt.setString(4, count);
		pstmt.setString(5, num);
		updateCount=pstmt.executeUpdate();
	}finally{
		if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
		if(conn!=null) try{conn.close();}catch(SQLException ex){}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(updateCount>0){
%>
<h2>수정되었습니다.</h2>
<hr>
<br>
 - 이름 : <%=name %> <br>
 - 가격 : <%=price %> <br>
 - 등급 : <%=grade %> <br>
 - 수량 : <%=count %> <br>
 
 
<%}else{ %>
	번호를 재확인하여 주십시오.
<% 
}
%>

<br>
<hr>
<br>


<input type="button" onclick="location.href='http://localhost:8800/test/exam/insertForm.jsp'" value="제품등록">
<input type="button" onclick="location.href='http://localhost:8800/test/exam/select.jsp'" value="제품조회">
<input type="button" onclick="location.href='http://localhost:8800/test/exam/updateForm.jsp'" value="제품수정">
<input type="button" onclick="location.href='http://localhost:8800/test/exam/deleteForm.jsp'" value="제품삭제">
<input type="button" onclick="location.href='http://localhost:8800/test/exam/first.jsp'" value="처음으로">
<br>
<br>
<hr>

</body>
</html>