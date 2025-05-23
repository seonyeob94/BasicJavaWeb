package kr.or.ddit.controller;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.service.MemberService;
import kr.or.ddit.vo.MemberVo;
@WebServlet("/memberDetail")
public class MemberDetailController extends HttpServlet {
	
	MemberService memberService = MemberService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memNoStr = req.getParameter("memNo");
		int memNo = Integer.parseInt(memNoStr);
		
		MemberVo member = memberService.memberDetail(memNo);
		
		req.setAttribute("member", member);
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/memberDetail.jsp").forward(req, resp);

		
	}
}
