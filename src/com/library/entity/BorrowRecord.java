package com.library.entity;

import java.util.Date;

public class BorrowRecord {
	
	private int id;
	private Reader readerId;                 //借阅者
 	private BookItem bookItemId;             //书的id
	private int type;                        //借阅类型  1.借阅 2.续借
	private Date borrowDate;                 //借阅时间
	private Date preReturnDate;              //预计归还时间
	private Date returnDate;                 //归还时间
	private int status;                      //当前状态 1.未还 2.已还 3.续借

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Reader getReaderId() {
		return readerId;
	}
	public void setReaderId(Reader readerId) {
		this.readerId = readerId;
	}
	public BookItem getBookItemId() {
		return bookItemId;
	}
	public void setBookItemId(BookItem bookItemId) {
		this.bookItemId = bookItemId;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bookItemId == null) ? 0 : bookItemId.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((readerId == null) ? 0 : readerId.hashCode());
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
		BorrowRecord other = (BorrowRecord) obj;
		if (bookItemId == null) {
			if (other.bookItemId != null)
				return false;
		} else if (!bookItemId.equals(other.bookItemId))
			return false;
		if (id != other.id)
			return false;
		if (readerId == null) {
			if (other.readerId != null)
				return false;
		} else if (!readerId.equals(other.readerId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BorrowRecord [id=" + id + ", readerId=" + readerId
				+ ", bookItemId=" + bookItemId + ", type=" + type
				+ ", borrowDate=" + borrowDate + ", preReturnDate="
				+ preReturnDate + ", returnDate=" + returnDate + ", status="
				+ status + "]";
	}
	
	
	

}
