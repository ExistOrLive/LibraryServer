package com.library.service.impl;

import com.library.DAO.IReaderDAO;
import com.library.entity.Reader;
import com.library.service.ReaderService;
import com.library.view.ReaderView;


public class ReaderServiceImpl implements ReaderService {

    private IReaderDAO readerDAO;
    
    public IReaderDAO getReaderDAO() {
		return readerDAO;
	}

	public void setReaderDAO(IReaderDAO readerDAO) {
		this.readerDAO = readerDAO;
	}

	@Override
	public int loginByName(Reader baseBean) {
		
		String name=baseBean.getName();
		String password=baseBean.getPassword();
	   
		Reader reader=readerDAO.getByName(name);
		
		if(reader==null)
			return -1;                             //-1.当前用户未注册
		else{ 
	      
	       if(password.equals(reader.getPassword())){
	    	   return reader.getId();                          //1.密码正确
	       }else                                  
	    	   return -2;                          //-2.密码错误
		   
		}
		
	}

	@Override
	public int loginByTelNum(Reader baseBean) {
		
		String telNum=baseBean.getTelNum();
		String password=baseBean.getPassword();
		
		Reader reader=readerDAO.getByTelNum(telNum);
			
		if(reader==null)
			return -1;                             //-1.当前用户未注册
		else{ 
	       
	       if(password.equals(reader.getPassword())){
	    	   return reader.getId();                          //1.密码正确
	       }else                                  
	    	   return -2;                          //-2.密码错误
		   
		}
	}

	@Override
	public int register(Reader baseBean){
		
		String name=baseBean.getName();
		String telNum=baseBean.getTelNum();
		
		
		if(readerDAO.getByName(name)!=null||readerDAO.getByTelNum(telNum)!=null)
			return -1;                        //-1.当前用户已注册
		else{
			readerDAO.save(baseBean);
			   return 1;                          //1.注册成功
		}
			
	}

	@Override
	public ReaderView getInfo(int readerId) {
	
		Reader reader=readerDAO.get(Reader.class, readerId);
		
		ReaderView view=new ReaderView();
		view.setId(reader.getId());
		view.setName(reader.getName());
		view.setStuNum(reader.getStuNum());
		view.setTelNum(reader.getTelNum());
		
		return view;
	}

	@Override
	public boolean changePassword(Reader baseBean,String newPassword) {
		
		Reader reader=readerDAO.get(Reader.class, baseBean.getId());
		
		if(reader.getPassword().equals(baseBean.getPassword())){
			
			reader.setPassword(newPassword);
			
			readerDAO.update(reader);
	
			return true;
			
		}else
		    return false;
	}
	
	

	
	
	
	
	
	

	
	
	
}
