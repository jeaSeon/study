package egovframework.sample.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import egovframework.sample.service.SampleService;
import egovframework.sample.service.SampleVO;
import egovframework.sample.service.impl.SampleDAOJDBC;

@Controller
@SessionAttributes("sample")
public class SampleController {

	//통합한거..!!
	@Resource(name="sampleService")	//인터페이스는 자바객체를 바로 생성할 수 없다~!, 이미 1컨테이너 단계에서 담겨져 있음.
	private SampleService sampleService;
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap=new HashMap<String, String>();
		conditionMap.put("제목","TITLE");
		conditionMap.put("내용","CONTENT");
		return conditionMap;
	}
	
	
	//삭제
	@RequestMapping(value="/deleteSample.do")
	public String deleteSample(SampleVO vo, SampleDAOJDBC sampleDAO) throws Exception {
		System.out.println("샘플 삭제 쿼리");
		sampleDAO.deleteSample(vo);
		return "forward:selectSampleList.do";
	}
	
	/*
	//삽입
	@RequestMapping(value="/insertSample.do", method = RequestMethod.GET)
	public String insertSampleView(SampleVO vo) throws Exception {
		System.out.println("샘플등록화면으로 이동 Controller");
		vo.setTitle("Sample 등록입니다.");
		vo.setRegUser("테스터.");
		vo.setContent("Sample 등록 테스트 중입니다.");
		
		return "insertSample";
	}
	*/
	
	
	//삽입
	@RequestMapping(value="/insertSample.do", method = RequestMethod.GET)
	public String insertSampleView() throws Exception {
		System.out.println("샘플등록화면으로 이동 Controller");
		return "insertSample";
	}
	
	
	//삽입
	@RequestMapping(value="/insertSample.do", method = RequestMethod.POST)
	public String insertSample(SampleVO vo) throws Exception {
		System.out.println("샘플등록처리 Controller");
		//강제 예외발생...
		//if(vo.getContent()==null||vo.getContent().length()==0) {
		//	throw new IllegalArgumentException("내용이 입력되지 않았습니다.");
		//}
		sampleService.insertSample(vo);
		return "forward:selectSampleList.do";
	}

	//1개 조회 (모델 앤 뷰 사용)
	@RequestMapping(value="selectSample.do")
	public ModelAndView selectSample(SampleVO vo, ModelAndView mav ) throws Exception {
		//메소드 저 매개변수 객체부터 먼저 생성이되염
		System.out.println("샘플 상세 조회 처리 Controller");
		mav.addObject("sample", sampleService.selectSample(vo));
		mav.setViewName("selectSample");
		return mav;
	}
	
	//리스트 조회	(모델 사용)
	@RequestMapping(value="/selectSampleList.do")
	public String selectSampleList(SampleVO vo,  Model model) throws Exception {
		System.out.println("샘플 목록 검색 처리");
		//검색값에 아무거도 없을때. (기본적인 상태)
		if(vo.getSearchCondition()==null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword()==null) vo.setSearchKeyword("");

		model.addAttribute("sampleList", sampleService.selectSampleList(vo));
		return "selectSamplelist";
	}
	
	//수정
	@RequestMapping(value="/updateSample.do")
	public String updateSample(@ModelAttribute("sample") SampleVO vo) throws Exception {
		System.out.println("샘플 수정 처리 controller");
		System.out.println("제목 : "+vo.getTitle());
		System.out.println("작성자 : "+vo.getRegUser());
		System.out.println("내용 : "+vo.getContent());
		sampleService.updateSample(vo);

		return "forward:selectSampleList.do";
	}

}
