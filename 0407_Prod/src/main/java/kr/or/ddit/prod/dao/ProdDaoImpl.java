package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.util.MybatisDao;
import kr.or.ddit.vo.ProdTypeVo;
import kr.or.ddit.vo.ProdVo;

public class ProdDaoImpl extends MybatisDao implements ProdDao {
	
	private static ProdDaoImpl instance;

	private ProdDaoImpl() {

	}

	public static ProdDaoImpl getInstance() {
		if (instance == null) {
			instance = new ProdDaoImpl();
		}
		return instance;
	}

	
	
	@Override
	public List<ProdTypeVo> typeList() {
		return selectList("prod.typeList");
	}

	@Override
	public List<ProdTypeVo> typeList2(ProdTypeVo type) {
		
		return selectList("prod.typeList2", type);
	}

	@Override
	public List<ProdVo> prodList(ProdVo prod) {
		
		return selectList("prod.prodList", prod);
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
