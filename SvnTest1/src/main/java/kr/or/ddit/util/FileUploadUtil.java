package kr.or.ddit.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import kr.or.ddit.file.service.FileService;
import kr.or.ddit.vo.FileVo;


//FileUploadServlet.java 이 내용을 유틸의 형태로 만드는 것임
public class FileUploadUtil {

	private static FileService fileService = FileService.getInstance();
	public static String rootPath = "D:/upload_test/";
	
	//fileVo가 하나가 아닐 수 잇어서 list 처리해줌 -다대다 관계를 위해(추후 crud 처리를 위해 ) 내일은 member 테이블도 + 해서 처리할 것이기 때문에 board 정보를 저장해두는 공간이 필요함
	public static List<FileVo> uploadUtil(HttpServletRequest req) throws ServletException, IOException {

		// 일반적으로 이런 형태의 폴더로 관리함!
		// savefolder 형식으로 아래와 같이 관리하곤함
		// 폴더가 있는지 없는지 체크하는것도 중요함!
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		Date date = new Date();

		String folder = sdf.format(date);

		File f = new File(rootPath + folder);

		List<FileVo> fileList = new ArrayList<FileVo>();
		
		//mkdirs : 없는 폴더는 만들어줘야 하기 때문에 s를 붙임
		if (!f.exists()) f.mkdirs();

		// 멀티 파트를 설정했으니, part가 여러개 있을 것임
		for (Part part : req.getParts()) {
			
			// part 불러올때 다른 값들도 넘어와서 그걸 정리하는 과정이 필요함
			String orgName = part.getSubmittedFileName();
			if (orgName == null || orgName.isEmpty()) {
				continue;
			}

			FileVo file = new FileVo();
			
			//db에서 파일넘버 가지고 올것임
			int fileNo = fileService.getFileNo();
			// \\. 은 정규식 표현이기 때문에!
			String[] temp = orgName.split("\\.");
			// temp :
			String ext = temp[temp.length - 1];
			//랜덤 파일명 처리를 위해 uuid 처리
			UUID uuid = UUID.randomUUID();

			String saveName = folder + "/" + uuid.toString();
			long size = part.getSize();
			
			file.setFileNo(fileNo);
			file.setOrgName(orgName);
			file.setSaveName(saveName);
			file.setExt(ext);
			file.setFileSize(size);
			
			fileList.add(file);
			
			// 여기서 값을 꺼내주겠음
//			String name = part.getName();

//			System.out.println("uploadfile : "+orgName);
//			System.out.println("name : "+name);
//			System.out.println("size : "+size);

			fileService.upload(file);

			System.out.println(file);

			// 내가 원하는 경로에 파일이 만들어짐!
			part.write(rootPath + saveName);

		}
		
		return fileList;
	}

}
