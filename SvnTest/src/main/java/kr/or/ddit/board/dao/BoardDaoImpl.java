package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.util.MybatisDao;
import kr.or.ddit.vo.BoardVo;

public class BoardDaoImpl extends MybatisDao implements IBoardDao {
	
	private static BoardDaoImpl instance;

	private BoardDaoImpl() {

	}

	public static BoardDaoImpl getInstance() {
		if (instance == null) {
			instance = new BoardDaoImpl();
		}
		return instance;
	}

	

	@Override
	public List<BoardVo> list(BoardVo board) {
		
		return selectList("board.boardList", board);
	}

}
