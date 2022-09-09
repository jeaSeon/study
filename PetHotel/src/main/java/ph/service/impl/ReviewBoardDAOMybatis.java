package ph.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ph.service.ReviewBoardDAO;
import ph.service.BoardVO;

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

}
