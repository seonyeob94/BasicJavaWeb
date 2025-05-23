package kr.or.ddit.boad.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.util.MybatisDao;
import kr.or.ddit.vo.BoardCodeVo;
import kr.or.ddit.vo.BoardVo;

public class BoardDao extends MybatisDao{
	private static BoardDao instance;

	private BoardDao() {

	}

	public static BoardDao getInstance() {
		if (instance == null) {
			instance = new BoardDao();
		}
		return instance;
	}

	public List<BoardCodeVo> codeList(){
		return selectList("board.codeList");
	}
	
	public List<BoardVo> boardList(BoardVo baord){
		return selectList("board.boardList", baord);
	}
	
	public BoardVo boardView(BoardVo board) {
		return selectOne("board.boardView", board);
	}
	
	public void boardDelte(BoardVo board) {
		update("board.boardDelete", board);
	}
	
	public int getBoardNo() {
		return selectOne("board.getBoardNo");
	}
	
	public void boardInsert(BoardVo board) {
		update("board.boardInsert", board);
	}
}
