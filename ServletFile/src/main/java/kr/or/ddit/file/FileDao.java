package kr.or.ddit.file;

import java.io.File;

import kr.or.ddit.file.util.MybatisDao;
import kr.or.ddit.file.vo.FileVo;

public class FileDao extends MybatisDao{
	private static FileDao instance;

	private FileDao() {

	}

	public static FileDao getInstance() {
		if (instance == null) {
			instance = new FileDao();
		}
		return instance;
	}

	public FileVo download(FileVo file) {
		
		return selectOne("file.download",file);
	}

	public void upload(FileVo file) {
		update("file.upload", file);
		
	}
	
	public int getFileNo() {
		return selectOne("file.getFileNo");
	}

}
