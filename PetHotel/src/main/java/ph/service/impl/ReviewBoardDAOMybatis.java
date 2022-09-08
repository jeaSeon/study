package ph.service.impl;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ph.service.ReviewBoardDAO;
import ph.service.BoardVO;

@Repository("reviewBoardDAOMybatis")
public class ReviewBoardDAOMybatis extends EgovAbstractMapper implements ReviewBoardDAO{
	
	//글 삽입
	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		insert("insertBoard",boardVO);
		
	}

}
