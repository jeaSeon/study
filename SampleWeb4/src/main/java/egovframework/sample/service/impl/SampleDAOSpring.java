package egovframework.sample.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import egovframework.sample.service.SampleDAO;
import egovframework.sample.service.SampleVO;

@Repository("daoSpring")
public class SampleDAOSpring implements SampleDAO{
	@Resource(name="jdbcTemplate")		//인젝션이 일어나는 곳.
	private JdbcTemplate spring;

	private final String SAMPLE_LIST_TITLE="select id, title, reg_user, content,"
			+ "reg_date from sample where title like '%'||?||'%' order by reg_date desc";
	
	private final String SAMPLE_LIST_CONTENT="select id, title, reg_user, content,"
			+ "reg_date from sample where content like '%'||?||'%' order by reg_date desc";
	
	//private final String SAMPLE_INSERT = "INSERT INTO SAMPLE(ID, TITLE, REG_USER, CONTENT, REG_DATE) VALUES ((SELECT NVL(MAX(ID), 0) + 1 FROM SAMPLE), ?, ?, ?, SYSDATE)";
	private final String SAMPLE_INSERT = "INSERT INTO SAMPLE(ID, TITLE, REG_USER, CONTENT, REG_DATE) VALUES (?, ?, ?, ?, SYSDATE)";
	private final String SAMPLE_UPDATE = "UPDATE SAMPLE SET TITLE=?, REG_USER=?, CONTENT=? WHERE ID=?";
	private final String SAMPLE_DELETE = "DELETE FROM SAMPLE WHERE ID=?";
	private final String SAMPLE_GET    = "SELECT ID, TITLE, REG_USER, CONTENT, REG_DATE FROM SAMPLE WHERE ID=?";
	private final String SAMPLE_LIST = "SELECT ID, TITLE, REG_USER, CONTENT, REG_DATE FROM SAMPLE ORDER BY REG_DATE DESC";
	
	
	public SampleDAOSpring() {
		System.out.println("===>SampleDAOSpring 생성자");
	}
	
	@Override
	public void insertSample(SampleVO vo) throws Exception {
		System.out.println("SampleDAOSpring insert기능");
		System.out.println(vo.toString());
		System.out.println("jdbcTemplate=====>"+spring);
		//spring.update(SAMPLE_INSERT, vo.getTitle(), vo.getRegUser(), vo.getContent());	//초초간단. JDBC는 길었어.
		Object[] args= {vo.getId(), vo.getTitle(), vo.getRegUser(), vo.getContent()};	//배열 안에 넣기.
		spring.update(SAMPLE_INSERT, args);
	}

	@Override
	public void updateSample(SampleVO vo) throws Exception {
		Object[] args= {vo.getTitle(), vo.getRegUser(), vo.getContent(), vo.getId()};	//배열 안에 넣기.
		spring.update(SAMPLE_UPDATE,args);
		
	}

	@Override
	public void deleteSample(SampleVO vo) throws Exception {
		spring.update(SAMPLE_DELETE,vo.getId());
		
	}

	@Override
	public SampleVO selectSample(SampleVO vo) throws Exception {
		Object[] args= {vo.getId()};
		return spring.queryForObject(SAMPLE_GET, args, new SampleRowMapper());
		
		//DB에 등록된 갯수 구하는거.
		//String SAMPLE_TOT_COUNT="select count(*) from sample";
		//int count=spring.queryForObject(SAMPLE_TOT_COUNT, Integer.class);
		//System.out.println("count====>"+count);
		//return null;
	}

	@Override
	public List<SampleVO> selectSampleList(SampleVO vo) throws Exception {
		System.out.println("Spring으로 selectSampleList()기능처리");
		Object[] args= {vo.getSearchKeyword()};
		if(vo.getSearchCondition().equals("TITLE")) {
			return spring.query(SAMPLE_LIST_TITLE,args, new SampleRowMapper());
		}else if(vo.getSearchCondition().equals("CONTENT")) {
			return spring.query(SAMPLE_LIST_CONTENT,args,new SampleRowMapper());
		}
		return null;
	}

}
