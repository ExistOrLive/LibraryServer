package com.library.service;

import java.util.List;

import com.library.entity.Book;
import com.library.view.BookView;

public interface BookService {
	
	public int getCountByName(String name,int type);
	
	public int getCountByISBN(String ISBN,int type);
	
	public List<BookView> getByName(String name,int type,int startPage,int pageSize);
	
	public List<BookView> getByISBN(String ISBN,int type,int startPage,int pageSize);
	
	public BookView getInfo(int bookId);
	

}
