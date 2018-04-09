package com.library.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

import com.library.entity.Book;
import com.library.entity.BookItem;
import com.library.entity.Comment;
import com.library.service.BookService;
import com.library.view.BookView;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class BookAction extends BaseAction implements ModelDriven<Book>,Action{
	
	
	//请求参数
	private Book book;
    private int type;    //查询方式  前向一致，完全一致
    private int key;    //查询方式 书名/ISBN       
	
	//逻辑处理单元
	private BookService bookService;
	
	//响应数据
	private List<BookView> books;
	private int count;
	
	
	
   


	

	public void setKey(int key) {
		this.key = key;
	}

	public List<BookView> getBooks(){
		return books;
	}
	
	public void setType(int type){
		this.type=type;
	}
	
	
	@JSON(serialize=false)
	public Book getModel(){
		if(book==null)
			book=new Book();
		return book;
	}
	
	public void setBookService(BookService bookService){
		this.bookService=bookService;
	}
	
    
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String  execute(){
		return SUCCESS;
	}
	
	
	
	public String list() throws Exception{
		
        init();
		String name=book.getName();
		String ISBN=book.getISBN();

		if(key==1){                                                       //根据name查询
		    count=bookService.getCountByName(name, type);
			books=bookService.getByName(name, type,startPage,pageSize);
		}else if(key==2){                                                 //根据isbn查询
			count=bookService.getCountByISBN(ISBN, type);
			books=bookService.getByISBN(ISBN,type,startPage,pageSize);
		}
		
	    
		
		return SUCCESS;
	}
	
	public String info() throws Exception{
		
		init();
		BookView book=bookService.getInfo(this.book.getId());
	    books=new ArrayList<BookView>();
	    if(book!=null)
		   books.add(book);
		return SUCCESS;
	}
	
	
    private void init(){
    	books=null;
    	count=0;
    }
	

}
