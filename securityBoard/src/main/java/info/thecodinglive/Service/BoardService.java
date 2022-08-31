package info.thecodinglive.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import info.thecodinglive.model.Board;
import info.thecodinglive.model.Users;
import info.thecodinglive.repository.BoardRepository;
import info.thecodinglive.repository.SecurityUsersRepository;

//게시글 서비스이다.
@Service
public class BoardService {

	private final BoardRepository boardRepository;
	
	/*
	//추가
	@Autowired
	private SecurityUsersRepository securityUsersRepository;
	*/
	
	public BoardService(BoardRepository boardRepository) {
		this.boardRepository=boardRepository;
	}
	
	/*
	public Board Save(String username, Board board) {
		Users user=securityUsersRepository.findByUsername(username);
		board.setUser(user);
		return boardRepository.save(board);
	}
	*/
	
	//게시글 저장.
	
	public void save(Board board) {
		boardRepository.save(board);
	}
	
	//게시글 리스트
	public Page<Board> findBoardList(Pageable pageable) {
		pageable=PageRequest.of(pageable.getPageNumber()<=0?0:pageable.getPageNumber()-1,
				pageable.getPageSize(), pageable.getSort());
		return boardRepository.findAll(pageable);
		
	}
	
	//게시글 1개 조회
	public Board findBoardById(Long id) {
		return boardRepository.findById((long)id).orElse(new Board());
	}
	
	//게시글 삭제
	public void deleteById(Long id) {
		boardRepository.deleteById(id);
	}
	
	
	//UserId로 게시글 삭제.
	public void deleteByUserId(int id) {
		boardRepository.deleteByUserId(id);
	}
	
}
