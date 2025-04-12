package kr.or.ddit.file.util;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MybatisDao {
	
	SqlSession session = MybatisUtil.getInstance(true);
	public <T> List<T> selectList(String statement){
		List<T> list = null;
		try {
			list = session.selectList(statement);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public <T> List<T> selectList(String statement, Object param){
		List<T> list = null;
		try {
			list = session.selectList(statement, param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public <T> T selectOne(String statement) {
		T obj = null;
		try {
			obj = session.selectOne(statement);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public <T> T selectOne(String statement, Object param) {
		T obj = null;
		try {
			obj = session.selectOne(statement, param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public int update(String satement) {
		int num =0;
		try {
			 num = session.update(satement);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	
	public int update(String satement, Object param) {
		int num =0;
		try {
			 num = session.update(satement, param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	
	
}
