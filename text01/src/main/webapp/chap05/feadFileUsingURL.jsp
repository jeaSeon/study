<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.net.URL" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String resourcePath="/chap05/message/notice";
char[] buff=new char[128];
int len=-1;
URL url=application.getResource(resourcePath);
try(InputStreamReader fr=new InputStreamReader(url.openStream(),"utf-8");)
{
	while((len=fr.read(buff))!=-1){
		out.print(new String(buff,0,len));
	}
	
}catch(IOException ex){
	out.println("익셉션 발생"+ex.getMessage());
}


%>
</body>
</html>