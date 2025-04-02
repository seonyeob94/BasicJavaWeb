package kr.or.ddit.member;

import lombok.Data;

@Data
public class MemberVo {

	private int memNo;
	private String id;
	private String pw;
	private String name;
	private String regDate;
	private String delyn;
}
