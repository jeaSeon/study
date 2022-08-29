package info.thecodinglive.controller;

import java.security.Principal;
import java.util.List;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.Validate;

import ch.qos.logback.core.encoder.Encoder;
import info.thecodinglive.Service.BoardService;
import info.thecodinglive.model.Board;
import info.thecodinglive.model.Comment;
import info.thecodinglive.model.Users;
import info.thecodinglive.repository.BoardRepository;
import info.thecodinglive.repository.CommentRepository;
import info.thecodinglive.repository.SecurityUsersRepository;

@Controller
public class BasicController {
	//댓글 레파지토리
	@Autowired
	private CommentRepository commentRepository;
	
	
	//회원가입 레파지토리
	@Autowired
	private SecurityUsersRepository securityRepository;
	
	//비밀번호 암호화
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//게시글 서비스. 
	@Autowired
	BoardService  boardService;
	
	
	//시작페이지 (홈)
	@RequestMapping("/first")
	public String first() {
		return "first";
	}
	
	
	
	//게시판 입력 폼
	@RequestMapping("/form")
	public String form() {
		return "form";
	}
	
	//게시글 댓글 보여주기.
	@RequestMapping(value="/sh", method=RequestMethod.POST)
	public String Comment(Model model,
			@RequestParam(value="boardId") long boardId,Principal principal) {
		//System.out.println(boardId);	//글번호
		Comment com=new Comment();
		//System.out.println(securityRepository.findByUsername(principal.getName())); //로그인사람.
		//System.out.println(boardService.findBoardById(boardId));//글번호
		List<Comment> comList=commentRepository.findByBoardId((long)boardId);	//글번호에 맞는 댓글 리스트 생성
		Users users=securityRepository.findByUsername(principal.getName());
		//System.out.println(users.toString());
		model.addAttribute("comList",comList);		//댓글리스트 모델속성에 추가.
		model.addAttribute("users",users);
		return "showComment";
	}
	
	
	
	
	//댓글 삽입.
	@RequestMapping(value="/show", method=RequestMethod.POST)
	public String insertComment(Model model,Principal principal,  @RequestParam(value="comment") String comment, 
			@RequestParam(value="boardId") long boardId ) {
		//System.out.println(comment);	//코멘트
		//System.out.println(boardId);	//글번호
		Comment com=new Comment();
		//System.out.println(securityRepository.findByUsername(principal.getName())); //로그인사람.
		//System.out.println(boardService.findBoardById(boardId));//글번호에 일치하는 게시글
		com.setComment(comment);
		com.setBoard(boardService.findBoardById(boardId));
		com.setUsers(securityRepository.findByUsername(principal.getName()));
		commentRepository.save(com);
		//System.out.println(com.toString());
		List<Comment> comList=commentRepository.findByBoardId((long)boardId);	//글번호에 맞는애들을 리스트 만들어서
		Users users=securityRepository.findByUsername(principal.getName());
		//System.out.println(comList);
		model.addAttribute("comList",comList);		//속성에 넣어서 뿌려줌.
		model.addAttribute("users",users);
		return "showComment";
	}


	//댓글 삭제.
	@RequestMapping(value="/deleteCom", method = RequestMethod.DELETE)
	public String deleteComment(@RequestParam(value="commentId") long commentId, 
			@RequestParam(value="boardIdNo") long boardIdNo,Model model,Principal principal) {
		try{commentRepository.deleteById(commentId);
		
		}catch(Exception e) {
			System.out.println(e);
		}
		List<Comment> comList=commentRepository.findByBoardId((long)boardIdNo);
		Users users=securityRepository.findByUsername(principal.getName());
		model.addAttribute("comList",comList);
		model.addAttribute("users",users);
		//ResponseEntity<?> //return new ResponseEntity<>("{}",HttpStatus.OK);
		return "showComment";
	}
	
	
	//게시글 입력. 보드에 유저넘버 들어가게.
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public ResponseEntity<Board> Insert(@RequestBody Board board, Principal principal) {
		//System.out.println("post 요청");
		//System.out.println(board.toString());
		//System.out.println(principal.getName()); 	// 로그인한사람.
		//System.out.println(securityRepository.findByUsername(principal.getName()));	//로그인한 사람의 정보를 회원등록 테이블에서 갖고와
		board.setUser(securityRepository.findByUsername(principal.getName()));	//board테이블의 user에 넣어
		boardService.save(board);
		return new ResponseEntity<Board>(board,HttpStatus.CREATED);
	}
	
	
	/* 게시글 입력. 유저정보는 X
	//@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
	//게시글 입력.
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public ResponseEntity<Board> Insert(@RequestBody Board board) {
		System.out.println("post 요청");
		System.out.println(board.toString());
		//System.out.println(principal.getName()); 	//Principal principal
		
		boardService.save(board);
		return new ResponseEntity<Board>(board,HttpStatus.CREATED);
	}
	*/
	
