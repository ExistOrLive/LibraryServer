package com.library.entity;

import java.util.Date;

public class Comment {
	
	private int id;
	private Reader readerId;
	private Book bookId;
	private String content;
	private Date commentDate;
	private int up;
	private int down;
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
	public Book getBookId() {
		return bookId;
	}
	public void setBookId(Book bookId) {
		this.bookId = bookId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public int getUp() {
		return up;
	}
	public void setUp(int up) {
		this.up = up;
	}
	public int getDown() {
		return down;
	}
	public void setDown(int down) {
		this.down = down;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
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
		Comment other = (Comment) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
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
		return "Comment [id=" + id + ", readerId=" + readerId + ", bookId="
				+ bookId + ", content=" + content + ", commentDate="
				+ commentDate + ", up=" + up + ", down=" + down + "]";
	}
	

}
