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
import kr.or.ddit.vo.MemberVo;
@WebServlet("/board/boardInsert.do")
public class BoardInsertController extends HttpServlet{
	
	BoardService boardService = BoardService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codeNoStr = req.getParameter("codeNo");
		int codeNo = Integer.parseInt(codeNoStr);
		
		req.setAttribute("codeNo", codeNo);
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/board/boardInsertForm.jsp").forward(req, resp);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codeNoStr = req.getParameter("codeNo");
		int codeNo = Integer.parseInt(codeNoStr);
		
		String memNoStr = req.getParameter("memNo");
		int memNo = Integer.parseInt(memNoStr);
		
		MemberVo member =new MemberVo();
		member.setMemNo(memNo);
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		int boardNo = 0;
		if(req.getParameter("boardNo")!=null) {
			boardNo = Integer.parseInt(req.getParameter("boardNo"));
		}
		else {
			boardNo = boardService.getBoardNo();
		}
		
		
		BoardVo board = new BoardVo();
		
		board.setBoardNo(boardNo);
		board.setCodeNo(codeNo);
		board.setMember(member);
		board.setTitle(title);
		board.setContent(content);
		
		System.out.println(board);
		
		boardService.boardInsert(board);
		
		resp.sendRedirect("/0408_Board/board/boardView.do?boardNo="+boardNo);
		
	}
}
