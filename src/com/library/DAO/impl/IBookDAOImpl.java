package com.library.DAO.impl;

import java.io.Serializable;
import java.util.List;
import com.library.DAO.IBookDAO;
import com.library.entity.Book;

public class IBookDAOImpl extends IDAOImpl<Book> implements IBookDAO {


	@Override
	public List<Book> getByName(String name,int startPage,int pageSize) {
		
		String hql="from Book  b where b.name=?0";
		
		List<Book> list=queryByPage(hql, startPage,pageSize,name);
		
		return list;
	}

	@Override
	public List<Book> getBySimilarName(String name,int startPage,int pageSize) {
		
		String hql="from Book  b where b.name like ?0";
		
		List<Book> list=queryByPage(hql,startPage,pageSize,name);
		
		return list;
		
	}

	@Override
	public List<Book> getByISBN(String ISBN,int startPage,int pageSize) {
	
        String hql="from Book b where b.ISBN=?0";
		
		List<Book> list=queryByPage(hql,startPage,pageSize,ISBN);
		
		return list;
	}

	@Override
	public List<Book> getBySimilarISBN(String ISBN,int startPage,int pageSize) {
		 
		    String hql="from Book  b where b.ISBN like ?0";
			
			List<Book> list=queryByPage(hql,startPage,pageSize, ISBN);
			
			return list;
	}

	@Override
	public Book getInfo(int bookId) {
		
		return get(Book.class,bookId);
	}

	@Override
	public int getCountByName(String name) {
		
		String hql="from Book  b where b.name=?0";
		
		return query(hql,name).size();
	}

	@Override
	public int getCountBySimilarName(String name) {
		
		System.out.println(name);
		
		String hql="from Book  b where b.name like ?0";
		
		return query(hql,name).size();
	}

	@Override
	public int getCountByISBN(String ISBN) {
		
		String hql="from Book  b where b.ISBN=?0";
		
		return query(hql,ISBN).size();
		
	}

	@Override
	public int getCountBySimilarISBN(String ISBN) {
       
		String hql="from Book  b where b.ISBN like ?0";
		
		return query(hql,ISBN).size();
	}
	
	

}
