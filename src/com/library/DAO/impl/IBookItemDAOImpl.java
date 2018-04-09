package com.library.DAO.impl;

import java.util.List;

import com.library.DAO.IBookItemDAO;
import com.library.entity.BookItem;

public class IBookItemDAOImpl extends IDAOImpl<BookItem> implements IBookItemDAO {

	@Override
	public List<BookItem> getByBookId(int bookId) {
		
		String hql="from BookItem i where i.bookId.id=?0";
		
		return query(hql,bookId);
	}

	
	
}
