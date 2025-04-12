package kr.or.ddit.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.file.vo.FileVo;

@WebServlet("/download.do")
public class FileDownloadServlet extends HttpServlet {
	
	FileService fileService = FileService.getInstance();
	
	String rootPath = "D:/upload_test/";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String fileNoStr = req.getParameter("fileNo");
		
		int fileNo = Integer.parseInt(fileNoStr);
		
		FileVo fileVo = new FileVo();
		fileVo.setFileNo(fileNo);
		
		fileVo = fileService.download(fileVo);
		
		
		
		//jsp파일 다운로드 받아보기
//		String fileName = "dong.png";
		
		String fileName = fileVo.getSaveName();

		File file = new File(rootPath + fileName);

		FileInputStream fis = new FileInputStream(rootPath + fileName);

		String str = "test";
		
		// 파일 읽어올때 이런 방법을 사용함! resp.setContentType("application/octet-stream")
//		resp.setContentType("application/octet-stream");
		resp.setContentLength(str.getBytes().length);
		resp.setHeader("Content-Disposition", "attachment; filename=\"test.txt\"");

		resp.setContentType("application/octet-stream");
		resp.setContentLength((int)fileVo.getFileSize());
		resp.setHeader("Content-Disposition", "attachment; filename=\"" + fileVo.getOrgName() + "\"");
		//getOrgName 으로 넣어줘야 파일이 읽힘!
		
		//나중에 outputStream은 버퍼 씌워서 하셈 - 많이 느림
		OutputStream out = resp.getOutputStream();
		// input으로 파일 받고 output으로 파일 보내면 됨! OutputStream out = resp.getOutputStream();
//		 out.write(str.getBytes());

		int data = 0;

		while ((data = fis.read()) != -1) {
			out.write(data);
		}
		
		
		
	}

}
