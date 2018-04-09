package com.library.service;

import com.library.entity.Reader;
import com.library.view.ReaderView;



public interface ReaderService {

    public int loginByName(Reader baseBean);
    
    public int loginByTelNum(Reader baseBean);
    
    public int register(Reader baseBean);
    
    public ReaderView getInfo(int readerId);
    
    public boolean changePassword(Reader baseBean,String newPassword);
    
   
	
}
