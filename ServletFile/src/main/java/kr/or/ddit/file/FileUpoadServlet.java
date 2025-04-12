package kr.or.ddit.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import kr.or.ddit.file.vo.FileVo;

@WebServlet("/upload.do")
@MultipartConfig
public class FileUpoadServlet extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		
		List<FileVo> fileList = FileUploadUtil.uploadUtil(req);
		
		System.out.println("id : "+ id);
		System.out.println("pw : "+ pw);
		System.out.println("name : "+ name);
			
			
		}
		
		
	}

