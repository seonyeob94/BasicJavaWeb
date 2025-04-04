package kr.or.ddit.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebFilter(urlPatterns = { "/member/*","/board/*"})
public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest hsReq = (HttpServletRequest) req;
		HttpServletResponse hsResp = (HttpServletResponse) resp;
		
		HttpSession session = hsReq.getSession();
		if(session.getAttribute("member")==null) {
			hsResp.sendRedirect(hsReq.getContextPath()+"/main.do");
		}
		else {
			chain.doFilter(hsReq, hsResp);
		}
				
		
	}
}
