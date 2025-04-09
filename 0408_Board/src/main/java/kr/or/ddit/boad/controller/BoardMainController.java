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

@WebServlet("/board/main.do")
public class BoardMainController extends HttpServlet{

	BoardService bardService = BoardService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//board/main.jsp 만들고 메세지 아무거나
		
		List<BoardCodeVo> codeList = bardService.codeList();
		req.setAttribute("codeList", codeList);
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/board/main.jsp").forward(req, resp);

	}
}
