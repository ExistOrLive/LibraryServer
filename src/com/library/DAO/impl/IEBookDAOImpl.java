package com.library.DAO.impl;

import java.util.List;

import com.library.DAO.IEBookDAO;
import com.library.entity.EBook;

public class IEBookDAOImpl extends IDAOImpl<EBook> implements IEBookDAO {

	@Override
	public List<EBook> getByName(String name, int startPage, int pageSize) {
		
		String hql="from EBook e where e.name= ?0";
		
		return queryByPage(hql,startPage,pageSize,name);
	}

	@Override
	public List<EBook> getBySimilarName(String name, int startPage, int pageSize) {
		String hql="from EBook e where e.name like ?0";
		
		return queryByPage(hql,startPage,pageSize,name);
	}

	@Override
	public int getCountByName(String name) {
		
		String hql="from EBook e where e.name=?0";
		
		return query(hql,name).size();
	}

	@Override
	public int getCountBySimilarName(String name) {
        
		String hql="from EBook e where e.name like ?0";
		
		return query(hql,name).size();
	}
	
	
	

	
	
	
}