	//게시판 목록 조회
	@RequestMapping("/list")
	public String list(Model model, @PageableDefault(
			size=5, sort="id", direction = Sort.Direction.DESC )Pageable pageable) {
		//System.out.println(pageable.getPageSize());
		model.addAttribute("boardList",boardService.findBoardList(pageable));
		return "list";
	}
	
	
	//글 1개 읽기.(해당 글 조회 + 조회 수 증가)
	@RequestMapping("/board")
	public String board(Model model, @RequestParam(value="id", defaultValue = "0") Long id,Principal principal) {
		Board board=boardService.findBoardById(id);
		//Users users=securityRepository.findByUsername(principal.getName());
		if(principal==null) {	//로그인 안했으면 로그인쪽으로.
			return "/loginForm";
		}else {
			Users users=securityRepository.findByUsername(principal.getName());
			//System.out.println((int)board.getPageView()+1);
			board.setPageView((int)board.getPageView()+1);	//조회수 +1
			boardService.save(board);
			model.addAttribute("users",users);
		}
		model.addAttribute("board", board);
		//model.addAttribute("users",users);
		return "onelist";
	}
	
	
	/*
	//글 1개 읽기.(해당 글 조회) - 로그인 안된사람이 들어가면 에러뜸.
	@RequestMapping("/board")
	public String board(Model model, @RequestParam(value="id", defaultValue = "0") Long id,Principal principal) {
		Board board=boardService.findBoardById(id);
		Users users=securityRepository.findByUsername(principal.getName());
		model.addAttribute("board", board);
		model.addAttribute("users",users);
		return "onelist";
	}
	*/
	
	
	/*
	@RequestMapping("/board")
	public String board(Model model, @RequestParam(value="id", defaultValue = "0") Long id) {
		Board board=boardService.findBoardById(id);
		model.addAttribute("board", board);
		return "form";
	}
	*/
	
	
	//1개 게시글 보고, 수정으로 넘어가는 컨트롤러
	@RequestMapping(value="/test/{id}")
	public String uptest(@PathVariable Long id,Model model) {
		Board board=boardService.findBoardById(id);
		board.setContent(board.getContent().replace("<br>", "\r\n"));
		model.addAttribute("board",board);
		return "form";
	}
	
	
	//게시글 수정
	@RequestMapping(value="/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Board> updateBoard(@PathVariable Long id, @RequestBody Board upBoard){
		Board board=boardService.findBoardById(id);
		board.setBoardType(upBoard.getBoardType());
		board.setTitle(upBoard.getTitle());
		board.setSubTitle(upBoard.getSubTitle());
		board.setContent(upBoard.getContent());
		boardService.save(board);
		//System.out.println(board);	//잘 들어갔는지 확인.
		return new ResponseEntity<Board>(board,HttpStatus.OK);
	}
	
	
	//게시글 삭제
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteBoard(@PathVariable Long id) {
		try{boardService.deleteById(id);
		
		
		}catch(Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity<>("{}",HttpStatus.OK);
	}
	
	//기본페이지
	@RequestMapping({"","/"})
	public String home() {
		return "home";
	}
	

	
	
	
	@RequestMapping("/test") 
	public  String test() {
		return "test";
	}
	
	//user계정
	@RequestMapping("/user") 
	public @ResponseBody String user() {
		return "user";
	}
	
	//manager계정
	@RequestMapping("/manager") 
	public @ResponseBody String manager() {
		return "manager";
	}
	
	//admin계정
	@RequestMapping("/admin") 
	public @ResponseBody String admin() {
		return "admin";
	}

	
	//로그인폼
	@RequestMapping("/loginForm") 
	public String log() {
		return "loginForm";
	}
	
	//회원가입 폼
	@RequestMapping("/joinForm") 
	public String joinForm() {
		return "joinForm";
	}
	
	
	//회원가입 시
	@RequestMapping(value="/join", method = RequestMethod.POST) 
	public String join(Users users) {
		System.out.println(users.getUsername());
		//System.out.println(securityRepository.findByUsername(users.getUsername()));
		if(securityRepository.findByUsername(users.getUsername())==null) {
		System.out.println(users.toString());
		users.setRoleType("ROLE_USER");
		String rawPassword=users.getPassword();
		String encPassword=bCryptPasswordEncoder.encode(rawPassword);
		System.out.println(encPassword);
		users.setPassword(encPassword);
		securityRepository.save(users);
		return "redirect:/loginForm";
		}else {
			return "joinForm";
		}
	}
	
	//회원탈퇴 폼.
	@RequestMapping(value="/delUserForm")
	public String delUserForm(Users users) {
		return "delUserForm";
		
	}
	
	
	//회원탈퇴
	@RequestMapping(value="/delUser", method=RequestMethod.POST)
	public String delUser(Users users) {
		//System.out.println(users.getUsername());
		//System.out.println(securityRepository.findByUsername(users.getUsername()));
		Users user=securityRepository.findByUsername(users.getUsername());
		//System.out.println(user.getPassword());
		if(bCryptPasswordEncoder.matches(users.getPassword(), user.getPassword())) {
			commentRepository.deleteByUsersId(user.getId());
			boardService.deleteByUserId(user.getId());
			securityRepository.deleteById(user.getId());
			return "loginForm";
		}else {
			return "delUserForm";
		}
		
		
	}
}
