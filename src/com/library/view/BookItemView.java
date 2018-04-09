package com.library.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.library.entity.BookItem;



public class BookItemView {

	private int id;
	private String callNum;     //索书号    分类号/编号
	private String barcode;     //条码号
	private String volumn;      //年卷期
	private String location;    //馆藏地
	private int status;         //状态     1 .可借    2. 已借     3.其他
	private Date returnDate;    //预计归还日期
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getVolumn() {
		return volumn;
	}
	public void setVolumn(String volumn) {
		this.volumn = volumn;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	public static List<BookItemView> convertToView(List<BookItem> list){
		
		List<BookItemView> viewList=new ArrayList<BookItemView>();
		for(BookItem item:list){
			BookItemView view=new BookItemView();
			view.setId(item.getId());
			view.setBarcode(item.getBarcode());
			view.setCallNum(item.getCallNum());
			view.setLocation(item.getLocation());
			view.setReturnDate(item.getReturnDate());
			view.setStatus(item.getStatus());
			view.setVolumn(item.getVolumn());
			viewList.add(view);
		}
		return viewList;
	}
	
     public static BookItemView convertToView(BookItem item){
		
		    BookItemView view=null;
			if(item!=null){
			   view=new BookItemView();
			    view.setId(item.getId());
			    view.setBarcode(item.getBarcode());
			view.setCallNum(item.getCallNum());
			view.setLocation(item.getLocation());
			view.setReturnDate(item.getReturnDate());
			view.setStatus(item.getStatus());
			view.setVolumn(item.getVolumn());
			}
		   return view;
	}
	
	
	
}
