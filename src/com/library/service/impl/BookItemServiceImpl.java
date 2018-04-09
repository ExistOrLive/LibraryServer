package com.library.service.impl;

import java.util.List;

import com.library.DAO.IBookItemDAO;
import com.library.entity.BookItem;
import com.library.service.BookItemService;
import com.library.view.BookItemView;

public class BookItemServiceImpl implements BookItemService {

	private IBookItemDAO bookItemDAO;
	
	
	
	public IBookItemDAO getBookItemDAO() {
		return bookItemDAO;
	}

	public void setBookItemDAO(IBookItemDAO bookItemDAO) {
		this.bookItemDAO = bookItemDAO;
	}

	
	@Override
	public List<BookItemView> getItemsByBookId(int bookId) {
		
		    List<BookItem> list=bookItemDAO.getByBookId(bookId);
		    
		    
		    return BookItemView.convertToView(list);
		    
	}

	@Override
	public int getItemsCountByBookId(int bookId) {
       
		return bookItemDAO.getByBookId(bookId).size();
	}

	
	

	
	
	
}
