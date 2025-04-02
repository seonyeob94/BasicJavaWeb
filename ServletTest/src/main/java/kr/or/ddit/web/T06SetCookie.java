package kr.or.ddit.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/setCookie")
public class T06SetCookie extends HttpServlet {
	/*
	 *  쿠키란?
	 *  -> 웹서버와 브라우저는 애플리케이션을 사용하는 동한 필요한 값을 쿠키를 통해 공유함.
	 *  
	 *  1. 구성요소
	 *   - 이름
	 *   - 값
	 *   - 유효시간
	 *   - 도메인
	 *     -> 쿠키의 도메인이 쿠키를 생성한 서버의 도메인을 벗어나면 쿠키를 저장하지 않는다
	 *   - 경로 : 쿠키를 공유할 기준 경로를 지정한다
	 *   
	 *  2. 동작방식
	 *   - 쿠키 생성단계 : 생성한 쿠키를 응답데이터의 헤더에 저장하여 브라우저에 전송한다
	 *   - 쿠키 저장단계 : 브라우저는 응답데이터에 포함된 쿠키를 쿠키 저장소에 저장한다
	 *   - 쿠키 전송단계 : 브라우저는 저장한 쿠키를 유쳥이 있을때마다 웹서버에 전송한다
	 *                 웹서버는 쿠키를 사용하여 필요한 작업을 수행함
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie userId = new Cookie("userId", req.getParameter("userId"));
		
		//쿠키 소멸 단위(초) -> 지정하지 않으면 브라우저 종료시 쿠키를 삭제한다
		userId.setMaxAge(60*10);
		
		resp.addCookie(userId);
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<p>"+req.getParameter("userId")+"</p>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
