package kr.or.ddit.file.dao;

import kr.or.ddit.vo.FileVo;

public interface IFileDao {
	
	public FileVo download(FileVo File);
	
	public void upload(FileVo file);
	
	public int getFileNo();
}
