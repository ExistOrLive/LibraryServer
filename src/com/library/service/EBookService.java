package com.library.service;

import java.util.List;

import com.library.entity.EBook;
import com.library.view.BookView;

public interface EBookService {
	
	public void addEBook(EBook entity);
	
	public List<EBook> getByName(String name,int type,int startPage,int pageSize);
	
	public int getCountByName(String name,int type);

	public  EBook getInfo(int Id);
}
