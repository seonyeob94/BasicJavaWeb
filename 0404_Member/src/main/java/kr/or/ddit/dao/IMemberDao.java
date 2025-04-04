package kr.or.ddit.dao;

import java.util.List;

import kr.or.ddit.vo.MemberVo;

public interface IMemberDao {
	
	public MemberVo login(MemberVo member);
	
	public List<MemberVo> list();
	
	public MemberVo detail(int memNo);

}
