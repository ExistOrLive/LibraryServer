package com.library.DAO.impl;

import java.io.Serializable;
import java.util.List;

import com.library.DAO.ICommentDAO;
import com.library.entity.Comment;

public class ICommentDAOImpl extends IDAOImpl<Comment> implements ICommentDAO {

	
	@Override
	public List<Comment> getByBookId(int bookId,int startPage,int pageSize) {
		
		String hql="from Comment c where c.bookId.id=?0";
		
		return queryByPage(hql,startPage,pageSize,bookId);
		
	}

	@Override
	public List<Comment> getByReaderId(int readerId,int startPage,int pageSize) {
		

		String hql="from Comment c where c.readerId.id=?0";
		
		return queryByPage(hql,startPage,pageSize,readerId);
	}

}
