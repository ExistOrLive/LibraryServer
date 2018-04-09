package com.library.DAO.impl;

import java.io.Serializable;
import java.util.List;

import com.library.DAO.IBorrowRecordDAO;
import com.library.entity.BorrowRecord;

public class IBorrowRecordDAOImpl extends IDAOImpl<BorrowRecord> implements
		IBorrowRecordDAO {
	
	


	@Override
	public List<BorrowRecord> getByReaderId(int readerId, int startPage,
			int pageSize) {
		
		String hql="from BorrowRecord r where r.readerId.id=?0";
		
		return queryByPage(hql,readerId,startPage,pageSize);
	}

	@Override
	public List<BorrowRecord> getCurrentReadByReaderId(int readerId) {
		
		String hql="from BorrowRecord r where r.readerId.id=?0 and r.status=1";
		return query(hql,readerId);
	}

	
	@Override
	public BorrowRecord getFirstRecordByBookItemId(int bookItemId) {
		
		String hql="from BorrowRecord r where r.bookItemId.id=?0 and r.status=1";
		List list=query(hql,bookItemId);
		if(list.size()==0)
			return null;
		else 
			return (BorrowRecord)list.get(0);
	}

	@Override
	public int getCountByBookId(int bookId) {
		
		String hql="select count(*) from BorrowRecord r where r.bookItemId.bookId.id="+bookId+" and type=1";
		
		return getCount(hql);
		
		
	}
	
	public int getCountByReaderId(int readerId){
		
        String hql="select count(*) from BorrowRecord r where r.readerId.id="+readerId;
		
		return getCount(hql);
		
	}
	
	
}



