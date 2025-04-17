package kr.or.ddit.file.dao;


import kr.or.ddit.util.MybatisDao;
import kr.or.ddit.vo.FileVo;

public class FileDao extends MybatisDao implements IFileDao{
	private static FileDao insatance;
	
	private FileDao() {
		
	}
	
	public static FileDao getInstance() {
		if(insatance == null) {
			insatance = new FileDao();
		}
		return insatance;
		
	}
	
	
	public FileVo download(FileVo File) {
		
		return selectOne("file.download", File);
	}
	
	public void upload(FileVo file) {	
		update("file.upload", file);
	}
	
	public int getFileNo() {
		return selectOne("file.getFileNo");
	}
}
