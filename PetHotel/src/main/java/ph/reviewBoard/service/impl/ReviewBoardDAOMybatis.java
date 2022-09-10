package ph.reviewBoard.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ph.reviewBoard.service.BoardVO;
import ph.reviewBoard.service.ReviewBoardDAO;

@Repository("reviewBoardDAOMybatis")
public class ReviewBoardDAOMybatis extends EgovAbstractMapper implements ReviewBoardDAO{
	
	//글 삽입
	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		insert("insertReviewBoard",boardVO);
		
	}

	@Override
	public List<BoardVO> selectReviewList(BoardVO boardVo) throws Exception {
		return selectList("selectReviewList", boardVo);
	}

	@Override
	public BoardVO selectReview(BoardVO boardVo) throws Exception {
		return (BoardVO) selectOne("selectReview", boardVo);
	}

	@Override
	public void deleteReview(BoardVO boardVo) throws Exception {
		delete("deleteReview",boardVo);
		
	}
	
	//게시글 수정
	@Override
	public void updateReview(BoardVO boardVo) throws Exception {
		update("updateReview",boardVo);
		
	}

	@Override
	public BoardVO beforeReview(BoardVO boardVo) throws Exception {
		return (BoardVO) selectOne("beforeReview", boardVo);
	}

	@Override
	public BoardVO afterReview(BoardVO boardVo) throws Exception {
		return (BoardVO) selectOne("afterReview", boardVo);
	}

	@Override
	public int maxReview() throws Exception {
		return selectOne("maxReview");
	}

	@Override
	public int minReview() throws Exception {
		return selectOne("minReview");
	}

}
