package com.library.DAO.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.library.DAO.IDAO;

public class IDAOImpl<T> implements IDAO<T> {
	
	private SessionFactory factory;
	//private ThreadLocal<Session> local=new ThreadLocal<Session>();
	
	

	
	public void setFactory(SessionFactory factory){
		this.factory=factory;
	}
	
	public SessionFactory getFactory(){
		return this.factory;
	}
	
	public Session getSession(){
		
	 /*	Session session=local.get();
		if(session==null){
			session=factory.openSession();
			session.setFlushMode(FlushMode.AUTO);
			local.set(session);
		}
        */   
		return factory.getCurrentSession();
	}
	

	@Override
	public T get(Class<T> clazz, Serializable id) {
		
		
        
		Session session=getSession();
		
		return (T)session.get(clazz,id);

	}

	@Override
	public Serializable save(T entity) {
		
		Session session=getSession();
		

		
		Serializable id=session.save(entity);
		
		session.flush();
		
		return id;
	}

	@Override
	public void delete(T entity) {
		  
		Session session=getSession();
		
		session.delete(entity);
		
		session.flush();
	 }

	@Override
	public void deleteById(Class<T> c, Serializable id) {
		
		Session session=getSession();
		
		session.delete(session.get(c,id));
		
		session.flush();
		
	}

	@Override
	public void update(T entity) {
		
		Session session=getSession();

		
		session.update(entity);
		
		session.flush();
		
	}

	@Override
	public List<T> findAll(Class<T> c) {
		
		Session session=getSession();
		
		String hql="from "+c.getSimpleName();
		
		return (List<T>)session.createQuery(hql).list();
	}
	
	
	public List<T> query(String hql,Object...params){
		
		Session session=getSession();
		
		Query query=session.createQuery(hql);
		
		for(int i=0;i<params.length;i++){
			query.setParameter(i+"", params[i]);
		}
		
		return (List<T>)query.list();
		
		
	}
	
    public List<T> queryByPage(String hql,int startPage,int pageSize,Object...params){
		
		Session session=getSession ();
		
		Query query=session.createQuery(hql);
		
		for(int i=0;i<params.length;i++){
			query.setParameter(i+"", params[i]);
		}
		
		query.setFirstResult((startPage-1)*pageSize).setMaxResults(pageSize);
		
		return (List<T>)query.list();
		
		
	}
    
    public int getCount(String hql){
    	
       Session session=getSession ();

		Query query=session.createQuery(hql);
		
    	long result=(Long)query.uniqueResult();
    	
    	return (int)result;
    }

	
}
