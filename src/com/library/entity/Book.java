package com.library.entity;

import java.util.HashSet;
import java.util.Set;

public class Book {
    
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
     private Set<BookItem> items=new HashSet<BookItem>();
     private Set<Comment> comments=new HashSet<Comment>();
     
     
     
	public Set<BookItem> getItems() {
		return items;
	}
	public void setItems(Set<BookItem> items) {
		this.items = items;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
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
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ISBN == null) ? 0 : ISBN.hashCode());
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (ISBN == null) {
			if (other.ISBN != null)
				return false;
		} else if (!ISBN.equals(other.ISBN))
			return false;
		if (id != other.id)
			return false;
		return true;
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
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author
				+ ", series=" + series + ", publisher=" + publisher
				+ ", price=" + price + ", binding=" + binding + ", ISBN="
				+ ISBN + ", subject=" + subject + ", classification="
				+ classification + ", ab=" + ab + ", douban_Ab=" + douban_Ab
				+ "]";
	}
	
     
	
}
