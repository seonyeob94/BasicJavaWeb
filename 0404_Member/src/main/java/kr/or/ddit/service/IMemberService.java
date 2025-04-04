package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.MemberVo;

public interface IMemberService {
	
	public MemberVo login(MemberVo member);
	
	public List<MemberVo> list();
	
	public MemberVo detail(int memNo);

}

