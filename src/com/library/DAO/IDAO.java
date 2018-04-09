package com.library.DAO;

import java.io.Serializable;
import java.util.List;

public interface IDAO<T> {
	
	public T get(Class<T> clazz,Serializable id);
	
	public Serializable save(T entity);
	
	public void delete(T entity);
	
	public void deleteById(Class<T> c,Serializable id);
	
	public void update(T entity);
	
	public List<T> findAll(Class<T> c);
	
	public List<T> query(String hql,Object...params);
	
	public List<T> queryByPage(String hql,int startPage,int pageSize,Object...params);
	
	public int getCount(String hql);

}
