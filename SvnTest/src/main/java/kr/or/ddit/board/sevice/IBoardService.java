package kr.or.ddit.board.sevice;

import java.util.List;

import kr.or.ddit.vo.BoardVo;

public interface IBoardService {
	public List<BoardVo> list(BoardVo board);
}
