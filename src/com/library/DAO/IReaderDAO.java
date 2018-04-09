package com.library.DAO;

import com.library.entity.Reader;

public interface IReaderDAO extends IDAO<Reader> {

	public Reader getByName(String name);
	
	public Reader getByTelNum(String telNum);
	
	
	
}
