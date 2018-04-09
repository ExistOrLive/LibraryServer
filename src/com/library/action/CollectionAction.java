package com.library.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.json.annotations.JSON;

import com.library.entity.Collection;
import com.library.service.CollectionService;
import com.library.view.CollectionView;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class CollectionAction extends BaseAction implements ModelDriven<Collection>,Action{
	
	private Collection collection;
	
	private int result;

	private List<CollectionView> collections;
	
	private CollectionService collectionService;
	
	@JSON(serialize=false)
	public Collection getModel(){
		if(collection==null)
			collection=new Collection();
		return collection;
	}
	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	
	public List<CollectionView> getCollections() {
		return collections;
	}
	public void setCollections(List<CollectionView> collections) {
		this.collections = collections;
	}
	public void setCollectionService(CollectionService collectionService) {
		this.collectionService = collectionService;
	}

	
	public String execute(){
		return SUCCESS;
	}
	
	public String add(){
		init();
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("readerId");
		if(obj==null||collection.getReaderId()==null||(Integer)obj!=collection.getReaderId().getId()){
			result=NOLOGIN;	
	    }else{
		
		Date date=new Date();
		collection.setDate(date);
		collectionService.addCollection(collection);
		result=COLLECTION_SUCCESS;
	    }
		return SUCCESS;
	}
	public String delete(){
		init();
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("readerId");
		if(obj==null||collection.getReaderId()==null||(Integer)obj!=collection.getReaderId().getId()){
			result=NOLOGIN;	
	    }else{
		collectionService.deleteCollection(collection);
		result=COLLECTION_SUCCESS;
	    }
		return SUCCESS;
		
	}
	public String list(){
		init();
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("readerId");
		if(obj==null||collection.getReaderId()==null||(Integer)obj!=collection.getReaderId().getId()){
			result=NOLOGIN;	
	    }else{
		collections=collectionService.getByReaderId(collection.getReaderId().getId());
		result=QUERY_SUCCESS;
	    }
		return SUCCESS;
	}
	
	private void init(){
		result=0;
		collections=null;
	}
	
	
	
	

}
