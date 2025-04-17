package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.board.sevice.BoardServiceImpl;
import kr.or.ddit.board.sevice.IBoardService;
import kr.or.ddit.vo.BoardVo;

@WebServlet("/boardList.do")
public class BoardListController extends HttpServlet {
	
	IBoardService boardService = BoardServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		BoardVo board = new BoardVo();
		String search = req.getParameter("search");
		if(search != null) {
			System.out.println(search);
			board.setSearch(search);
		}
		
		List<BoardVo> boardList = boardService.list(board);
		req.setAttribute("boardList", boardList);
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/board/list.jsp").forward(req, resp);

	}
}
