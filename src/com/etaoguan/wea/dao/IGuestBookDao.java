package com.etaoguan.wea.dao;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.GuestBook;

public interface IGuestBookDao {
	
	@SuppressWarnings("rawtypes")
	public DataSet getGuestBooks(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public void addGuestBook(GuestBook guestBook);
	
	public void delGuestBook(DataCriteria dataCriteria);

}
