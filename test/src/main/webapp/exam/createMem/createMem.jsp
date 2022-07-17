<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.SQLException"%>
<%
	request.setCharacterEncoding("utf-8");
	String custId=request.getParameter("custId");
	String pw=request.getParameter("pw");
	String custName=request.getParameter("custName");
	String phone=request.getParameter("phone");
	Connection conn=null;
	PreparedStatement pstmt=null;
	try{
		String url="jdbc:mariadb://localhost:3306/chap14";
		String user="jspur";
		String pass="qwe1234";
		String query="insert into customer values(?,?,?,?)";
		conn=DriverManager.getConnection(url, user, pass);
		pstmt=conn.prepareStatement(query);
		pstmt.setString(1, custId);
		pstmt.setString(2, pw);
		pstmt.setString(3, custName);
		pstmt.setString(4, phone);
		pstmt.executeUpdate();
		%>
		<script>
		alert("회원가입 완료")
		</script>
		로그인 해주십시오.
		<input type="button" onclick="location.href='http://localhost:8800/test/exam/logForm.jsp'" value="로그인"><%
		
	}catch (SQLException e) {
			  out.println("중복된 아이디입니다.");
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
</body>
</html>