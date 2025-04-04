package kr.or.ddit.controller;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVo;

@WebServlet("/main.do")
public class LoginController extends HttpServlet {
	
	MemberServiceImpl memberservice = MemberServiceImpl.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		MemberVo member = new MemberVo();
		member.setId(id);
		member.setPw(pw);
		
		member = memberservice.login(member);
		
		if(member==null) {
			req.setAttribute("state", "fail");
			
			ServletContext ctx = req.getServletContext();
			ctx.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(req, resp);

		}
		else {
			HttpSession session = req.getSession();
			session.setAttribute("member", member);
			
//			resp.sendRedirect("member/list.do");
			resp.sendRedirect(req.getContextPath() + "/member/list.do");
	
		}
		
	}
}
