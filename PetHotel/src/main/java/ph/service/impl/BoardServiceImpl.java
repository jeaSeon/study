package ph.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ph.service.BoardDAO;
import ph.service.BoardService;
import ph.service.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Resource(name="boardDAOMybatis")
	private BoardDAO boardDAO;

	@Override
	public void insertBoard(BoardVO boardVo) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
