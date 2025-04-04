package kr.or.ddit.web;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class T10ServletFilter implements Filter{
	
	/*
	 * 서블릿 필터
	 * 1. 사용목적
	 *   - 클라이언트의 요청을 수행하기 전에 가로채 필요한 작업을 일괄적으로 수행할 
	 *     수 있다
	 *   - 클라이언트에 응답을 제공하기 전에 필요한 작업을 수행할 수 있다
	 *   
	 * 2. 사용 예
	 *    - 인증필터
	 *    - 데이터 압축 필터
	 *    - 인코딩 필터
	 *    - 로깅 및 감시 처리 필터
	 *    - 이미 변환 필터 등  
	 * 
	 * 
	 */
	
	String encode;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encode = filterConfig.getInitParameter("encode");

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("필터시작");
		req.setCharacterEncoding(encode);
		
		chain.doFilter(req, resp);
		
		System.out.println("필터 종료");
		resp.setCharacterEncoding(encode);
		
		
	}
	
}
