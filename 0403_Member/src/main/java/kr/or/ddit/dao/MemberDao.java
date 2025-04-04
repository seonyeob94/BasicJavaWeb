package kr.or.ddit.dao;

import java.util.List;

import kr.or.ddit.util.MybatisDao;
import kr.or.ddit.vo.MemberVo;

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

	public MemberVo memberDetail(int memNo) {
		
		return selectOne("member.memberDetail", memNo);
	}
	
	public void memberInsert(MemberVo member) {
		update("member.memberInsert", member);
	}
	
	public MemberVo memberUpdate(MemberVo member){
		
		return selectOne("member.memberUpdate", member);
	}
	
}
