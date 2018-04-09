package com.library.action;


import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.library.entity.BookItem;
import com.library.service.BookItemService;
import com.library.view.BookItemView;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class BookItemAction extends BaseAction implements Action,ModelDriven<BookItem>{

	private BookItem bookItem;
	
	private BookItemService bookItemService;
	
	private List<BookItemView> bookItems=null;
	private int count=0;
	
	@JSON(serialize=false)
	public  BookItem getModel(){
		if(bookItem==null){
			bookItem=new BookItem();
		}
		return bookItem;
	}
	
	public void setBookItemService(BookItemService bookItemService){
		this.bookItemService=bookItemService;
	}
	
	public String execute()throws Exception{
		return SUCCESS;
	}
	
	
	
	public List<BookItemView> getBookItems() {
		return bookItems;
	}


	public int getCount() {
		return count;
	}

	public String list() throws Exception{
		
		if(bookItem.getBookId()!=null){
		   bookItems=bookItemService.getItemsByBookId(bookItem.getBookId().getId());	
		   count=bookItemService.getItemsCountByBookId(bookItem.getBookId().getId());
		}
		
		return SUCCESS;
		
	}
	
	private void init(){
		
		bookItems=null;
		count=0;
	}
	
	
	
}
