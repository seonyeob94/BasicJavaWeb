package kr.or.ddit.web;

import java.io.IOException;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/T07Session")
public class T07Session extends HttpServlet{
	/*
	 * 세션 특별히 지정하지 않으면 30분
	 * 쿠키 클라이언트
	 * 세션 브라우저
	 *  세션 객체에 대하여
	 *  - 세션을 통해서 사용자(브라우저) 별로 구분하여 정보를 관리할 수 있다.
	 *    (세선 ID 이용)
	 *  - 쿠키를 사용할 때보다 보안이 향상된다(Server에 정보가 저장되기 때문에)
	 *  
	 *  - 세션 객체를 가져오는 법
	 *    HttpSession session = req.getSessioin(boolean 값);
	 *    true  -> 세션객체가 존재하지 않으면 새로 생성함  
	 *    false -> 세션객체가 존재하지 않으면 null을 리턴함
	 *    
	 *  - 세션 객체 삭제 처리방버
	 *   1. invalidate()
	 *   2. 세션 시간 0초로 처리  
	 *      
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		Date createtime = new Date(session.getCreationTime());
		Date acesstime = new Date(session.getLastAccessedTime());
		
		String userId = "abcd1234";
		int visit =1;
		
		String title = "";
		if(session.isNew()) {
			title = "신규방문";
			session.setAttribute("userId", userId);
		}
		else {
			title = "재방문";
			visit = (int) session.getAttribute("visit")+1;
			
		}
		
		session.setAttribute("visit", visit);
		
		System.out.println(title);
		System.out.println(visit);
		System.out.println(session.getId());
		System.out.println(createtime);
		System.out.println(acesstime);
	}
}
