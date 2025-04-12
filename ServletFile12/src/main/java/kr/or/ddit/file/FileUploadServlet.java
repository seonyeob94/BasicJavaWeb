package kr.or.ddit.file;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.file.vo.FileVo;

@WebServlet("/upload.do")
@MultipartConfig
//@MultipartConfig 업로드 받을 설정이 이거임!
public class FileUploadServlet extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		
		//board.do에서 파일 정보를 가져올때, vo에서 가져오는게 아니라, file group에서 따로, board file Size 그룹에서 따로 각각 정보를 가지고 오는 다대다 방식으로 만드는 것임
		List<FileVo> fileList = FileUploadUtil.uploadUtil(req);
		
		System.out.println("id : "+id);
		System.out.println("pw : "+pw);
		System.out.println("name : "+name);
		
	}
	
}
