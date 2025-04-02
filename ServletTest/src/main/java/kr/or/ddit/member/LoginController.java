package kr.or.ddit.member;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet{
	
	//req 파라미터 값 가져오기
	//디비에 값 있는지 확인 후 
	//로그인 성공, 로그인 실패 출력
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberService memberService = MemberService.getInstance();
		//url login.do
		//요청됨
		System.out.println("요청 됨");
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		String saveId = req.getParameter("saveId");
		
		System.out.println(saveId);
		
		if(saveId ==null) {
			Cookie[] cookies = req.getCookies();
			if(cookies!=null) {
				for(Cookie cookie : cookies) {
					if(!cookie.getName().equals("id")) continue;
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
				}
			}
 		}
		
		
		MemberVo member = new MemberVo();
		member.setId(id);
		member.setPw(pw);
		
		System.out.println(member);
		
		member = memberService.login(member);
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		if(member == null) {
			out.println("<p>로그인 실패</p>");
			out.println("<a href ='/ServletTest/html/login.html'>재 로그인</a>");
		}else {
			out.println("<p>로그인 성공</p>");
			if(saveId != null) {
				Cookie cookie = new Cookie("id", id);
				cookie.setMaxAge(86400*7);
				resp.addCookie(cookie);
			}
		}
		out.println("</body>");
		out.println("</html>");
		
	}
}
