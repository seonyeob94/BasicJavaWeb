package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.vo.BoardCodeVo;
import kr.or.ddit.vo.BoardVo;

public interface IBoardDao {
	
	public List<BoardVo> list(BoardVo board);
	
	public List<BoardCodeVo> codeList();
}
