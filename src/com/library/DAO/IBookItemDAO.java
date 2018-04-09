package com.library.DAO;

import java.util.List;

import com.library.entity.BookItem;

public interface IBookItemDAO extends IDAO<BookItem> {

	public List<BookItem> getByBookId(int bookId);
	
}
