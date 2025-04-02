package kr.or.ddit.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class T05ErroerHandler extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String message = (String)req.getAttribute("jakarta.servlet.erroer.message");
		String servlet_name = (String)req.getAttribute("jakarta.servlet.erroer.servlet_name");
		int code = (int)req.getAttribute("jakarta.servlet.erroer.status_code");
		String request_uri = (String)req.getAttribute("jakarta.servlet.erroer.request_uri");
		
		System.out.println(message);
		System.out.println(servlet_name);
		System.out.println(code);
		System.out.println(request_uri);
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println(code+ "error page");
		out.println("</body>");
		out.println("</html>");

	}
}
