package kr.or.ddit.file.service;

import kr.or.ddit.vo.FileVo;

public interface IFileService {
		
	public FileVo download(FileVo File);
	
	public void upload(FileVo file);
	
	public int getFileNo();

}
