package com.library.DAO;

import java.util.List;

import com.library.entity.EBook;

public interface IEBookDAO extends IDAO<EBook>{
	
	public List<EBook> getByName(String name,int startPage,int pageSize);
	 
	public List<EBook> getBySimilarName(String name,int startPage,int pageSize );
	
	public int getCountByName(String name);
	
	public int getCountBySimilarName(String name);
	
	
	

}
