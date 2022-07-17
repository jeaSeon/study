<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>
<%
Connection conn=null;
PreparedStatement pstmt=null;
ResultSet rs=null;
try{
	String url="jdbc:mariadb://localhost:3306/chap14";
	String user="jspur";
	String password="qwe1234";
	String custId=request.getParameter("custId");
	String pw=request.getParameter("pw");
	String query="select * from customer where custId=? and pw=?";
	conn=DriverManager.getConnection(url, user, password);
	
	pstmt=conn.prepareStatement(query);
	pstmt.setString(1, custId);
	pstmt.setString(2, pw);
	rs=pstmt.executeQuery();
	if(rs.next()){
		out.println("로그인 성공했습니다");
		if(custId.equals("master")){
			%><br><hr><input type="button" onclick="location.href='http://localhost:8800/test/exam/insertForm.jsp'" value="상품등록"> 
			<input type="button" onclick="location.href='http://localhost:8800/test/exam/select.jsp'" value="제품조회">
			<input type="button" onclick="location.href='http://localhost:8800/test/exam/updateForm.jsp'" value="제품수정">
			<input type="button" onclick="location.href='http://localhost:8800/test/exam/deleteForm.jsp'" value="제품삭제"><%
		}else{
			%><br><hr><input type="button" onclick="location.href='http://localhost:8800/test/exam/createMem/shopForm.jsp'" value="구매하기"><%
		}
	}else{
		out.println("로그인 실패했습니다.");
		%><hr><%

	}
   }catch (SQLException e) {
      out.println("다시 확인하여 주십쇼.");
      e.printStackTrace();
   }finally{
      if(rs != null) try{rs.close();} catch(SQLException e){}
      if(pstmt != null) try{pstmt.close();} catch(SQLException e){}
      if(conn != null) try{conn.close();} catch(SQLException e){}
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