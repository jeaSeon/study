<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="egovframework.sample.service.impl.SampleDAOJDBC" %>
<%@ page import="egovframework.sample.service.SampleVO"%>
<% 
//사용자 정보 입력 정보 추출
request.setCharacterEncoding("UTF-8");
/*
String title=request.getParameter("title");
String regUser=request.getParameter("regUser");
String content=request.getParameter("content");


SampleVO vo=new SampleVO();
vo.setTitle(title);
vo.setRegUser(regUser);
vo.setContent(content);

SampleDAOJDBC sampleDAO =new SampleDAOJDBC();
sampleDAO.insertSample(vo);
*/

response.sendRedirect("selectSamplelist.jsp");
%>