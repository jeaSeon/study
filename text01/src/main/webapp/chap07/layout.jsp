<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table width="400" border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="2">
			<jsp:include page="/chap07/module/top.jsp" flush="false"></jsp:include>
		</td>
	</tr>
	
	<tr>
		<td width="100" valign="top">
			<jsp:include page="module/left.jsp" flush="false"></jsp:include>
			<!--상단은 절대경로 : /로 시작해 , 
				좌측메뉴는 상대경로 : layout의 기준에서 경로지정.  -->
		</td>
		
		<td width="300" valign="top">
			내용(레이아웃1)
			<br>
			<br>
			<br>
			
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<jsp:include page="module/bottom.jsp" flush="false"></jsp:include>
		</td>
	</tr>
</table>
</body>
</html>