package com.etaoguan.wea.service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.GuestBook;

public interface IGuestBookService {
	
	@SuppressWarnings("rawtypes")
	public DataSet listGuestBooks(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public void addGuestBook(GuestBook guestBook);
	
	public void delGuestBook(long messageId);

}
