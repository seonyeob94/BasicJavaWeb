package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.dao.ProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.vo.ProdTypeVo;
import kr.or.ddit.vo.ProdVo;

public class ProdServiceImpl implements ProdService {
	
	private static ProdServiceImpl instance;

	private ProdServiceImpl() {

	}

	public static ProdServiceImpl getInstance() {
		if (instance == null) {
			instance = new ProdServiceImpl();
		}
		return instance;
	}

	ProdDaoImpl prodDao = ProdDaoImpl.getInstance();

	@Override
	public List<ProdTypeVo> typeList() {
		
		return prodDao.typeList();
	}

	@Override
	public List<ProdTypeVo> typeList2(ProdTypeVo type) {
		
		return prodDao.typeList2(type);
	}

	@Override
	public List<ProdVo> prodList(ProdVo prod) {


		return prodDao.prodList(prod);
	}

	@Override
	public ProdVo prodView(ProdVo prod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void prodUpdate(ProdVo prod) {
		// TODO Auto-generated method stub

	}

	@Override
	public void prodDelete(ProdVo prod) {
		// TODO Auto-generated method stub

	}

	@Override
	public void prodInsert(ProdVo prod) {
		// TODO Auto-generated method stub

	}

}
