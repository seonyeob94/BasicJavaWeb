package kr.or.ddit.filter;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import kr.or.ddit.boad.service.BoardService;
import kr.or.ddit.vo.BoardCodeVo;

@WebFilter("/board/*")
public class SideBarFilter implements Filter{

	BoardService boardService = BoardService.getInstance();
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		
		List<BoardCodeVo> codeList = boardService.codeList();
		req.setAttribute("codeList", codeList);
		
		chain.doFilter(req, resp);
	}
	
}
