package com.library.service;

import java.util.List;

import com.library.entity.Comment;
import com.library.view.CommentView;

public interface CommentService {

	public void addComment(Comment baseBean);
	
	public void deleteComment(int id);
	
	public void addUp(Comment  baseBean);
	
	public void addDown(Comment baseBean);
	
	public List<CommentView> getByBookId(int bookId,int startPage,int pageSize);
	
	public List<CommentView> getByReaderId(int ReaderId,int startPage,int pageSize);
	
	
	
}
