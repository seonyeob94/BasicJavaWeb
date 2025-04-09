package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.nio.channels.AcceptPendingException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.vo.ProdVo;

@WebServlet("/prodList")
public class ProdListController extends HttpServlet{
	
	ProdServiceImpl prodService = ProdServiceImpl.getInstance();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String typeNoStr = req.getParameter("typeNo");
		int typeNo = Integer.parseInt(typeNoStr);
		
		
		ProdVo prod = new ProdVo();
		prod.setTypeNo(typeNo);

		List<ProdVo> prodList = prodService.prodList(prod);
		resp.setContentType("application/json");

			
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("요청 typeNo: " + typeNo);
		System.out.println("조회 결과: " + prodList);
		String str = mapper.writeValueAsString(prodList);
		resp.getWriter().write(str);
	}

}
