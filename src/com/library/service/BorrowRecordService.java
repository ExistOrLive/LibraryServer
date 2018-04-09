package com.library.service;

import java.util.List;

import com.library.entity.BorrowRecord;
import com.library.view.RecordView;

public interface BorrowRecordService  {

	public void borrow(BorrowRecord baseBean);
	
	public void returnBack(int recordId);
	
	public void renew(BorrowRecord baseBean);
	
	public List<BorrowRecord> getByBookId(int bookId,int startPage,int pageSize);
	
	public int getCountByBookId(int bookId);
	
	public int getCountByReaderId(int readerId);
	
	public List<RecordView> getByReaderId(int readerId,int startPage,int pageSize);
	
	public List<RecordView> getCurrentReadByReaderId(int readerId);
	
	
	
}
