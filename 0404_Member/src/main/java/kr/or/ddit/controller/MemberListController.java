package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVo;

@WebServlet("/member/list.do")
public class MemberListController extends HttpServlet {
	
	MemberServiceImpl memberService = MemberServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("member")==null) {
			resp.sendRedirect("/0404_Member/main.do");
			return;
		}
		
		
		List<MemberVo> list = memberService.list();
		req.setAttribute("list", list);
		
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/member/list.jsp").forward(req, resp);

	}
}
