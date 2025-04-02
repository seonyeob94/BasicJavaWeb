package kr.or.ddit.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class T04ServeletPrameter extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Map<String, String[]> parameterMap = req.getParameterMap();
		
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String[] hobby = req.getParameterValues("hobby");
		
		System.out.println("이름 : " +name);
		System.out.println("gender : " +gender);
		System.out.println("hobby : " );
		for(String h : hobby) {
			System.out.println(h);
		}
		
		//html 형태로 출력해보기
		
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<boby>");
		out.println("이름 : " + name+"</br>");
		out.println("gender : " +gender+"</br>");
		out.println("hobby : " +"</br>");
		for(String h : hobby) {
			out.println(h+"</br>");
		}
		out.println("</boby>");
		out.println("</html>");
	}
}
