package kr.or.ddit.dao;

import java.util.List;

import kr.or.ddit.util.MybatisDao;
import kr.or.ddit.vo.MemberVo;

public class MemberDaoImpl extends MybatisDao implements IMemberDao{
	private static MemberDaoImpl instance;

	private MemberDaoImpl() {

	}

	public static MemberDaoImpl getInstance() {
		if (instance == null) {
			instance = new MemberDaoImpl();
		}
		return instance;
	}

	

	@Override
	public MemberVo login(MemberVo member) {
		return selectOne("member.login", member);
	}

	
	@Override
	public List<MemberVo> list() {
		
		return selectList("member.list");
	}

	@Override
	public MemberVo detail(int memNo) {
		
		return selectOne("member.detail",memNo);
	}

	
}
