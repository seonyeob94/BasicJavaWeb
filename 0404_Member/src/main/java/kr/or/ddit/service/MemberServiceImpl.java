package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.MemberDaoImpl;
import kr.or.ddit.vo.MemberVo;

public class MemberServiceImpl implements IMemberService{
	
	private static MemberServiceImpl instance;

	private MemberServiceImpl() {

	}

	public static MemberServiceImpl getInstance() {
		if (instance == null) {
			instance = new MemberServiceImpl();
		}
		return instance;
	}

	MemberDaoImpl memberDao = MemberDaoImpl.getInstance();

	@Override
	public MemberVo login(MemberVo member) {
		
		return memberDao.login(member);
	}

	@Override
	public List<MemberVo> list() {
		return memberDao.list();
	}

	@Override
	public MemberVo detail(int memNo) {
		
		return memberDao.detail(memNo);
	}
	
	
	
}

