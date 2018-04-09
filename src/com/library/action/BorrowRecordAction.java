package com.library.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.json.annotations.JSON;

import com.library.entity.BorrowRecord;
import com.library.service.BorrowRecordService;
import com.library.view.RecordView;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class BorrowRecordAction extends BaseAction implements ModelDriven<BorrowRecord>,Action {

	private BorrowRecord borrowRecord;
	
	private BorrowRecordService borrowRecordService;
	
	private List<RecordView> records=null;
	private int result;
	private int count;
	
	private final int NOLOGIN=6;
	private final int RECORD_SUCCESS=12;
	
	public List<RecordView> getRecords(){
		return records;
	}
	public int getResult(){
		return result;
	}
	public int getCount(){
		return count;
	}
	@JSON(serialize=false)
	public BorrowRecord getModel(){
		if(borrowRecord==null)
			borrowRecord=new BorrowRecord();
		return borrowRecord;
	}
	
	public void setBorrowRecordService(BorrowRecordService borrowRecordService)
	{
		this.borrowRecordService=borrowRecordService;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String borrow()throws Exception{
		init();
		borrowRecordService.borrow(borrowRecord);
		result=RECORD_SUCCESS;
		
		return SUCCESS;
	}
	
	public String returnBack() throws Exception{
		init();
		borrowRecordService.returnBack(borrowRecord.getBookItemId().getId());
		result=RECORD_SUCCESS;
		return SUCCESS;
	}
	
	public String renew()throws Exception{
		init();
		borrowRecordService.renew(borrowRecord);
		result=RECORD_SUCCESS;
		return SUCCESS;
	}
	
	public String listCurrent(){
		init();
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("readerId");
		if(obj==null||borrowRecord.getReaderId()==null||(Integer)obj!=borrowRecord.getReaderId().getId()){
			result=NOLOGIN;	
	    }else{
		     records=borrowRecordService.getCurrentReadByReaderId(borrowRecord.getReaderId().getId());
		     count=records.size();
		 	result=RECORD_SUCCESS;
	    }
		return SUCCESS;
	}
	
	public String list(){
		init();
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("readerId");
		if(obj==null||borrowRecord.getReaderId()==null||(Integer)obj!=borrowRecord.getReaderId().getId()){
			result=NOLOGIN;	
	    }else{
		     records=borrowRecordService.getByReaderId(borrowRecord.getReaderId().getId(),startPage,pageSize);
		     count=borrowRecordService.getCountByReaderId(borrowRecord.getReaderId().getId());
		 	 result=RECORD_SUCCESS;
	    }
		return SUCCESS;
	}
	
	public String countByBookId(){
		init();
		count=borrowRecordService.getCountByBookId(borrowRecord.getBookItemId().getBookId().getId());
		result=RECORD_SUCCESS;
		return SUCCESS;
	}

	private void init(){{
	   records=null;
	   count=0;
	    result=0;
	}
		
	}
	
}
