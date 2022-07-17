<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.SQLException"%>
<%
	request.setCharacterEncoding("utf-8");
	String name=request.getParameter("name");
	String price=request.getParameter("price");
	String grade=request.getParameter("grade");
	String count=request.getParameter("count");
	Connection conn=null;
	PreparedStatement pstmt=null;
	try{
		String url="jdbc:mariadb://localhost:3306/chap14";
		String user="jspur";
		String pass="qwe1234";
		String query="insert into product values(null,?,?,?,?)";
		conn=DriverManager.getConnection(url, user, pass);
		pstmt=conn.prepareStatement(query);
		pstmt.setString(1, name);
		pstmt.setString(2, price);
		pstmt.setString(3, grade);
		pstmt.setString(4, count);
		pstmt.executeUpdate();
		
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
<h2>제품을 추가하였습니다.</h2>
<hr>
<br>
<form>
	<table>
		<tr>
		<td>이름 = </td>
		<td><%=request.getParameter("name") %></td>
		</tr>
		
		<tr>
		<td>가격 = </td>
		<td><%=request.getParameter("price")%></td>
		</tr>
		
		<tr>
		<td>등급 = </td>
		<td><%=request.getParameter("grade") %></td>
		</tr>
		
		<tr>
		<td>수량 = </td>
		<td><%=request.getParameter("count") %></td>
		</tr>
	</table>
</form>
<br>
<hr>
<br>

<tr>
<input type="button" onclick="location.href='http://localhost:8800/test/exam/insertForm.jsp'" value="제품등록">
<input type="button" onclick="location.href='http://localhost:8800/test/exam/select.jsp'" value="제품조회">
<input type="button" onclick="location.href='http://localhost:8800/test/exam/updateForm.jsp'" value="제품수정">
<input type="button" onclick="location.href='http://localhost:8800/test/exam/deleteForm.jsp'" value="제품삭제">
<input type="button" onclick="location.href='http://localhost:8800/test/exam/first.jsp'" value="처음으로">
</tr>
</body>

</html>