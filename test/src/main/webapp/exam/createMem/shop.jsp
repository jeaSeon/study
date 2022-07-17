<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>
<%
	request.setCharacterEncoding("utf-8");
	String custId=request.getParameter("custId");
	String num=request.getParameter("num");
	String orderCnt=request.getParameter("orderCnt");
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{
		String url="jdbc:mariadb://localhost:3306/chap14";
		String user="jspur";
		String pass="qwe1234";
		String query="insert into orders values(null,?,?,?,sysdate())";
		conn=DriverManager.getConnection(url, user, pass);
		pstmt=conn.prepareStatement(query);
		pstmt.setString(1, custId);
		pstmt.setString(2, num);
		pstmt.setString(3, orderCnt);
		pstmt.executeUpdate();%>
		
		<h2><%=custId%>님의 주문이 완료되었습니다.</h2><br><hr>
		
	<% }catch (SQLException e) {
		  out.println("주문을 확인하여 주십시오.");
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
<input type="button" onclick="location.href='http://localhost:8800/test/exam/first.jsp'" value="처음으로">
<input type="button" value="back" onclick="history.back();">


</body>
</html>