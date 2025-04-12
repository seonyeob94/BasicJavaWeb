package kr.or.ddit.file;

import org.apache.ibatis.annotations.Update;

import kr.or.ddit.file.vo.FileVo;

public class FileService {

	private static FileService insatance;
	
	private FileService() {
		
	}
	
	public static FileService getInstance() {
		if(insatance == null) {
			insatance = new FileService();
		}
		return insatance;
		
	}
	
	FileDao fileDao = FileDao.getInstance();
	
	public FileVo download(FileVo file) {
		return fileDao.download(file);
	}
	
	public void upload(FileVo file) {
		fileDao.update("file.upload", file);
	}
	public int getFileNo() {
		return fileDao.getFileNo();
	}
}
