package egovframework.sample.service.impl;

import java.util.List;



import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.sample.service.SampleDAO;
import egovframework.sample.service.SampleService;
import egovframework.sample.service.SampleVO;

@Service("sampleService")	//1컨테이너 단계에서 올렸어.
public class SampleServiceImpl implements SampleService {
	//private static final Logger LOGGER=LoggerFactory.getLogger(SampleServiceImpl.class);
	
	
	@Resource(name="daoIBatis")	// 부트에서의 autowired랑 비슷한애, (name="")에 맞는애 주입
	private SampleDAO sampleDAO;	//부모타입으로 하는 이유 - 자식애들 다 쓸 수 있게 하려고
	//private String version;
	
	@Resource(name="egovIdGnrService")		//인젝션이 일어나야하고, 요 이름은 context-idgn,이 설정되어있어야하고, 그 name임
	private EgovIdGnrService egovIdGnrService;
	

	public SampleServiceImpl() {
		System.out.println("===>SampleServiceImpl 1 - 기본 생성자");
		//sampleDAO=new SampleDAOJDBC();
	}


	
	
	public void insertSample(SampleVO vo) throws Exception{
		System.out.println("SampleService---Sample 등록");
		String id=egovIdGnrService.getNextStringId();
		System.out.println("id===>"+id);
		vo.setId(id);
		sampleDAO.insertSample(vo);
		//sampleDAO.insertSample(vo);
	}
	
	public void updateSample(SampleVO vo) throws Exception{
		System.out.println("SampleService---Sample 수정");
		sampleDAO.updateSample(vo);
	}
	
	public void deleteSample(SampleVO vo) throws Exception{
		System.out.println("SampleService---Sample 삭제");
		sampleDAO.deleteSample(vo);
	}
	
	public SampleVO selectSample(SampleVO vo) throws Exception{
		System.out.println("SampleService---Sample 상세 조회");
		return sampleDAO.selectSample(vo);
		
	}
	
	public List<SampleVO> selectSampleList(SampleVO vo) throws Exception{
		System.out.println("SampleService---Sample 목록 검색");
		return sampleDAO.selectSampleList(vo);
	}


	
	/*
	public void initMethod() {
		System.out.println("----> initMethod()호출");
		name="샘플서비스 객체";
	}
	
	public void destroyMethod() {
		System.out.println("----> destroyMethod()호출");
		name=null;		//name값 지우기.
	}
	*/
	
}
