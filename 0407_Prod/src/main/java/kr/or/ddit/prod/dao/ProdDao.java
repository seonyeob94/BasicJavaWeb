package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.vo.ProdTypeVo;
import kr.or.ddit.vo.ProdVo;

public interface ProdDao {
	
	public List<ProdTypeVo> typeList();
	
	public List<ProdTypeVo> typeList2(ProdTypeVo type);
	
	public List<ProdVo> prodList(ProdVo prod);
	
	public ProdVo prodView(ProdVo prod);
	
	public void prodUpdate(ProdVo prod);
	
	public void prodDelete(ProdVo prod);
	
	public void prodInsert(ProdVo prod);

}
