package ph.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ph.service.ReviewBoardService;

@Controller
public class ReviewBoardController {
	
	@Resource(name="reviewBoardService")
	private ReviewBoardService boardService;
	
	@RequestMapping(value="/write.do")
	public String write() {
		return "ReviewBoard/ReviewWriteForm";
	}

	//test
}
