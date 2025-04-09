package kr.or.ddit.vo;

import lombok.Data;

@Data
public class BoardVo {
	private int boardNo;
	private String title;
	private String content;
	private String regDate;
	private int memNo;
	private int cnt;
	private int codeNo;
	private String delyn;
	
//	private int memNo;
	
	private MemberVo member;
}
