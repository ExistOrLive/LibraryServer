package com.library.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

public class BaseAction implements ServletRequestAware,ServletResponseAware{

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected int startPage=1;
	protected int pageSize=10;
	
	public static  final int  LOGIN_SUCCESS=1;
	public static  final int  LOGIN_NOREADER=2;
	public static  final int  LOGIN_ERRORPASSWORD=3;
	public static  final int REGISTER_SUCCESS=4;
	public static  final int REGISTER_READEREXIST=5;
	public static  final int NOLOGIN=6;
	public static  final int PASSWORD_ERRORPASSWORD=7;
	public static  final int PASSWORD_SUCCESS=8;
	public static  final int LOGOUT_SUCCESS=9;
	public static  final int QUERY_SUCCESS=10;
	public static  final int COMMENT_SUCCESS=11;
	public static  final int RECORD_SUCCESS=12;
	public static  final int COLLECTION_SUCCESS=13;
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		
		this.request=request;
		
	}
	
	@Override
	public void setServletResponse(HttpServletResponse response){
		
		this.response=response;
		
	}

	
	
	
}
