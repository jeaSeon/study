<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.SQLException"%>

<% 
	request.setCharacterEncoding("utf-8");
	String num=request.getParameter("num");
	Connection conn=null;
	PreparedStatement pstmt=null;
	
	try{
		String url="jdbc:mariadb://localhost:3306/chap14";
		String user="jspur";
		String password="qwe1234";
		conn=DriverManager.getConnection(url, user, password);
		String query="delete from product where num=?";
		pstmt=conn.prepareStatement(query);
		pstmt.setString(1, num);
		pstmt.executeUpdate();
		%><h2>삭제 성공하였습니다.</h2><%
	}catch (SQLException e) {
	   out.println("번호를 확인하여 주십시오.");
	   e.printStackTrace();
	}finally{
		if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
		if(conn!=null)try{conn.close();}catch(SQLException ex){}
		
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


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