package com.library.view;

import java.util.ArrayList;
import java.util.List;

import com.library.entity.Book;

public class BookView {
	
	 private int id;                     
     private String name;                //book的书名
     private String author;              //book的作者
     private String series;              //book的从数编
     private String publisher;           //book的出版信息
     private double price;               //book的定价
     private String binding;             //book的装帧
     private String ISBN;                //book的ISBN
     private String subject;             //book的学科主题
     private String classification;      //book的分类号
     private String ab;             //book的简介
     private String douban_Ab;           //豆瓣的简介
     
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBinding() {
		return binding;
	}
	public void setBinding(String binding) {
		this.binding = binding;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public String getAb() {
		return ab;
	}
	public void setAb(String ab) {
		this.ab = ab;
	}
	public String getDouban_Ab() {
		return douban_Ab;
	}
	public void setDouban_Ab(String douban_Ab) {
		this.douban_Ab = douban_Ab;
	}
	
	public static BookView convertToView(Book book){
		
	

			BookView view=null;
			if(book!=null){
			view=new BookView();
			view.setId(book.getId());
			view.setName(book.getName());
			view.setAuthor(book.getAuthor());
			view.setSeries(book.getSeries());
			view.setPublisher(book.getPublisher());
			view.setPrice(book.getPrice());
			view.setBinding(book.getBinding());
			view.setISBN(book.getISBN());
			view.setSubject(book.getSubject());
			view.setClassification(book.getClassification());
			view.setAb(book.getAb());
			view.setDouban_Ab(book.getDouban_Ab());
			}
		    return view;
		
		
		
	}
	
	public static List<BookView> convertToView(List<Book> list){
		
		
		List<BookView> viewList=new ArrayList<BookView>();
		
		for(Book book:list){
       
		BookView view=new BookView();
		view.setId(book.getId());
		view.setName(book.getName());
		view.setAuthor(book.getAuthor());
		view.setSeries(book.getSeries());
		view.setPublisher(book.getPublisher());
		view.setPrice(book.getPrice());
		view.setBinding(book.getBinding());
		view.setISBN(book.getISBN());
		view.setSubject(book.getSubject());
		view.setClassification(book.getClassification());
		view.setAb(book.getAb());
		view.setDouban_Ab(book.getDouban_Ab());
		 viewList.add(view);
		}
	
	    return viewList;
	}
     
     
	

}
