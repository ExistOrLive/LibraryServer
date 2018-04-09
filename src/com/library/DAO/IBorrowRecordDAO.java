package com.library.DAO;

import java.util.List;

import com.library.entity.BorrowRecord;

public interface IBorrowRecordDAO extends IDAO<BorrowRecord> {
    
	public List<BorrowRecord> getByReaderId(int readerId,int startPage,int pageSize);
	
	public List<BorrowRecord> getCurrentReadByReaderId(int readerId);
	
	public BorrowRecord getFirstRecordByBookItemId(int bookItemId);
	
	public int getCountByBookId(int bookId);
	
	public int getCountByReaderId(int readerId);
	
	
	
}
