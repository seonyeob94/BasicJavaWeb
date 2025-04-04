package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.service.MemberService;
import kr.or.ddit.vo.MemberVo;

@WebServlet("/memberupdate.do")

public class MemberupdateController extends HttpServlet{
	
	MemberService memberService = MemberService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memNoStr = req.getParameter("memNo");
		int memNo = Integer.parseInt(memNoStr);
		
		MemberVo member = memberService.memberDetail(memNo);
		req.setAttribute("member", member);
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/updateForm.jsp").forward(req, resp);

		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		
		MemberVo member = new MemberVo();
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		
		memberService.memberUpdate(member);
		resp.sendRedirect("memberList");
		
	}
}
