package ph.service.impl;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ph.service.BoardDAO;
import ph.service.BoardVO;

@Repository("boardDAOMybatis")
public class BoardDAOMybatis extends EgovAbstractMapper implements BoardDAO{
	
	//글 삽입
	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		insert("insertBoard",boardVO);
		
	}

}
