<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="egovframework.sample.service.impl.SampleDAOJDBC" %>
<%@ page import="egovframework.sample.service.SampleVO"%>
<%
request.setCharacterEncoding("UTF-8");
String id=request.getParameter("id");
String title=request.getParameter("title");
String regUser=request.getParameter("regUser");
String content=request.getParameter("content");


SampleVO vo=new SampleVO();
vo.setId(id);
vo.setTitle(title);
vo.setRegUser(regUser);
vo.setContent(content);

SampleDAOJDBC sampleDAO =new SampleDAOJDBC();
sampleDAO.updateSample(vo);

response.sendRedirect("selectSamplelist.jsp");
%>
