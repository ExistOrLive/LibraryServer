package com.library.DAO;

import java.util.List;

import com.library.entity.Collection;

public interface ICollectionDAO extends IDAO<Collection>{
	
	List<Collection> getByReaderId(int readerId); 
	
}
