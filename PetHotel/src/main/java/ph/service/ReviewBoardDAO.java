package ph.service;

import java.util.List;

public interface ReviewBoardDAO {
	
	void insertBoard(BoardVO boardVo) throws Exception;
	
	List<BoardVO> selectReviewList(BoardVO boardVo) throws Exception;
	
	BoardVO selectReview(BoardVO boardVo) throws Exception;

}
