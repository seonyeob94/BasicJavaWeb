package kr.or.ddit.boad.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.boad.service.BoardService;
import kr.or.ddit.vo.BoardVo;

@WebServlet("/board/boardView.do")
public class BoardViewController extends HttpServlet{
	
	BoardService boardService = BoardService.getInstance();
	//jsp 화면 출력하기
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String boardNoStr = req.getParameter("boardNo");
		int boardNo = Integer.parseInt(boardNoStr);
		
		BoardVo board = new BoardVo();
		board.setBoardNo(boardNo);
		
		board = boardService.boardView(board);
		
		req.setAttribute("board", board);
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/board/boardView.jsp").forward(req, resp);

	}
	
	
}
