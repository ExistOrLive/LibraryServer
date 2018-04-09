package com.library.service;

import java.util.List;

import com.library.view.BookItemView;

public interface BookItemService {

	
	public List<BookItemView> getItemsByBookId(int bookId);
	
	public int getItemsCountByBookId(int bookId);
	
	
	
	
	
	
	
}
