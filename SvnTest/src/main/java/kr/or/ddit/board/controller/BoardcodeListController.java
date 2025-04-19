package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.board.sevice.BoardServiceImpl;
import kr.or.ddit.board.sevice.IBoardService;
import kr.or.ddit.vo.BoardCodeVo;

@WebServlet("/boardCodeList.do")
public class BoardcodeListController extends HttpServlet {
	
	IBoardService service = BoardServiceImpl.getInstance();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<BoardCodeVo> codeList = service.codeList();
		
		Gson gson = new Gson();
		
		String jsonStr = gson.toJson(codeList);
		
		resp.setContentType("application/json");
		resp.getWriter().write(jsonStr);
	}
}
