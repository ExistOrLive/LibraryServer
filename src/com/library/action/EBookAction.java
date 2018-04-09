package com.library.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.library.entity.EBook;
import com.library.service.EBookService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class EBookAction extends BaseAction implements ModelDriven<EBook>,Action{
	
	private EBook eBook;
	private int type;             //type为1,2,3 1.前向一致 2.完全一致3.任意匹配
	
	private List<EBook> eBooks;
	private int count;
	
	private EBookService eBookService;
	
	@JSON(serialize=false)
	public EBook getModel(){
		if(eBook==null)
			eBook=new EBook();
		return eBook;
	}
	
	public void setType(int type) {
		this.type = type;
	}
    public List<EBook> geteBooks() {
		return eBooks;
	}
    public void seteBooks(List<EBook> eBooks) {
		this.eBooks = eBooks;
	}
    public int getCount() {
		return count;
	}
    public void setCount(int count) {
		this.count = count;
	}
    public void seteBookService(EBookService eBookService) {
		this.eBookService = eBookService;
	}
   
    @JSON(serialize=false)
    public String  execute(){
		return SUCCESS;
	}
	
	public String list(){
		
		eBooks=eBookService.getByName(eBook.getName(),type, startPage, pageSize);
		count=eBookService.getCountByName(eBook.getName(), type);
		return SUCCESS;
		
	}
	
	public String getInfo(){
		
		init();
		EBook book=eBookService.getInfo(eBook.getId());
	    eBooks=new ArrayList<EBook>();
	    if(book!=null)
		   eBooks.add(book);
		return SUCCESS;
		
	}
	
	
	private void init(){
		eBooks=null;
		count=0;
		
	}
	
	
	
	

	
	
	
}
