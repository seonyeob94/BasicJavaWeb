package kr.or.ddit.boad.service;

import java.util.List;

import kr.or.ddit.boad.dao.BoardDao;
import kr.or.ddit.vo.BoardCodeVo;
import kr.or.ddit.vo.BoardVo;

public class BoardService {
	private static BoardService instance;

	private BoardService() {

	}

	public static BoardService getInstance() {
		if (instance == null) {
			instance = new BoardService();
		}
		return instance;
	}

	BoardDao boardDao = BoardDao.getInstance();
	
//	BoardService boardService = BoardService.getInstance();
	
	public List<BoardCodeVo> codeList(){
		return boardDao.codeList();
//		return boardService.codeList();
	}
	
	public List<BoardVo> boardList(BoardVo board){
		return boardDao.boardList(board);
	}
	
	
}
