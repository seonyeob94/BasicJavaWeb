package kr.or.ddit.boad.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.boad.service.BoardService;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.BoardVo;

@WebServlet("/board/boardDelte.do")
public class BoardDeleteController extends HttpServlet {
	
	BoardService boardService = BoardService.getInstance();
	
	// 삭제 
	// 목록으로 이동.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String boardNoStr =  req.getParameter("boardNo");
		int boardNo = Integer.parseInt(boardNoStr);
		
		String codeNoStr =  req.getParameter("codeNo");
		int codeNo = Integer.parseInt(codeNoStr);
		
		BoardVo board = new BoardVo();
		board.setBoardNo(boardNo);
		
//		BoardVo board = RequestToVoMapper.mapRequestToVo(req, BoardVo.class);
		
		boardService.boardDelete(board);
		
		resp.sendRedirect("/0408_Board/board/boardList.do?codeNo="+codeNo);
	
	}
}
