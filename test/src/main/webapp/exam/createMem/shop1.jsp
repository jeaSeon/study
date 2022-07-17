<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String custId=request.getParameter("custId");
	String num=request.getParameter("num");
	String price=request.getParameter("price");
	String orderCnt=request.getParameter("orderCnt");
	Connection conn=null;
	Statement stmt=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	ResultSet rs=null;
	try{
		String url="jdbc:mariadb://localhost:3306/chap14";
		String user="jspur";
		String pass="qwe1234";
		String query="insert into orders values(null,?,?,?,sysdate())";
		String query1="SELECT custid, NAME, odercnt, price*odercnt"+
				"FROM product p, orders o"+
				"WHERE p.num=o.num"+
				"AND custid="+custId;
		conn=DriverManager.getConnection(url, user, pass);
		pstmt=conn.prepareStatement(query);
		stmt=conn.createStatement();
		pstmt.setString(1, custId);
		pstmt.setString(2, num);
		pstmt.setString(3, orderCnt);
		int a=pstmt.executeUpdate();
		
		if(a!=1){
		 out.print("실패");
		}else{
		 rs=stmt.executeQuery(query1);
			while(rs.next()){
				%>
					<tr>
					<td><%=rs.getString("custid") %></td>
					<td><%=rs.getString("NAME") %></td>
					<td><%=rs.getInt("odercnt") %></td>
					</tr>
				<%
				      }
		
		}
	}catch (SQLException e) {
		 
	}finally{
		if(pstmt1!=null)try{pstmt1.close();}catch(SQLException ex){}
		if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
		if(conn!=null)try{conn.close();}catch(SQLException ex){}
	}
%>


</body>
</html>