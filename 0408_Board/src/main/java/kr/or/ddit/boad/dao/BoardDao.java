package kr.or.ddit.boad.dao;

import java.util.List;

import kr.or.ddit.util.MybatisDao;
import kr.or.ddit.vo.BoardCodeVo;
import kr.or.ddit.vo.BoardVo;

public class BoardDao extends MybatisDao {
	private static BoardDao insatance;

	private BoardDao() {

	}

	public static BoardDao getInstance() {
		if (insatance == null) {
			insatance = new BoardDao();
		}
		return insatance;
	}

	public List<BoardCodeVo> codeList(){
		return selectList("board.codeList");
	}
	
	public List<BoardVo> boardList(BoardVo board){
		return selectList("board.boardList", board);
	}
	
	public BoardVo boardView(BoardVo board) {
		return selectOne("board.boardView", board);
	}
	
	public void boardDelete(BoardVo board) {
		update("board.boardDelete", board);
	}
	
	public int getBoardNo() {
		return selectOne("board.getBoardNo");
	}
	
	
	public void boardInsert(BoardVo board) {
		update("board.boardInsert", board);
	}
	
	
	
}
