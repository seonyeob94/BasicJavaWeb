package kr.or.ddit.boad.controller;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.boad.service.BoardService;
import kr.or.ddit.vo.BoardVo;

@WebServlet("/board/boardUpdate.do")
public class BoardUpdateController extends HttpServlet{

	BoardService boardService = BoardService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		
		BoardVo board = new BoardVo();
		board.setBoardNo(boardNo);
		
		board =  boardService.boardView(board);
		
		
		String codeNoStr =  req.getParameter("codeNo");
		int codeNo = Integer.parseInt(codeNoStr);
		req.setAttribute("codeNo", codeNo);
		
		req.setAttribute("board", board);
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/board/boardInsertForm.jsp").forward(req, resp);

		
		
	}
	
}
