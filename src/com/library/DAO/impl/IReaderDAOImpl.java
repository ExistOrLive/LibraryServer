package com.library.DAO.impl;

import java.util.List;

import com.library.DAO.IReaderDAO;
import com.library.entity.Reader;

public class IReaderDAOImpl extends IDAOImpl<Reader> implements IReaderDAO  {

	
	@Override
	public Reader getByName(String name) {
		
		String hql="from Reader r where r.name= ?0";
		List<Reader> list=query(hql,name);
		if(list.size()==0)
			return null;
		else
			return list.get(0);
		
	}

	@Override
	public Reader getByTelNum(String telNum) {
		
		String hql="from Reader r where r.telNum= ?0";
		List<Reader> list=query(hql,telNum);
		if(list.size()==0)
			return null;
		else
			return list.get(0);
	}
   
	
	
	
}
