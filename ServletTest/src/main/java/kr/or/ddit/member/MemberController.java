package kr.or.ddit.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberController extends HttpServlet{
	
	MemberService memberService = MemberService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//url member.do
		//요청됨
		System.out.println("요청 됨");
		
		List<MemberVo> memberList = memberService.memberList();
		System.out.println(memberList);

		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out =  resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println(	"<table border='1'>");
		out.println(		"<thead>");
		out.println(			"<tr>");
		out.println(			"<th>NO</th>");
		out.println(			"<th>ID</th>");
		out.println(			"<th>NAME</th>");
		out.println(			"<th>DATE</th>");
		out.println(			"<tr>");
		out.println(		"</thead>");
		out.println(		"<tbody>");
		for(MemberVo member : memberList) {
			out.print("<tr>");
			out.println(	"<td>"+member.getMemNo()+"</td>");
			out.println(	"<td>"+member.getId()+"</td>");
			out.println(	"<td>"+member.getName()+"</td>");
			out.println(	"<td>"+member.getRegDate()+"</td>");
			out.print("</tr>");
		}
		out.println(		"</tbody>");
		out.println(	"</table>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
