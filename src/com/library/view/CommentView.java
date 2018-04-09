package com.library.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.library.entity.Comment;


public class CommentView {

	private int id;
	private int readerId;
	private String readerName;
	private int bookId;
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
	public int getReaderId() {
		return readerId;
	}
	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}
	public String getReaderName() {
		return readerName;
	}
	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
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
	
	public static List<CommentView> convertToView(List<Comment> comments){
		
		List<CommentView> views=new ArrayList<CommentView>();
		
		for(Comment comment:comments){
			CommentView view=new CommentView();
			view.setId(comment.getId());
			view.setBookId(comment.getBookId().getId());
			view.setReaderId(comment.getReaderId().getId());
			view.setReaderName(comment.getReaderId().getName());
			view.setContent(comment.getContent());
			view.setCommentDate(comment.getCommentDate());
			view.setUp(comment.getUp());
			view.setDown(comment.getDown());
			views.add(view);
		}
		return views;
		
	}
	
	
	
}
