package kr.or.ddit.board.controller;

import java.io.IOException;

import com.google.gson.Gson;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.vo.BoardVo;

@WebServlet("/boardInsert.do")
public class BoardInsertcontroller extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String codeNoStr = req.getParameter("codeNo");
		
		req.setAttribute("codeNO", Integer.parseInt(codeNoStr));
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/board/insert.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String codeNoStr = req.getParameter("codeNo");
		
		int codeNo = Integer.parseInt(codeNoStr);
		
		BoardVo board = new BoardVo();
		board.setTitle(title);
		board.setContent(content);
		board.setCodeNo(codeNo);
		
		System.out.println(board);
		
		resp.setContentType("application/json");
		
		Gson gson = new Gson();
				
		resp.getWriter().write(gson.toJson(board));
	}
}
