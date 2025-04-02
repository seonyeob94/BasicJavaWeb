package kr.or.ddit.member;

import java.util.List;

import kr.or.ddit.util.MybatisDao;

public class MemberDao extends MybatisDao{
	
	private static MemberDao instance;

	private MemberDao() {

	}

	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}

	public List<MemberVo> memberList(){
		
		return selectList("member.memberList");
	
	}
	
	public MemberVo login(MemberVo member) {
		return selectOne("member.login", member);
	}



}
