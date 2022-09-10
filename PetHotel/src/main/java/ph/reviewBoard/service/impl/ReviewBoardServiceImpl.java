package ph.reviewBoard.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ph.reviewBoard.service.BoardVO;
import ph.reviewBoard.service.ReviewBoardDAO;
import ph.reviewBoard.service.ReviewBoardService;

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

	@Override
	public void deleteReview(BoardVO boardVo) throws Exception {
		boardDAO.deleteReview(boardVo);
		
	}

	@Override
	public void updateReview(BoardVO boardVo) throws Exception {
		boardDAO.updateReview(boardVo);
		
	}
	
	

}
