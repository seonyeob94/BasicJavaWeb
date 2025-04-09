package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.vo.ProdTypeVo;

@WebServlet("/main.do")
public class MianController extends HttpServlet {
	
	ProdServiceImpl prodService = ProdServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<ProdTypeVo> typeList = prodService.typeList();
		req.setAttribute("typeList", typeList);
		
		String typeNo = req.getParameter("typeNo");
		if(typeNo!=null) {
			
			ProdTypeVo typeVo = new ProdTypeVo();
			typeVo.setTypeNo(Integer.parseInt(typeNo));
			
			List<ProdTypeVo> typeList2 =prodService.typeList2(typeVo);
			
			req.setAttribute("typeList2", typeList2);
			req.setAttribute("typeNo", Integer.parseInt(typeNo));
			
		}
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(req, resp);

	}
}
