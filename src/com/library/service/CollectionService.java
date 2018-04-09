package com.library.service;

import java.util.List;

import com.library.entity.Collection;
import com.library.view.CollectionView;

public interface CollectionService {
	
	public void addCollection(Collection entity);
	
	public void deleteCollection(Collection entity);
	
	public List<CollectionView> getByReaderId(int readerId);
	

}
