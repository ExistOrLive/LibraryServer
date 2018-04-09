package com.library.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.json.annotations.JSON;

import com.library.entity.Comment;
import com.library.service.CommentService;
import com.library.view.CommentView;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class CommentAction extends BaseAction implements Action,ModelDriven<Comment>{
    
	
	private Comment comment;
	private int key;                  //key为 1.根据ReaderId搜索，2，根据bookId搜索
	
	
	private CommentService commentService;
	
	
	
	
	private List<CommentView> comments=null;
	private int result;

	
	
	public List<CommentView> getComments(){
		return comments;
	}
	public void setKey(int key){
		this.key=key;
	}
	
	public int getResult() {
		return result;
	}


	@JSON(serialize=false)
	public Comment getModel(){
		if(comment==null){
			comment=new Comment();
		}
		return comment;
	}
	
	public void setCommentService(CommentService commentService){
		this.commentService=commentService;
	}
	
	
	public String execute()throws Exception{
		return SUCCESS;
	}
	
	public String list() throws Exception{
		
		init();
		if(key==1){
			
			HttpSession session=request.getSession();
			Object obj=session.getAttribute("readerId");
			if(obj==null||comment.getReaderId()==null||(Integer)obj!=comment.getReaderId().getId()){
				result=NOLOGIN;	
		    }else{
			comments=commentService.getByReaderId(comment.getReaderId().getId(), startPage, pageSize);
			result=QUERY_SUCCESS;
		    }
		}else if(key==2){
			
		    comments=commentService.getByBookId(comment.getBookId().getId(), startPage, pageSize);	
			result=QUERY_SUCCESS;
		}
		return SUCCESS;
	}
	
	
	public String addComment()throws Exception{
		init();
		System.out.println(comment);
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("readerId");
		if(obj==null||(Integer)obj!=comment.getReaderId().getId()||comment.getReaderId()==null){
			result=NOLOGIN;	
	    }else{
	
	        Date currentDate=new Date();
	        comment.setCommentDate(currentDate);
	        commentService.addComment(comment);
	        result=COMMENT_SUCCESS;
	    }
		
		return SUCCESS;
	}
	
	
	
	public String deleteComment(){
		init();
        HttpSession session=request.getSession();
		Object obj=session.getAttribute("readerId");
		if(obj==null||comment.getReaderId()==null||(Integer)obj!=comment.getReaderId().getId()){
			result=NOLOGIN;	
	    }else{
           commentService.deleteComment(comment.getId());
           result=COMMENT_SUCCESS;
	    }
		return SUCCESS;
	}
	
	public String addUp(){
		init();
		commentService.addUp(comment);
        result=COMMENT_SUCCESS;
		return SUCCESS;
	}
	
	public String addDown(){
		init();
		commentService.addDown(comment);
        result=COMMENT_SUCCESS;
		return SUCCESS;
	}
	
	private void init(){
		comments=null;
		result=0;
	}
	
	
}
