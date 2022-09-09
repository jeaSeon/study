package ph.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ph.service.ReviewBoardDAO;
import ph.service.ReviewBoardService;
import ph.service.BoardVO;

@Service("reviewBoardService")
public class ReviewBoardServiceImpl implements ReviewBoardService{
	
	@Resource(name="reviewBoardDAOMybatis")
	private ReviewBoardDAO boardDAO;

	@Override
	public void insertBoard(BoardVO boardVo) throws Exception {
		boardDAO.insertBoard(boardVo);
		
	}

	@Override
	public List<BoardVO> selectReviewList(BoardVO boardVo) throws Exception {
		return boardDAO.selectReviewList(boardVo);
	}

	@Override
	public BoardVO selectReview(BoardVO boardVo) throws Exception {
		return boardDAO.selectReview(boardVo);
	}

}
