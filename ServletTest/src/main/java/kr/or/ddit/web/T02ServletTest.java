package kr.or.ddit.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class T02ServletTest extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String age = req.getParameter("age");
		
		System.out.println(name + ", " + age);
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println(	"<table>");
		out.println(		"<tr>");
		out.println(			"<td>naem</td>");
		out.println(			"<td>"+name+"</td>");
		out.println(		"</tr>");
		out.println(		"<tr>");
		out.println(			"<td>age</td>");
		out.println(			"<td>"+age+"</td>"); // 컨텐트 타입을 설정
		out.println(		"</tr>");
		out.println(	"</table>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
