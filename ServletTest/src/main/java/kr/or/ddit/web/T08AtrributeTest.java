package kr.or.ddit.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/T08AtrributeTest")
public class T08AtrributeTest extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//방문시 req, session, context 값을 1씩 증가시키고
		// html로 출력해 보시오
		
		HttpSession session = req.getSession();
		ServletContext ctx = req.getServletContext();
		
		int reqVisit =1;
		int sessionVisit =1;
		int ctxVisit =1;
		
		
		if(req.getAttribute("visit")!=null) {
			
						
			reqVisit = (int) req.getAttribute("visit")+1;
		}
		if(session.getAttribute("visit")!=null) {
			
			
			sessionVisit = (int) session.getAttribute("visit")+1;
		}
		if(ctx.getAttribute("visit")!=null) {
			
			
			ctxVisit = (int) ctx.getAttribute("visit")+1;
		}
		
		req.setAttribute("visit", reqVisit);
		session.setAttribute("visit", sessionVisit);
		ctx.setAttribute("visit", ctxVisit);

		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<boby>");
		out.println("<p> req : "+ reqVisit+"</p></br>");
		out.println("<p> session : "+ sessionVisit+"</p></br>");
		out.println("<p> ctx : "+ ctxVisit+"</p></br>");
		out.println("</boby>");
		out.println("</html>");
		
		// 각각의 브라우저로 요청 테스트 해보기
		
		// req : 1
		// session : 3
		// context : 10
	}
}
