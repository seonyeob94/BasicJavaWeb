package kr.or.ddit.board.sevice;

import java.util.List;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.vo.BoardVo;

public class BoardServiceImpl implements IBoardService {
	
	private static BoardServiceImpl instance;

	private BoardServiceImpl() {

	}

	public static BoardServiceImpl getInstance() {
		if (instance == null) {
			instance = new BoardServiceImpl();
		}
		return instance;
	}

	IBoardDao boardDao = BoardDaoImpl.getInstance();

	@Override
	public List<BoardVo> list(BoardVo board) {
		
		return boardDao.list(board);
	}

}
