package ph.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ph.service.BoardVO;
import ph.service.MembersVO;
import ph.service.ReviewBoardService;

@Controller
public class ReviewBoardController {
	
	@Resource(name="reviewBoardService")
	private ReviewBoardService boardService;
	
	@RequestMapping(value="/write.do")
	public String write() {
		return "ReviewBoard/ReviewWriteForm";
	}
	
	//글쓰기
	@ResponseBody
	@RequestMapping(value="/insertReviewboard.do", method=RequestMethod.GET)
	public String insertReviewBoard(BoardVO boardVO, MembersVO membersVO, HttpSession session, HttpServletRequest request) throws Exception {
		System.out.println("값 넘어왔당");
		String memberId=null;
		String data="";
		session= request.getSession();
		System.out.println(session);
		memberId=(String) session.getAttribute("SessionMemberId");
		boardVO.setMemberId(memberId);
		System.out.println("값 넘어왔당");
		if(memberId!=null) {
			boardService.insertBoard(boardVO);
		}else if(memberId==null)
			data="no";
		return data;	
	}
	
	
	@RequestMapping(value="/reviewBoardlist.do")
	public String reviewBoardlist() {
		return "ReviewBoard/reviewBoardlist";
	}
}
