package kr.or.ddit.file.service;

import org.apache.ibatis.annotations.Update;

import kr.or.ddit.file.dao.FileDao;
import kr.or.ddit.vo.FileVo;



public class FileService implements IFileService{

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
