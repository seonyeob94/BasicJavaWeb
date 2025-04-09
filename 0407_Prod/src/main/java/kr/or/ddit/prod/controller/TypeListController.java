package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.vo.ProdTypeVo;

@WebServlet("/typeList2")
public class TypeListController extends HttpServlet{
	
	ProdServiceImpl prodService = ProdServiceImpl.getInstance();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String typeNo = req.getParameter("typeNo");
		
		ProdTypeVo typeVo = new ProdTypeVo();
		typeVo.setTypeNo(Integer.parseInt(typeNo));
		
		
		List<ProdTypeVo> typeList2 = prodService.typeList2(typeVo);
		
		resp.setContentType("aplication/json");
		
//		JSONArray jsonArray = new JSONArray();
//		for(ProdTypeVo type : typeList2) {
//			JSONObject obj = new JSONObject();
//			obj.put("typeNo", type.getTypeNo());
//			obj.put("typeName", type.getTypeName());
//			jsonArray.add(obj);
//		}
//		resp.getWriter().write(jsonArray.toJSONString());
		
		ObjectMapper mapper = new ObjectMapper();
		String j = mapper.writeValueAsString(typeList2);
		resp.getWriter().write(j);
		
		
		
		
	}
}
