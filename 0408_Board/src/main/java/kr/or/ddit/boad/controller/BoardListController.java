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
import kr.or.ddit.vo.BoardCodeVo;
import kr.or.ddit.vo.BoardVo;

@WebServlet("/board/boardList.do")
public class BoardListController extends HttpServlet {
	
	BoardService boardService = BoardService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("보드 리스트");
		
		
		
		String codeNoStr = req.getParameter("codeNo");
		int codeNo = Integer.parseInt(codeNoStr);
		
		BoardVo board = new BoardVo();
		board.setCodeNo(codeNo);
		
		List<BoardVo> boardList = boardService.boardList(board);
		System.out.println(boardList);

		req.setAttribute("boardList", boardList);
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/board/boardList.jsp").forward(req, resp);

		
	
	}
	
}
