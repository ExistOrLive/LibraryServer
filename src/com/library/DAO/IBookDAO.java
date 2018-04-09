package com.library.DAO;

import java.util.List;

import com.library.entity.Book;

public interface IBookDAO extends IDAO<Book>{
	
	public List<Book> getByName(String name,int startPage,int pageSize);
	
	public List<Book> getBySimilarName(String name,int startPage,int pageSize);
	
	public List<Book> getByISBN(String ISBN,int startPage,int pageSize);
	
	public List<Book> getBySimilarISBN(String ISBN,int startPage,int pageSize);
	
   public int getCountByName(String name);
	
	public int getCountBySimilarName(String name);
	
	public int getCountByISBN(String ISBN);
	
	public int getCountBySimilarISBN(String ISBN);
	
	public Book getInfo(int bookId);
	

}
