package com.library.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.library.entity.Book;
import com.library.entity.BookItem;
import com.library.entity.BorrowRecord;



public class RecordView {
	
	
	
	private int bookId;
    private String name;                //book的书名
    private String author;              //book的责任者
    
    private String callNum;     //索书号    分类号/编号
	private String barcode;     //条码号
	private String location;    //馆藏地
    
	private int type;                        //借阅类型  1.借阅 2.续借
	private Date borrowDate;                 //借阅时间
	private Date preReturnDate;              //预计归还时间
	private Date returnDate;                 //归还时间
	private int status;                      //当前状态 1.未还 2.已还3.续借
	
	
	public RecordView(int bookId, String name, String author, String callNum,
			String barcode, String location, int type, Date borrowDate,
			Date preReturnDate, Date returnDate, int status) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.author = author;
		this.callNum = callNum;
		this.barcode = barcode;
		this.location = location;
		this.type = type;
		this.borrowDate = borrowDate;
		this.preReturnDate = preReturnDate;
		this.returnDate = returnDate;
		this.status = status;
	}
	
	public RecordView(){
		
	}


	public int getBookId() {
		return bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getCallNum() {
		return callNum;
	}


	public void setCallNum(String callNum) {
		this.callNum = callNum;
	}


	public String getBarcode() {
		return barcode;
	}


	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public Date getBorrowDate() {
		return borrowDate;
	}


	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}


	public Date getPreReturnDate() {
		return preReturnDate;
	}


	public void setPreReturnDate(Date preReturnDate) {
		this.preReturnDate = preReturnDate;
	}


	public Date getReturnDate() {
		return returnDate;
	}


	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}
	
	public static List<RecordView> convertToView(List<BorrowRecord> list){
		
		List<RecordView> views=new ArrayList<RecordView>();
		for(BorrowRecord record:list){
			RecordView view=new RecordView();
			BookItem item=record.getBookItemId();
			Book book=item.getBookId();
			view.setBookId(book.getId());
			view.setName(book.getName());
		    view.setAuthor(book.getAuthor());
		    view.setBarcode(item.getBarcode());
		    view.setCallNum(item.getCallNum());
		    view.setLocation(item.getLocation());
		    view.setType(record.getType());
		    view.setPreReturnDate(record.getPreReturnDate());
		    view.setReturnDate(record.getReturnDate());
		    view.setStatus(record.getStatus());
		    view.setBorrowDate(record.getBorrowDate());
            views.add(view);
		}
		return views;
		
	}
	
	
	

	
	

}
