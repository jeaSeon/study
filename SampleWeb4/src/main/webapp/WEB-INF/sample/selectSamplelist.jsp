<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page import="egovframework.sample.service.SampleVO"%>
<%@ page import="java.util.List"%>
<%
	//List<SampleVO> sampleList=(List<SampleVO>)session.getAttribute("sampleList");	//세션에 담은거
	List<SampleVO> sampleList=(List<SampleVO>)request.getAttribute("sampleList");	//모델앤뷰에 담은거
	
	//List<SampleVO> sampleList=sampleDAO.selectSampleList(vo);	//기존
	//out.print("=====>"+sampleList.size()); //연동 되는지 확인하는 작업.
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="list.mainTitle"/></title>
</head>
<body>
<center>
<h1><spring:message code="list.mainTitle"/></h1>
<a href="selectSampleList.do?lang=en">
<spring:message code="list.link.locale.en"/></a>&nbsp;&nbsp;&nbsp;
<a href="selectSampleList.do?lang=ko">
<spring:message code="list.link.locale.ko"/></a>

<!-- 검색 시작 -->
<form action="selectSampleList.do">
<table border="1" cellpadding="0" cellspacing="0" width="800">
<tr>
	<td align="right">
		<select name="searchCondition">
			<c:forEach items="${conditionMap }" var="option">
				<option value="${option.value}">${option.key }
			</c:forEach>
		</select>
		<input name="searchKeyword" type="text"/>
		<input type="submit" value="<spring:message code="list.search.button"/>"/>
	</td>
</tr>
</table>
</form>

<!-- 리스트 -->
<table border="1" cellpadding="0" cellspacing="0" width="800">
<tr>
	<th bgcolor="orange" width="60"><spring:message code="list.list.table.id"/></th>
	<th bgcolor="orange" width="240"><spring:message code="list.list.table.title"/></th>
	<th bgcolor="orange" width="40"><spring:message code="list.list.table.regUser"/></th>
	<th bgcolor="orange" width="60"><spring:message code="list.list.table.regDate"/></th>
</tr>
<!-- el, jstl사용 -->
<c:forEach var="sample" items="${sampleList}">
<tr>
	<td align="center"><a href="selectSample.do?id=${sample.id}">${sample.id}</a></td>
	<td>${sample.title}</td>
	<td align="center">${sample.regUser}</td>
	<td align="center">${sample.regDate}</td>
	</tr>
</c:forEach>


<!-- el,jstl 사용하기 전. 
<% for(SampleVO sample:sampleList){ %>
<tr>
	<td align="center"><a href="selectSample.jsp?id=<%= sample.getId() %>"><%= sample.getId() %></a></td>
	<td><%=sample.getTitle() %></td>
	<td align="center"><%=sample.getRegUser() %></td>
	<td align="center"><%=sample.getRegDate() %></td>
	</tr>
<% }%>
 -->

</table>

<br>
<a href="insertSample.do"><spring:message code="list.link.create"/></a>
</center>
</body>
</html>