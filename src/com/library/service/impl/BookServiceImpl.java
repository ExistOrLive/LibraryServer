package com.library.service.impl;

import java.util.List;

import com.library.DAO.IBookDAO;
import com.library.entity.Book;
import com.library.service.BookService;
import com.library.view.BookView;

public class BookServiceImpl  implements BookService{
	
	private IBookDAO bookDAO;
	
	public IBookDAO getBookDAO() {
		return bookDAO;
	}

	public void setBookDAO(IBookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

public List<BookView> getByName(String name,int type,int startPage,int pageSize){
		
	     String param=null;
	     List<Book> list=null;
	     if(type==1){                                       //1.前向一致
			param=name+"%";
			list=bookDAO.getBySimilarName(param, startPage, pageSize);
		}                                                  
		else if(type==2){                                 //2.完全一致
			
			param=name;
			list=bookDAO.getByName(param, startPage, pageSize);
		}
		else {                                //3.任意匹配
		  
		    param="%"+name+"%";
		    list=bookDAO.getBySimilarName(param, startPage, pageSize);
		}
		return BookView.convertToView(list);
		
	}
	
	public List<BookView> getByISBN(String ISBN,int type,int startPage,int pageSize){
		

        String param=null;
        List<Book> list=null;
		 
		if(type==1){                                       //1.前向一致
			 param=ISBN+"%";
			 list=bookDAO.getBySimilarISBN(param, startPage, pageSize);
		}                                                  
		else if(type==2){                                 //2.完全一致
		     param=ISBN;
			 list=bookDAO.getByISBN(param, startPage, pageSize);
			
		}
		else {                                //3.任意匹配
	         param="%"+ISBN+"%";
	        list=bookDAO.getBySimilarISBN(param, startPage, pageSize);
		}
		
		return BookView.convertToView(list);
	}

	@Override
	public int getCountByName(String name, int type) {

        String param=null;
        int result=0;
		 
		if(type==1){                                       //1.前向一致
			
			 param=name+"%";
			 result=bookDAO.getCountBySimilarName(param);
			
		}                                                  
		else if(type==2){                                 //2.完全一致
			param=name;
			result=bookDAO.getCountByName(param);
		}
		else {                                //3.任意匹配
		    param="%"+name+"%";
		    result=bookDAO.getCountBySimilarName(param);
		}
		return result;
	}

	@Override
	public int getCountByISBN(String ISBN, int type) {
		
	
        String param=null;
        int result=0;
		 
		if(type==1){                                       //1.前向一致
			 param=ISBN+"%";
			 result=bookDAO.getCountBySimilarISBN(param);
		}                                                  
		else if(type==2){                                 //2.完全一致
			param=ISBN;
			result=bookDAO.getCountByISBN(param);
			
		}
		else{                                //3.任意匹配
		    param="%"+ISBN+"%";
		    result=bookDAO.getCountBySimilarISBN(param);
		}
		return result;
	
	}
	
	public BookView getInfo(int bookId){
		
		Book book=bookDAO.get(Book.class,bookId);
		if(book!=null)
			return BookView.convertToView(book);
		else
		    return null;
	}
	
	
	
}
