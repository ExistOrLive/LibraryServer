package com.library.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.library.DAO.IBookDAO;
import com.library.DAO.IBookItemDAO;
import com.library.DAO.IBorrowRecordDAO;
import com.library.entity.BookItem;
import com.library.entity.BorrowRecord;
import com.library.service.BorrowRecordService;
import com.library.view.RecordView;

public class BorrowRecordServiceImpl  implements BorrowRecordService {

   private IBorrowRecordDAO borrowRecordDAO;
   private IBookItemDAO bookItemDAO;

   
   public void setBorrowRecordDAO(IBorrowRecordDAO borrowRecordDAO) {
	this.borrowRecordDAO = borrowRecordDAO;
    }

    public void setBookItemDAO(IBookItemDAO bookItemDAO) {
	   this.bookItemDAO = bookItemDAO;
    }
   

	@Override
	public void renew(BorrowRecord baseBean) {
		
		    BorrowRecord record=borrowRecordDAO.getFirstRecordByBookItemId(baseBean.getBookItemId().getId());
			Date date=new Date();
			record.setReturnDate(date);
			record.setStatus(3);
			borrowRecordDAO.update(record);
			baseBean.setId(0);
			Calendar c=Calendar.getInstance();
			c.setTime(date);
			c.add(c.MONTH, 1);
			Date preReturnDate=c.getTime();
			baseBean.setBorrowDate(date);
			baseBean.setPreReturnDate(preReturnDate);
			baseBean.setStatus(1);                    //表示状态已借     
			baseBean.setType(2);                      //类型为续借
			borrowRecordDAO.save(baseBean); 
			BookItem item=bookItemDAO.get(BookItem.class, baseBean.getBookItemId().getId());
			item.setReturnDate(preReturnDate);
			bookItemDAO.update(item);
		
	}



	@Override
	public void borrow(BorrowRecord baseBean) {
		
		Date currentDate=new Date();
		Calendar c=Calendar.getInstance();
		c.setTime(currentDate);
		c.add(c.MONTH, 1);
		Date preReturnDate=c.getTime();
		baseBean.setBorrowDate(currentDate);
		baseBean.setPreReturnDate(preReturnDate);
		baseBean.setStatus(1);                    //表示状态已借     
		baseBean.setType(1);                      //类型为借阅
        BookItem item=bookItemDAO.get(BookItem.class, baseBean.getBookItemId().getId());
		item.setStatus(2);                         //表示这本书已借
		bookItemDAO.update(item);
		item.setReturnDate(preReturnDate);
		borrowRecordDAO.save(baseBean);
		
		
	}

	@Override
	public void returnBack(int bookItemId) {
		
		
		BorrowRecord record=borrowRecordDAO.getFirstRecordByBookItemId(bookItemId);

		Date date=new Date();
		
		record.setReturnDate(date);
		
		record.setStatus(2);
		
		borrowRecordDAO.update(record);
		
		BookItem item=bookItemDAO.get(BookItem.class, record.getBookItemId().getId());
		
		item.setStatus(1);
		
		item.setReturnDate(null);
		
		bookItemDAO.update(item);
		
	}
	

	
	@Override
	public List<BorrowRecord> getByBookId(int bookId, int startPage,
			int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountByBookId(int bookId) {
		
	     return	borrowRecordDAO.getCountByBookId(bookId);
		
	}
	
	
	public int getCountByReaderId(int readerId) {
		
	     return	borrowRecordDAO.getCountByReaderId(readerId);
		
	}
	

	@Override
	public List<RecordView> getByReaderId(int readerId, int startPage,
			int pageSize) {
	
		List<BorrowRecord> list=borrowRecordDAO.getByReaderId(startPage, pageSize,readerId);
		
		System.out.println(list.size()+"----service");
		
		return RecordView.convertToView(list);
	}

	@Override
	public List<RecordView> getCurrentReadByReaderId(int readerId) {
		
         		
		 List<BorrowRecord> list=borrowRecordDAO.getCurrentReadByReaderId(readerId);
			
		 return RecordView.convertToView(list);
	}

    
	
	

}
	
	
	
	

