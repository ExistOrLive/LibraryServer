package com.library.entity;

import java.util.HashSet;
import java.util.Set;

public class Reader {
	
	private int id;
    private String name;
    private String stuNum;
    private String password;
    private String telNum;
 
    private Set<BorrowRecord> records=new HashSet<BorrowRecord>(); 
    private Set<Comment> comments=new HashSet<Comment>();
    
    
    
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public Set<BorrowRecord> getRecords() {
		return records;
	}
	public void setRecords(Set<BorrowRecord> records) {
		this.records = records;
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
	public String getStuNum() {
		return stuNum;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelNum() {
		return telNum;
	}
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((telNum == null) ? 0 : telNum.hashCode());
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
		Reader other = (Reader) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (telNum == null) {
			if (other.telNum != null)
				return false;
		} else if (!telNum.equals(other.telNum))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reader [id=" + id + ", name=" + name + ", stuNum=" + stuNum
				+ ", password=" + password + ", telNum=" + telNum 
				+ "]";
	}
    
	
    

}
