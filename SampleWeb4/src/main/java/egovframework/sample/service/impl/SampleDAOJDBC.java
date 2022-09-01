package egovframework.sample.service.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import egovframework.sample.service.SampleDAO;
import egovframework.sample.service.SampleVO;
import egovframework.sample.service.common.JDBCUtil;

@Repository("daoJDBC")
public class SampleDAOJDBC implements SampleDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private final String SAMPLE_LIST_TITLE="select id, title, reg_user, content,"
			+ "reg_date from sample where title like '%'||?||'%' order by reg_date desc";
	
	private final String SAMPLE_LIST_CONTENT="select id, title, reg_user, content,"
			+ "reg_date from sample where content like '%'||?||'%' order by reg_date desc";
	
	//private final String SAMPLE_INSERT = "INSERT INTO SAMPLE(ID, TITLE, REG_USER, CONTENT, REG_DATE) VALUES ((SELECT NVL(MAX(ID), 0) + 1 FROM SAMPLE), ?, ?, ?, SYSDATE)";
	private final String SAMPLE_INSERT = "INSERT INTO SAMPLE(ID, TITLE, REG_USER, CONTENT, REG_DATE) VALUES (?, ?, ?, ?, SYSDATE)";	//테스트
	private final String SAMPLE_UPDATE = "UPDATE SAMPLE SET TITLE=?, REG_USER=?, CONTENT=? WHERE ID=?";
	private final String SAMPLE_DELETE = "DELETE FROM SAMPLE WHERE ID=?";
	private final String SAMPLE_GET    = "SELECT ID, TITLE, REG_USER, CONTENT, REG_DATE FROM SAMPLE WHERE ID=?";
	private final String SAMPLE_LIST = "SELECT ID, TITLE, REG_USER, CONTENT, REG_DATE FROM SAMPLE ORDER BY REG_DATE DESC";
	
	
	
	public SampleDAOJDBC() {
		System.out.println("===> SampleDAOJDBC 생성");	
	}
	
	public void insertSample(SampleVO vo) throws Exception{
		System.out.println("===> JDBC로 insertSample() 기능처리");	
		
		conn=JDBCUtil.getConnection();
		stmt=conn.prepareStatement(SAMPLE_INSERT);
		stmt.setString(1, "SAMPLE-00005");		//임시테스트
		stmt.setString(2, vo.getTitle());
		stmt.setString(3, vo.getRegUser());
		stmt.setString(4, vo.getContent());
		stmt.executeUpdate();
		JDBCUtil.close(stmt, conn);
	}
	
	public void updateSample(SampleVO vo) throws Exception{
		System.out.println("===> JDBC로 updateSample() 기능처리");	
		conn=JDBCUtil.getConnection();
		stmt=conn.prepareStatement(SAMPLE_UPDATE);
		stmt.setString(1, vo.getTitle());
		stmt.setString(2, vo.getRegUser());
		stmt.setString(3, vo.getContent());
		stmt.setString(4, vo.getId());
		stmt.executeUpdate();
		JDBCUtil.close(stmt, conn);
		
	}
	
	
	public void deleteSample(SampleVO vo) throws Exception{
		System.out.println("===> JDBC로 deleteSample() 기능처리");	
		conn=JDBCUtil.getConnection();
		stmt=conn.prepareStatement(SAMPLE_DELETE);
		stmt.setString(1, vo.getId());
		stmt.executeUpdate();
		JDBCUtil.close(stmt, conn);
	}
	
	public SampleVO selectSample(SampleVO vo) throws Exception{
		System.out.println("===> JDBC로 selectSample() 기능처리");
		SampleVO sample=null;
		conn=JDBCUtil.getConnection();
		stmt=conn.prepareStatement(SAMPLE_GET);
		stmt.setString(1,vo.getId());
		rs=stmt.executeQuery();
		if(rs.next()) {
			sample=new SampleVO();
			sample.setId(rs.getString("id"));
			sample.setTitle(rs.getString("title"));
			sample.setRegUser(rs.getString("reg_user"));
			sample.setContent(rs.getString("content"));
			sample.setRegDate(rs.getDate("reg_date"));
		}
		JDBCUtil.close(rs, stmt, conn);
		return sample;
	}
	
	public List<SampleVO> selectSampleList(SampleVO vo) throws Exception{
		System.out.println("===> JDBC로 selectSampleList() 기능처리");	
		List<SampleVO> sampleList=new ArrayList<SampleVO>();
		conn=JDBCUtil.getConnection();
		//stmt=conn.prepareStatement(SAMPLE_LIST);
		if(vo.getSearchCondition().equals("TITLE")) {
			stmt=conn.prepareStatement(SAMPLE_LIST_TITLE);
		}else if(vo.getSearchCondition().equals("CONTENT")) {
			stmt=conn.prepareStatement(SAMPLE_LIST_CONTENT);
		}
		stmt.setString(1, vo.getSearchKeyword());
		rs=stmt.executeQuery();
		while(rs.next()) {
			SampleVO sample=new SampleVO();
			sample.setId(rs.getString("id"));
			sample.setTitle(rs.getString("title"));
			sample.setRegUser(rs.getString("reg_user"));
			sample.setContent(rs.getString("content"));
			sample.setRegDate(rs.getDate("reg_date"));
			sampleList.add(sample);
		}
		JDBCUtil.close(rs, stmt, conn);
		return sampleList;
	}
	

}
