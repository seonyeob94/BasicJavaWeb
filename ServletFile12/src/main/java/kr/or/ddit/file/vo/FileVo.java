package kr.or.ddit.file.vo;

import lombok.Data;

@Data
public class FileVo {
	private int fileNo;
	private String orgName;
	private String saveName;
	private String ext;
	private long fileSize;
	private String regDate;
	
	//사용하기 위해 하나 만들어주기
	private String fileSizeStr;
	
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
		
		//fileSizeStr 값 만들어 넣기 - "Byte", "KB", "MB", "GB"
		String[] arr = {"Byte", "KB", "MB", "GB"}; 
		int n = 0;
		
		double temp = fileSize;
		
		// Byte 의 1024 보다 크면 나뉘어야 함
		while(temp>1024) {
			temp/=1024;
			n++;
		}
		
		temp = Math.floor(temp*10)/10;
		
		fileSizeStr = temp+arr[n];
		
	}
	
	
}
