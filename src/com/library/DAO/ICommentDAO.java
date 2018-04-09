package com.library.DAO;

import java.util.List;

import com.library.entity.Comment;

public interface ICommentDAO extends IDAO<Comment> {

	public List<Comment> getByBookId(int bookId,int startPage,int pageSize);
	
	public List<Comment> getByReaderId(int readerId,int startPage,int pageSize);
	
}
