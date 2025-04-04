package kr.or.ddit.web;

import java.io.IOException;
import java.util.Date;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class T10ServletFilterTest implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		//각 서블릿 동작 시간이 얼나마 걸리는지 체크하는 필터 작성
		
		Date d1 = new Date();
		
		chain.doFilter(req, resp);
		
		Date d2 = new Date();
		HttpServletRequest httpReq = (HttpServletRequest) req;
		
		System.out.println(httpReq.getRequestURI());
		
		System.out.println(d2.getTime()-d1.getTime()+"ms");
		
		
		
	}

}
