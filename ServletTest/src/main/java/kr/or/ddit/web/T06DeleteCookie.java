package kr.or.ddit.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class T06DeleteCookie extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie[] cookies = req.getCookies();
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<p>쿠키삭제</p></br>");
		for(Cookie cookie : cookies) {
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
			out.println("<p>쿠키이름 : " + cookie.getName()+"</p>");
			out.println("<p>쿠키값 : " + cookie.getValue()+"</p>");
			
		}
		out.println("</body>");
		out.println("</html>");
	}

}

