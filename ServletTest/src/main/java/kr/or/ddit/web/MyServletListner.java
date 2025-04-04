package kr.or.ddit.web;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.ServletRequestListener;

public class MyServletListner 
	implements ServletRequestListener, ServletRequestAttributeListener {

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("attributeAdded 실행");
		System.out.println(srae.getName()+", " + srae.getValue());
		
	}
	
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("attributeRemoved 실행");
		System.out.println(srae.getName()+", " + srae.getValue());
		
	}
	
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("attributeReplaced 실행");
		System.out.println(srae.getName()+", " + srae.getValue());
		
	}
}
