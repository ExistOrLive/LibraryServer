package com.library.service.impl;

import java.util.List;

import com.library.DAO.IEBookDAO;
import com.library.entity.EBook;
import com.library.service.EBookService;

public class EBookServiceImpl implements EBookService {
	
    private IEBookDAO eBookDAO;

     
    
	public IEBookDAO geteBookDAO() {
		return eBookDAO;
	}

	public void seteBookDAO(IEBookDAO eBookDAO) {
		this.eBookDAO = eBookDAO;
	}

	@Override
	public void addEBook(EBook entity) {
		
		eBookDAO.save(entity);
		
	}

	@Override
	public List<EBook> getByName(String name, int type, int startPage,
			int pageSize) {
		String param="";
		List<EBook> list=null;
		if(type==1){
			param=name+"%";
			list=eBookDAO.getBySimilarName(param, startPage, pageSize);
		}
		else if(type==2){
			param=name;
			list=eBookDAO.getByName(param, startPage, pageSize);
		}else if(type==3){
			param="%"+name+"%";
			list=eBookDAO.getBySimilarName(param, startPage, pageSize);
		}
		return list;
	}
	
	
	public int getCountByName(String name, int type){
		String param="";
		int count=0;
		String hql=null;
		if(type==1){
			param=name+"%";
			count=eBookDAO.getCountBySimilarName(param);
		}
		else if(type==2){
			param=name;
			count=eBookDAO.getCountByName(param);
		}else if(type==3){
			param="%"+name+"%";
			count=eBookDAO.getCountBySimilarName(param);
		}
		return count;
		
	}

	@Override
	public EBook getInfo(int Id) {
	
		return eBookDAO.get(EBook.class, Id);
	}

	
	
	
}
