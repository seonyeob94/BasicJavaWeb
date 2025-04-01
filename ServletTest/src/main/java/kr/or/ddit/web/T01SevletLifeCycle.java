package kr.or.ddit.web;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class T01SevletLifeCycle extends HttpServlet{
	/*
	 *  서블릿 동작방식
	 *  1. 사용자가 URL 요청하면 Http Request를 서블릿 컨테이너로 전성함
	 *  2. 컨테이너는 web.xml에 정의된 URL 패턴을 확인하여 어느 서블릿을 통해 요청을 처리할지 검색.
	 *     (서블릿이 로딩이 안되었다면 생성하여 적재됨. 로딩시 init 메소드 호출됨.)
	 *  3. 서블릿 컨테이너는 요청을 처리할 개별 스레드를 생성하여 해당 객체의 service메소드를 
	 *     호출함
	 *  4. service 메소드는 메소드 타입을 체크하여 적절한 메소드를 호출한다
	 *  
	 *  5. 요청처리가 완료되면 HttpServletRequest, HttpServletResponse 객체는 소멸한다.
	 *  6. 컨테이너로부터 서블릿이 제거되는 경우에 destory 메소드가 호출됨 
	 *   
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		String initParam = config.getInitParameter("initParam");
		System.out.println("initParam : "+ initParam);
	}
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("서비스 종료");
		super.service(arg0, arg1);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost 호출됨");
		super.doPost(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 호출됨");
		super.doGet(req, resp);
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy 호출됨");
		super.destroy();
	}
}
