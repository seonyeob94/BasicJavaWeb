package kr.or.ddit.member;

import java.util.List;

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
	
	MemberDao memberDao = MemberDao.getInstance();
	
	public List<MemberVo> memberList(){
		return memberDao.memberList();
	}

}
