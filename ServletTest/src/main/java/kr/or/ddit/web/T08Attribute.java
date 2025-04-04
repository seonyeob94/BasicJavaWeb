package kr.or.ddit.web;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet
public class T08Attribute extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Attribute
		
		HttpSession session = req.getSession();
		ServletContext ctx = req.getServletContext();
		
		
		req.setAttribute("req", 200);

		session.setAttribute("session", "세션");
		
		ctx.setAttribute("ctx", "UTF-8");
		//모든사용자 사용하는 정보
		
		
		int no = (int)req.getAttribute("req");
		
		String str = (String)session.getAttribute("session");
		
		String encode = (String) ctx.getAttribute("ctx");
		
	}
}
