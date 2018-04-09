package com.library.service.impl;

import java.util.Date;
import java.util.List;

import com.library.DAO.ICollectionDAO;
import com.library.entity.Collection;
import com.library.service.CollectionService;
import com.library.view.CollectionView;

public class CollectionServiceImpl implements CollectionService{

	private ICollectionDAO collectionDAO;
	
	public void setCollectionDAO(ICollectionDAO collectionDAO){
		this.collectionDAO=collectionDAO;
	}
	
	public ICollectionDAO getCollectionDAO(){
		return collectionDAO;
	}
	
	@Override
	public void addCollection(Collection entity) {
		
		Date date=new Date();
		entity.setDate(date);
		collectionDAO.save(entity);
		
		
	}

	@Override
	public void deleteCollection(Collection entity) {
		
		collectionDAO.delete(entity);
		
	}

	@Override
	public List<CollectionView> getByReaderId(int readerId) {
		
		List<Collection> list=collectionDAO.getByReaderId(readerId);
		
		return CollectionView.convertToView(list);
		
		
	}

	
	
}
