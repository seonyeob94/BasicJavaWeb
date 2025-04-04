package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.MemberDao;
import kr.or.ddit.vo.MemberVo;

public class MemberService {
	
	private static MemberService instance;

	private MemberService() {

	}

	public static MemberService getInstance() {
		if (instance == null) {
			instance = new MemberService();
		}
		return instance;
	}

	private MemberDao memberDao = MemberDao.getInstance();
	
	public List<MemberVo> memberList(){
		
		
		return memberDao.memberList();
	}

	public MemberVo memberDetail(int memNo) {
		return memberDao.memberDetail(memNo);
	}
	
	public void memberInsert(MemberVo member) {
		memberDao.memberInsert(member);
	}
	
	public MemberVo memberUpdate(MemberVo member){
	
		return memberDao.memberUpdate(member);
	}

}
