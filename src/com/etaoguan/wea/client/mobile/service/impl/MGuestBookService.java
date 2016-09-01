package com.etaoguan.wea.client.mobile.service.impl;

import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.mobile.service.IMGuestBookService;
import com.etaoguan.wea.client.mobile.vo.GuestBookSearch;
import com.etaoguan.wea.client.mobile.vo.MPage;
import com.etaoguan.wea.client.mobile.vo.MPagingRequest;
import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.service.impl.GuestBookService;

@Service("mguestBookService")
public class MGuestBookService extends GuestBookService implements IMGuestBookService{


	@Override
	@SuppressWarnings("rawtypes")
	public MPage listGuestBooks(GuestBookSearch guestBookSearch,
			SortParam sortParam, MPagingRequest mpagingRequest) {
		OffsetRequest offsetRequest = mpagingRequest.format2OffsetRequest();
		DataCriteria dataCriteria = DataCriteria.parseObjProp2Params(guestBookSearch);
		dataCriteria.extractSortParam(sortParam);
		DataSet dataSet = listGuestBooks(dataCriteria, offsetRequest);
		return new MPage(mpagingRequest,dataSet);
	}

}
