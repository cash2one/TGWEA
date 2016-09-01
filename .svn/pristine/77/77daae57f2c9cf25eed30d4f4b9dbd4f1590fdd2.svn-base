package com.etaoguan.wea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IGuestBookDao;
import com.etaoguan.wea.service.IGuestBookService;
import com.etaoguan.wea.vo.GuestBook;

@Service("guestBookService")
public class GuestBookService  extends BaseService implements IGuestBookService {

	@Autowired
	private IGuestBookDao iGuestBookDao;
	
	@Override
	public void addGuestBook(GuestBook guestBook) {
		guestBook.setCreateBy(getCurrentOperator());
		guestBook.setUpdateBy(getCurrentOperator());
		iGuestBookDao.addGuestBook(guestBook);

	}

	@Override
	@SuppressWarnings("rawtypes")
	public DataSet listGuestBooks(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {

		return iGuestBookDao.getGuestBooks(dataCriteria, offsetRequest);
	}

	@Override
	public void delGuestBook(long messageId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("messageId",messageId);
		iGuestBookDao.delGuestBook(dataCriteria);
	}

}
