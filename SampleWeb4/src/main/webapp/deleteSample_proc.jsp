<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="egovframework.sample.service.impl.SampleDAOJDBC" %>
<%@ page import="egovframework.sample.service.SampleVO"%>
<%
String id=request.getParameter("id");


SampleVO vo=new SampleVO();
vo.setId(id);


SampleDAOJDBC sampleDAO =new SampleDAOJDBC();
sampleDAO.deleteSample(vo);

response.sendRedirect("selectSamplelist.jsp");
%>
