package egovframework.sample.service;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.DefaultTransactionDefinition;

//import egovframework.sample.back.AdvancedSampleServiceImpl;

public class SampleServiceClient {

	public static void main(String[] args) throws Exception {
		//System.out.println("test.......");
	AbstractApplicationContext container=
		new GenericXmlApplicationContext("egovframework/spring/context-*.xml");	//얘 없으면 못돌아가. 이역할을 서블릿이 하는겨.
	SampleService samplerService=(SampleService)container.getBean("sampleService");
	
		SampleVO vo=new SampleVO();

	vo.setId("9");
	vo.setTitle("임시제목10");
	vo.setRegUser("테스트10...");
	vo.setContent("임시내용10...!");
	samplerService.insertSample(vo);
	
	List<SampleVO> sampleList=samplerService.selectSampleList(vo);
	System.out.println("[Sample List]");
	for(SampleVO sample:sampleList) {
		System.out.println("---->"+sample.toString());
	}
	
	//vo.setId(9);
	//samplerService.deleteSample(vo);
	
	container.close();
	
	}
}
