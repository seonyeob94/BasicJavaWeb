package kr.or.ddit.web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class T03RequestTest extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("--------------request 정보들");
		System.out.println("getCharacterEncoding : "+req.getCharacterEncoding());
		System.out.println("getContentLength : "+req.getContentLength());
		System.out.println("getQueryString : "+req.getQueryString());
		System.out.println("getProtocol : "+req.getProtocol());
		System.out.println("getMethod : "+req.getMethod());
		System.out.println("getRequestURI : "+req.getRequestURI());
		System.out.println("getRequestedSessionId : "+req.getRequestedSessionId());
		System.out.println("getRemoteAddr : "+req.getRemoteAddr());
		System.out.println("getRemotePort : "+req.getRemotePort());
		System.out.println("---------------------------");
	}
}
