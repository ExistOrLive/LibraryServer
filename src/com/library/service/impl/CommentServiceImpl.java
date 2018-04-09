package com.library.service.impl;

import java.util.Date;
import java.util.List;

import com.library.DAO.ICommentDAO;
import com.library.entity.Comment;
import com.library.service.CommentService;
import com.library.view.CommentView;

public class CommentServiceImpl implements  CommentService {

	private ICommentDAO commentDAO;
	
	
	
	
	public ICommentDAO getCommentDAO() {
		return commentDAO;
	}

	public void setCommentDAO(ICommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}


	@Override
	public void addComment(Comment baseBean) {
	     
		Date date=new Date();
		baseBean.setCommentDate(date);
		commentDAO.save(baseBean);
		
		
	}

	@Override
	public void deleteComment(int id) {
		
		commentDAO.deleteById(Comment.class, id);
		
		
	}

	@Override
	public void addUp(Comment baseBean) {
		
		Comment comment=commentDAO.get(Comment.class,baseBean.getId());
		if(comment!=null){
		comment.setUp(comment.getUp()+1);
		commentDAO.update(comment);
		}
	}

	@Override
	public void addDown(Comment baseBean) {

		Comment comment=commentDAO.get(Comment.class,baseBean.getId());
		if(comment!=null){
		comment.setDown(comment.getDown()+1);
		commentDAO.update(comment);
		}
	}

	@Override
	public List<CommentView> getByBookId(int bookId, int startPage, int pageSize) {
		
		
		List<Comment> list= commentDAO.getByBookId(bookId, startPage, pageSize);
		
		return CommentView.convertToView(list);
		
	
	}

	@Override
	public List<CommentView> getByReaderId(int readerId, int startPage, int pageSize) {
		
		List<Comment> list= commentDAO.getByReaderId(readerId, startPage, pageSize);
		
		return CommentView.convertToView(list);
	}
	
	

	
	
	
}
