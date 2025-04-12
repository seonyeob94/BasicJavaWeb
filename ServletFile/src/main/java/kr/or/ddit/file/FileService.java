package kr.or.ddit.file;

import java.io.File;

import kr.or.ddit.file.vo.FileVo;

public class FileService {
	private static FileService instance;

	private FileService() {

	}

	public static FileService getInstance() {
		if (instance == null) {
			instance = new FileService();
		}
		return instance;
	}

	FileDao fileDao = FileDao.getInstance();
	
	public FileVo download(FileVo file) {
		return fileDao.download(file);
	}

	public void upload(FileVo file) {
		fileDao.upload(file);
		
	}

	public int getFileNo() {
		
		return fileDao.getFileNo();
	}

	
}
