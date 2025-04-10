package kr.or.ddit.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.or.ddit.vo.MemberVo;

@WebFilter("/board/*")
public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpReq = (HttpServletRequest) req;
		HttpSession session =  httpReq.getSession();
		
		
		if(session.getAttribute("member") == null) {
			MemberVo member = new MemberVo();
			member.setMemNo(1);
			member.setName("개똥이");
			session.setAttribute("member", member);
		}
		
		chain.doFilter(req, resp);
		
		
	}

}
