package com.library.DAO.impl;

import java.util.List;

import com.library.DAO.ICollectionDAO;
import com.library.entity.Collection;

public class ICollectionDAOImpl extends IDAOImpl<Collection> implements ICollectionDAO  {

	@Override
	public List<Collection> getByReaderId(int readerId) {
	     
		String hql="from Collection c where c.readerId.id= ?0";
		
		return query(hql,readerId);
	}

	
	
	
	
}
