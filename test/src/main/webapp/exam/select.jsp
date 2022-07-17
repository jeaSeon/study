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
 <h3>등록된 제품</h3>
<table border="2">
<tr>
<th width="100px">이름</th><th width="100px">가격</th><th width="100px">등급</th><th width="100px">수량</th>
</tr>

<%
//Class.forName("org.mariadb.jdbc.Driver");
Connection conn=null;
Statement stmt=null;
ResultSet rs=null;
try{
	String url="jdbc:mariadb://localhost:3306/chap14";
	String user="jspur";
	String password="qwe1234";
	String set1="SET @cnt=0";
	String set2="UPDATE product SET product.num=@cnt:=@cnt+1";
	String query="select * from product order by num";
	conn=DriverManager.getConnection(url, user, password);
	
	stmt=conn.createStatement();
	rs=stmt.executeQuery(set1);
	rs=stmt.executeQuery(set2);
	rs=stmt.executeQuery(query);
	while(rs.next()){
%>
	<tr>
	<td><%=rs.getString("NAME") %></td>
	<td><%=rs.getInt("PRICE") %></td>
	<td><%=rs.getString("GRADE") %></td>
	<td><%=rs.getInt("CNT") %></td>
	
	</tr>

<%
      }
   }catch (SQLException e) {
      out.println("다시 확인하여 주십쇼.");
      e.printStackTrace();
   }finally{
      if(rs != null) try{rs.close();} catch(SQLException e){}
      if(stmt != null) try{stmt.close();} catch(SQLException e){}
      if(conn != null) try{conn.close();} catch(SQLException e){}
   }
%>

</table>

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