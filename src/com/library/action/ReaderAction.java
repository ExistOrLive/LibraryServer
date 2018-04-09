package com.library.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.json.annotations.JSON;

import com.library.entity.Reader;
import com.library.service.ReaderService;
import com.library.view.ReaderView;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class ReaderAction  extends BaseAction implements ModelDriven<Reader>,Action{


	private Reader reader;
	private String newPassword;

	


	private ReaderService readerService;
	
	//响应结果
	private int result=0;
	private ReaderView readerInfo;
	
	
	

	
	


	public void setNewPassword(String newPassword1) {
		this.newPassword = newPassword1;
	}

	
	public ReaderView getReaderInfo(){
		return readerInfo;
	}
   
	public int getResult() {
		return result;
	}

    @JSON(serialize=false)
	public Reader getModel(){
		
		if(reader==null)
			reader=new Reader();
		return reader;
	}

   
	public void setReaderService(ReaderService readerService) {
		this.readerService = readerService;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;  
	}
	
	
	
	public String login() throws Exception{
		
	   init();
		
	   System.out.println(reader);
		
	   int result;
	   
	   if(reader.getName()!=null)
		 result=readerService.loginByName(reader);
	   else 
		  result=readerService.loginByTelNum(reader); 
		if(result==-1){
			this.result=LOGIN_NOREADER;
		
		}
		else if(result==-2){
			this.result=LOGIN_ERRORPASSWORD;
			
		}
		else{
			HttpSession session=request.getSession();
			this.result=LOGIN_SUCCESS;
			readerInfo=readerService.getInfo(result);
			
			session.setAttribute("readerId", result);

		}
		return SUCCESS;
		
	}
	
	public String register() throws Exception{
		
		init();
		
		System.out.println(reader+"register>>>>");
		
		int res=readerService.register(reader);
		
		System.out.println(res);
		
		switch(res){
		   case -1:result=REGISTER_READEREXIST; break;
		   case 1:result=REGISTER_SUCCESS;break;
		
		}
		
		System.out.println(result);
		
		return SUCCESS;
		
	}
	
	public String logout()throws Exception{
		
		init();
		
		HttpSession session=request.getSession();
		System.out.println(session.getId());
		Object obj=session.getAttribute("readerId");
		System.out.println((Integer)obj);
		System.out.println(reader.getId());
		if(obj==null||(Integer)obj!=reader.getId()){
			result=NOLOGIN;
			return SUCCESS;
		}

		session.removeAttribute("readerId");
		result=LOGOUT_SUCCESS;
		return SUCCESS;
		
	}
	
	public String Info()throws Exception{
		
		init();
		
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("readerId");
		if(obj==null||(Integer)obj!=reader.getId()){
			result=NOLOGIN;
			return SUCCESS;
		}
		
		readerInfo=readerService.getInfo(reader.getId());
		
		result=QUERY_SUCCESS;
		
		return SUCCESS;
		
	}
	
	public String changePassword()throws Exception{
		
		init();
		
		System.out.println(newPassword);
		
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("readerId");
		if(obj==null||(Integer)obj!=reader.getId()){
			result=NOLOGIN;
			return SUCCESS;
		}
		
		if(readerService.changePassword(reader,newPassword))
			result=PASSWORD_SUCCESS;
	    else
	    	result=PASSWORD_ERRORPASSWORD;
		
	
		return SUCCESS;
		
	}
	
	private void init(){
		readerInfo=null;
		result=0;
	}
		
	

}
