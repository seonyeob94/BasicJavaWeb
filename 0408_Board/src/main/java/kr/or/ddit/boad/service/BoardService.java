package kr.or.ddit.boad.service;

import java.util.List;

import kr.or.ddit.boad.dao.BoardDao;
import kr.or.ddit.vo.BoardCodeVo;
import kr.or.ddit.vo.BoardVo;

public class BoardService {
	private static BoardService insatance;

	private BoardService() {

	}

	public static BoardService getInstance() {
		if (insatance == null) {
			insatance = new BoardService();
		}
		return insatance;
	}
	
	BoardDao boardDao = BoardDao.getInstance();
	
	public List<BoardCodeVo> codeList(){
		return boardDao.codeList();
	}
	
	
	public List<BoardVo> boardList(BoardVo board){
		return boardDao.boardList(board);
	}
	
	public BoardVo boardView(BoardVo board) {
		return boardDao.boardView(board);
	}
	
	public void boardDelete(BoardVo board) {
		boardDao.boardDelete(board);
	}
	
	public int getBoardNo() {
		return boardDao.getBoardNo();
	}
	
	public void boardInsert(BoardVo board) {
		boardDao.boardInsert(board);
	}
	
	
}
