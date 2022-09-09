package ph.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		//System.out.println("값 넘어왔당");
		String memberId=null;
		String memberNickname=null;
		String data="";
		session= request.getSession();
		//System.out.println(session);
		memberId=(String) session.getAttribute("SessionMemberId");
		memberNickname=(String) session.getAttribute("SessionMemberNickname");
		//System.out.println("닉네임"+memberNickname);
		boardVO.setMemberId(memberId);
		boardVO.setMemberNickname(memberNickname);
		//System.out.println("값 넘어왔당");
		if(memberId!=null) {
			boardService.insertBoard(boardVO);
		}else if(memberId==null)
			data="no";
		return data;	
	}
	
	//조회 
	//모델에 값 담아서 넘겨.? 리스트, 
	@RequestMapping(value="/reviewBoardlist.do")
	public String reviewBoardlist(BoardVO boardVo, Model model) throws Exception {
		System.out.println("목록보기");
		model.addAttribute("reviewBoardList",boardService.selectReviewList(boardVo));
		return "ReviewBoard/reviewBoardlist";
	}
	
	//1개조회
	@RequestMapping(value="/reviewBoard.do")
	public String reviewBoard(BoardVO boardVo, Model model, HttpSession session, HttpServletRequest request) throws Exception {
		System.out.println("리뷰보드 컨트롤러");
		/*id값이 맞는애를 찾아와서 boardVO타입에 넣고, 
		 * 걔를 모델에 넣어서 뿌려줘.
		 */
		System.out.println("보드"+boardVo);
		String memberId=null;
		session= request.getSession();
		memberId=(String) session.getAttribute("SessionMemberId");
		
		BoardVO reviewBoard=boardService.selectReview(boardVo);
		model.addAttribute("reviewBoard",reviewBoard);	
		return "ReviewBoard/reviewBoard";
	}
}
