package com.library.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.library.entity.Collection;

public class CollectionView {

	private int id;
	private int bookId;
	private String bookName;
	private int readerId;
	private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getReaderId() {
		return readerId;
	}
	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public static List<CollectionView> convertToView(List<Collection> list){
		List<CollectionView> list1=new ArrayList<CollectionView>();
		for(int i=0;i<list.size();i++){
			CollectionView view=new CollectionView();
			Collection collection=list.get(i);
			view.setId(collection.getId());
			view.setReaderId(collection.getReaderId().getId());
			view.setBookId(collection.getBookId().getId());
			view.setBookName(collection.getBookId().getName());
			view.setDate(collection.getDate());
			list1.add(view);
		}
		return list1;
	}
	
	
	
}
