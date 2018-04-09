package com.library.action;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class DownloadAction extends BaseAction implements Action{

	
	private String downloadURL;
	
	
	
	
	public String getDownloadURL() {
		return downloadURL;
	}
    public void setDownloadURL(String downloadURL) {
		this.downloadURL = downloadURL;
	}




	public String execute() throws Exception{
		
		System.out.println(downloadURL);
		return SUCCESS;
	}
	
	public InputStream getTargetFile() throws Exception{
		
		return ServletActionContext.getServletContext().getResourceAsStream(downloadURL);
		
	}
	
}
